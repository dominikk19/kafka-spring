package pl.dkiszka.kafkaspring.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author Dominik Kiszka {dominikk19}
 * @Project kafka-spring
 * @Date 09.05.2021
 */
@Component
@Slf4j
class KafkaConsumerComponent {

    private static final String TOPIC = "example-topic";

    @KafkaListener(topics = TOPIC, groupId = "test-group-id")
    public void consume(@Payload String message) {
        log.info(String.format("Message from topic: %s : %2s",TOPIC, message));
    }
}
