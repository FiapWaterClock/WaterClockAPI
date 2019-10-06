package br.com.waterclock.api.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    private String topic;
    private String host;
    private int port;

    @Value("${mqtt.username}")
    private String mqttUsername;

    @Value("${mqtt.password}")
    private String mqttPassword;

    public MqttConfig() {
        this.topic = "fiap/waterclock/sensor/flow";
        this.host = "soldier.cloudmqtt.com";
        this.port = 16925;
        mqttUsername = System.getenv("MQTT_USERNAME");
        mqttPassword = System.getenv("MQTT_PASSWORD");

    }

    @Bean
    public MqttConnectOptions connectOptions(){
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(mqttUsername);
        options.setPassword(mqttPassword.toCharArray());
        return options;
    }

    @Bean
    public MqttClient client() throws MqttException {
        return new MqttClient(String.format("tcp://%s:%d", host, port),
                MqttClient.generateClientId(), new MemoryPersistence());
    }

    public String getTopic() {
        return topic;
    }
}