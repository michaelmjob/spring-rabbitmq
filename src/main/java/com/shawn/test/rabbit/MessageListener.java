package com.shawn.test.rabbit;

import org.springframework.amqp.core.Message;

/**
 * Created by Shawn on 2016/1/31.
 */
public class MessageListener {

    public void listen(String message) {
        System.out.println("[RabbitMQ]收到消息: " + message);
    }

    public void listen(Message message) {

        System.out.println("[RabbitMQ]收到消息: " + message);
    }
}
