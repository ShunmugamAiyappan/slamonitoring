package com.example.slamonitoring.kafka.listener;

import com.example.slamonitoring.model.TaskEvents;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.slamonitoring.controller.TaskEventsController;
import com.example.slamonitoring.model.TaskEvents;

import java.util.Date;
import java.util.Map;

@Component
public class TopicListener {
  @Autowired
  ObjectMapper mapper;
  public TaskEventsController taskEventsController = new TaskEventsController();

  @KafkaListener(id = "${kafka.topicName}", topics = "${kafka.topicName}", containerFactory = "kafkaListenerContainerFactory")
  void consumeSLAMonitoring(ConsumerRecord<String, String> record) {
    System.out.println("sla-monitoring-kafka-message, key=" + record.key() + ",topic=" + record.topic() + " message=" + record.value() + "");
    //Implement to dB save
    try {
      Map map = mapper.readValue(record.value(), Map.class);
      System.out.println(map);
      System.out.println("" + map.get("eventType"));

      TaskEvents taskEvent = new TaskEvents(
              "" + map.get("slaName"),
              "" + map.get("eventType"),
             map.get("task_identifier_attributes"),
            new Date(),
             new Date()
      );
     System.out.println(taskEvent.toString());
     taskEventsController.createTaskEvents(taskEvent);

    } catch (Exception e) {
            System.out.println(e);
    }
  }
}
