package com.dk.learn.apache.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerKafka {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
		
		try{
			for(int i = 10; i <20; i++){
				producer.send(new ProducerRecord<String, String>("my-second-topic", "Message Payload : "+i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			producer.close();
		}
	}

}
