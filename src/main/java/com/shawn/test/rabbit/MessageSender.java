package com.shawn.test.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Shawn on 2016/1/31.
 */
public class MessageSender {
    @Autowired
    RabbitTemplate rabbit;

    public void sendMessage(Message message) {
        rabbit.convertAndSend(message);
    }

    public void sendString(String message) {
        rabbit.convertAndSend(message);
    }

}
