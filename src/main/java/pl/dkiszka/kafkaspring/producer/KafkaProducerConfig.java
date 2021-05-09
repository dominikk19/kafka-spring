package pl.dkiszka.kafkaspring.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project kafka-spring
 * @date 08.05.2021
 */
@Configuration
@EnableKafka
class KafkaProducerConfig {

    @Bean
    Map<String, Object> producerConfigs() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "test-producer");
//        properties.put(ProducerConfig.ACKS_CONFIG, "-1");
//        properties.put(ProducerConfig.RETRIES_CONFIG, "2"); //default Max Integer
//        properties.put(ProducerConfig.LINGER_MS_CONFIG, "200");
//        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
//        properties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
        return properties;
    }

    @Bean
    ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
