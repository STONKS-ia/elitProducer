package com.br.elit.elitProducer.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ElitProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ElitProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String sku, String nome) {
        kafkaTemplate.send("elit.producer", sku, nome);
    }
}
