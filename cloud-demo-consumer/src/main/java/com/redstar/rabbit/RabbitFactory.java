package com.redstar.rabbit;

import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date: 2019-03-22 下午 12:34
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
public class RabbitFactory {

    public static Logger logger = LoggerFactory.getLogger(RabbitFactory.class);
    private static final String USER_NAMR = "zhao";
    private static final String USER_PWD = "1993";
    private static final int PORT = 5672;
    private static ConnectionFactory factory = null;

    public static ConnectionFactory getRabbitFactory() {
        if (factory == null) {
            synchronized (RabbitFactory.class) {
                if (factory == null) {
                    factory = new ConnectionFactory();
                    factory.setHost("192.168.1.18");
                    factory.setUsername(USER_NAMR);
                    factory.setPassword(USER_PWD);
                    factory.setPort(PORT);
                    logger.info("-------------create------------");
                }
            }
        }
        return factory;
    }
}
