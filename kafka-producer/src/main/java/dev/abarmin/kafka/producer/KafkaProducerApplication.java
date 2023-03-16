package dev.abarmin.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Aleksandr Barmin
 */
@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties(KafkaConfiguration.class)
public class KafkaProducerApplication {
  public static void main(String[] args) {
    SpringApplication.run(KafkaProducerApplication.class, args);
  }
}
