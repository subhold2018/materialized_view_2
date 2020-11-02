package com.lumendata.listener;

import com.lumendata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Component
public class MessageListener {

    @Autowired
    CustomerService customerService;

    @KafkaListener(topics = "${general.mv.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenConsumerGroup(String message) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        customerService.processMessage(message);
    }
}