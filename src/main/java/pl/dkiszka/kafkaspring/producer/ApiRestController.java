package pl.dkiszka.kafkaspring.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project kafka-spring
 * @date 08.05.2021
 */
@RestController
@RequiredArgsConstructor
class ApiRestController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping(value = "messages/{key}/{value}")
    @ResponseBody
    String sendMessage(@PathVariable String key, @PathVariable String value) {
        return kafkaProducerService.sendMessage(key, value);
    }

}
