package com.camunda.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.camunda.training.services"})
@ComponentScan({"com.camunda.training.order"})
public class ExternalTaskWorkerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExternalTaskWorkerApplication.class, args);
  }
}

