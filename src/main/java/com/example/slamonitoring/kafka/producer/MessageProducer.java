package com.example.slamonitoring.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducer {


  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;

  @Value("${kafka.topicName}")
  String kafkaTopicName;


  @RequestMapping(path = "/kafka/sendmessage", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
  void sendMessage(@RequestBody String message) {

    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafkaTopicName, message);

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
      @Override
      public void onSuccess(SendResult<String, String> result) {
        System.out.println("Sent message=[" + message + "] with topic=[" + result.getRecordMetadata().topic() + "]");
      }

      @Override
      public void  onFailure(Throwable ex) {
        System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
      }
    });
  }
}
