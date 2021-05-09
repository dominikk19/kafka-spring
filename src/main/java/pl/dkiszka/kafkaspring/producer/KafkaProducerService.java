package pl.dkiszka.kafkaspring.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project kafka-spring
 * @date 08.05.2021
 */
@Service
@RequiredArgsConstructor
class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    String sendMessage(String key, String value){
        kafkaTemplate.send("example-topic", key, value);
        return "ok";
    }
}
