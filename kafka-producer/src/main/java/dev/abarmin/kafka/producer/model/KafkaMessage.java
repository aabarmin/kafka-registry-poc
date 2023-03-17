package dev.abarmin.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aleksandr Barmin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessage {
  private Person data;
  @Builder.Default
  private EventMetadata eventMetadata = EventMetadata.builder()
      .type("Kafka Message")
      .build();
}
