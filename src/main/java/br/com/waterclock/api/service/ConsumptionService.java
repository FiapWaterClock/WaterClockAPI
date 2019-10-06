package br.com.waterclock.api.service;

import br.com.waterclock.api.entity.Clock;
import br.com.waterclock.api.entity.Consumption;
import br.com.waterclock.api.model.ConsumptionModel;
import br.com.waterclock.api.repository.ClockRepository;
import br.com.waterclock.api.repository.ConsumptionRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumptionService {
    @Autowired
    private ConsumptionRepository repository;

    @Autowired
    private ClockRepository clockRepository;




}
