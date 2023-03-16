package dev.abarmin.kafka.producer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author Aleksandr Barmin
 */
@Data
@Validated
@ConfigurationProperties(prefix = "app.producer")
public class KafkaConfiguration {
  private String topic;
}
