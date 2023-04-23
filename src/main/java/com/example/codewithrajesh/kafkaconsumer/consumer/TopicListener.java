package com.example.codewithrajesh.kafkaconsumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {


    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${consumer.group.name}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("==========================================================");
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Message: {}", payload.value());
        log.info("===========================================================");
    }

}
