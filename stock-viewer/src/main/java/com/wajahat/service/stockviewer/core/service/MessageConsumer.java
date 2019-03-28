package com.wajahat.service.stockviewer.core.service;

import com.wajahat.service.stockviewer.core.domain.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ${CLASS_NAME}
 *
 * @author Wajahat Siddiqui
 */
@Slf4j
@Component
public class MessageConsumer {
    @RabbitListener(queues = "stock-queue")
    public void receiveMessage(Quote quote) {
        log.info("**** Voila !!! message received: " + quote);
    }
}
