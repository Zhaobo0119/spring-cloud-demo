package com.redstar.rabbitmq;

import com.redstar.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * 消息的生产者
 *
 * @date: 2019-03-21 下午 10:40
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@Component
public class RabbitSender {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue() {
        User user = new User();
        user.setId(666);
        user.setName("redstar");
        // 第一个参数是指要发送到哪个队列里面， 第二个参数是指要发送的内容
        this.amqpTemplate.convertAndSend(RabbitConfig.QUEUE, user);
        logger.info("【sendDirectQueue已发送消息】");
    }


    public void sendTopic() {
        User user1 = new User();
        user1.setId(111);
        user1.setName("zhansan");

        User user2 = new User();
        user2.setId(222);
        user2.setName("lisi");

        // 第一个参数：TopicExchange名字
        // 第二个参数：Route-Key
        // 第三个参数：要发送的内容
        this.amqpTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "zcb.message", user1);
        this.amqpTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "zcb.zcb", user2);
        logger.info("【sendTopic已发送消息】");

    }


    public void sendFanout() {
        User user = new User();
        user.setId(333);
        user.setName("fanout");
        // 注意， 这里的第2个参数为空。
        // 因为fanout 交换器不处理路由键，只是简单的将队列绑定到交换器上，
        // 每个发送到交换器的消息都会被转发到与该交换器绑定的所有队列上
        this.amqpTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", user);
        logger.info("【sendFanout已发送消息】");
    }

    public void sendHeaders() {
        User user = new User();
        user.setId(555);
        user.setName("headers");
        MessageProperties properties = new MessageProperties();
        properties.setHeader("h1", "v1");
        try {
            Message message = new Message(user.toString().getBytes("UTF-8"), properties);
            this.amqpTemplate.convertAndSend(RabbitConfig.HEADERS_EXCHANGE, "", message);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
