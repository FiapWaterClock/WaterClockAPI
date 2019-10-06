package br.com.waterclock.api.initialize;

import br.com.waterclock.api.config.MqttConfig;
import br.com.waterclock.api.entity.Clock;
import br.com.waterclock.api.entity.Consumption;
import br.com.waterclock.api.model.ConsumptionModel;
import br.com.waterclock.api.repository.ClockRepository;
import br.com.waterclock.api.repository.ConsumptionRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class MqttPoller implements
        ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    private static final Logger logger = LoggerFactory.getLogger(MqttPoller.class);

    @Autowired
    private ConsumptionRepository repository;

    @Autowired
    private ClockRepository clockRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) return;
        startPolling();
        alreadySetup = true;
    }

    private void startPolling() {
        logger.info("starting polling");
        MqttConfig config = new MqttConfig();
        try {

            MqttClient client = config.client();
            MqttConnectOptions options = config.connectOptions();

            client.setCallback(new MqttCallback() {

                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("Connection to MQTT broker lost!");
                }

                @Override
                public void messageArrived(String topic, MqttMessage mqttMessage) {
                    saveConsumption(topic, mqttMessage);

                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });
            client.connect(options);

            client.subscribe(config.getTopic());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void saveConsumption(String topic, MqttMessage mqttMessage) {
        try {
            logger.info("Message received from: " + topic + "\n\t" + new String(mqttMessage.getPayload()));

            ObjectMapper obj = new ObjectMapper();
            ConsumptionModel consumptionModel = obj.readValue(mqttMessage.getPayload(), ConsumptionModel.class);


            Clock clock = clockRepository.findById(consumptionModel.getClockId());
            Consumption consumption = new Consumption(clock, consumptionModel.getLitersPerMinute());
            repository.save(consumption);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
