package br.com.waterclock.api.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    private String topic;
    private String host;
    private int port;

    private String username;
    private String password;

    public MqttConfig() {
        this.topic = "fiap/waterclock/sensor/flow";
        this.host = "soldier.cloudmqtt.com";
        this.port = 16925;
        this.username = "inkphijn";
        this.password = "F1QexKFsttXE";
    }

    public MqttConnectOptions connectOptions(){
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        return options;
    }

    public MqttClient client() throws MqttException {
        return new MqttClient(String.format("tcp://%s:%d", host, port),
                MqttClient.generateClientId(), new MemoryPersistence());
    }

    public String getTopic() {
        return topic;
    }
}