package dev.abarmin.kafka.producer;

import dev.abarmin.kafka.producer.model.KafkaMessage;
import dev.abarmin.kafka.producer.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Barmin
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final KafkaConfiguration configuration;

  @Scheduled(initialDelay = 1000, fixedDelay = 5000)
  public void produce() {
    log.info("Sending event");

    kafkaTemplate.send(configuration.getTopic(), createMessage())
        .addCallback(result -> {
          log.info("Successfully send");
        }, ex -> {
          log.warn("Message wasn't sent");
        });
  }

  private KafkaMessage createMessage() {
    return KafkaMessage.builder()
        .data(Person.builder()
            .firstName("First name")
            .lastName("Last name")
            .build()
        )
        .build();
  }
}
