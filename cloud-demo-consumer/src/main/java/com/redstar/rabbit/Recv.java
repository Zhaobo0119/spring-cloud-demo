package com.redstar.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @date: 2019-03-22 下午 12:30
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
public class Recv {

    private static final String USER_NAMR = "zhao";
    private static final String USER_PWD = "1993";
    private static final int PORT = 5672;

    private final static String QUEUE_NAME = "hello";
    private static int INDEX = 0;

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = RabbitFactory.getRabbitFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        /*相当于实现 DeliverCallback 接口*/
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "' " + (++INDEX));
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
}
