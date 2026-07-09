package com.microservices.study.haarlememeerservice;

import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
@EnableFeignClients

public class HaarlememeerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(HaarlememeerServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner testFlyway(DataSource dataSource) {
    return arg -> log.info("DB Connected: {}", dataSource.getConnection().getMetaData().getURL());
  }
}
