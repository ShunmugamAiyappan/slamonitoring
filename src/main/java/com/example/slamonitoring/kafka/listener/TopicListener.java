package com.example.slamonitoring.kafka.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TopicListener {
  @Autowired
  ObjectMapper mapper;

  @KafkaListener(id = "${kafka.topicName}", topics = "${kafka.topicName}", containerFactory = "kafkaListenerContainerFactory")
  void consumeSLAMonitoring(ConsumerRecord<String, String> record) {
    System.out.println("sla-monitoring-kafka-message, key=" + record.key() + ",topic=" + record.topic() + " message=" + record.value() + "");
    //Implement to dB save
    try {
      Map map = mapper.readValue(record.value(), Map.class);

      System.out.println("" + map.get("name"));

    } catch (Exception e) {

    }
  }
}
