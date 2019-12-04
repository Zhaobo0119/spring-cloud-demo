package com.redstar.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @date: 2019-03-22 下午 05:54
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
public class NormalRecevier implements DeliverCallback {

    private final static String QUEUE_NAME = "normal_queue";
    private static int INDEX = 0;

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = RabbitFactory.getRabbitFactory().newConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. . . . . ");
        Consumer consumer = new DefaultConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

    @Override
    public void handle(String consumerTag, Delivery delivery) throws IOException {
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println(" [x] Received '" + message + "' " + (++INDEX));
    }
}
