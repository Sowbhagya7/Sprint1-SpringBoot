package com.casestudy.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.casestudy.Entity.BuyBook;

@Service
public class KafkaConsumerListener {

	
	private static final String TOPIC = "kafka-newtopic";

    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(BuyBook book) {
        System.out.println("Consumed JSON Message: " + book);
    }

}