package com.redstar.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date: 2019-03-22 下午 02:54
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
public class NeWork {

    public static Logger logger = LoggerFactory.getLogger(NeWork.class);

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = RabbitFactory.getRabbitFactory();
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            String message = String.join("", args);
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            logger.info("[X] Sent '" + message + "'");
        }
    }
}
