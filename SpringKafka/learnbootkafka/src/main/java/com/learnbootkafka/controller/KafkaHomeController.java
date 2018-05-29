package com.learnbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnbootkafka.producer.ProducerKafka;

@RestController
public class KafkaHomeController {
	
	@Autowired
	ProducerKafka produce;
	
	@RequestMapping(value="/home")
	public String publishMessage(@RequestParam("message") String message){
		produce.sendMessage(message);
		return "Hello Testing Spring Kafka Integration";
	}
}
