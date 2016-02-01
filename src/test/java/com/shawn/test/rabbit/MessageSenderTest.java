package com.shawn.test.rabbit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Shawn on 2016/1/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-rabbit.xml")
public class MessageSenderTest {

    private Gson gson = new GsonBuilder().serializeNulls().create();

    @Autowired
    MessageSender sender;

    @Test
    public void testSendString() throws Exception {
        sender.sendString("hello world");
    }

    @Test
    public void testSendMessage() throws Exception {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentEncoding("UTF-8");
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);

        Map<String, String> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        data.put("orderId", "20160131123");
        data.put("status", "SUCCESS");

        map.put("sign", "adfad-3145wef-wfed");
        map.put("data", gson.toJson(data));

        Message message = new Message(gson.toJson(map).getBytes(), messageProperties);
        sender.sendMessage(message);
    }
}