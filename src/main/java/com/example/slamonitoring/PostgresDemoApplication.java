package com.example.slamonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class PostgresDemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(PostgresDemoApplication.class, args);
  }
}
