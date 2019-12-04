package com.redstar.rabbitmq;

import com.redstar.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息的消费者
 *
 * @date: 2019-03-21 下午 10:40
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@Component
public class RabbitReceiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receiverDirectQueue(User user) {
        logger.info("【receiver-Direct-Queue监听到消息】" + user.toString());
    }

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiveTopic1(User user) {
        logger.info("【receive-Topic-1监听到消息】" + user.toString());
    }

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiveTopic2(User user) {
        logger.info("【receive-Topic-2监听到消息】" + user.toString());
    }

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiveFanout1(User user) {
        logger.info("【receive-Fanout-1监听到消息】" + user.toString());
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiveFanout2(User user) {
        logger.info("【receive-Fanout-2监听到消息】" + user.toString());
    }

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.HEADERS_QUEUE1)
    public void receiveHeaders1(byte[] s) {
        logger.info("【receive-Headers-1监听到消息】" + new String(s));
    }

    @RabbitListener(queues = RabbitConfig.HEADERS_QUEUE2)
    public void receiveHeaders2(byte[] s) {
        logger.info("【receive-Headers-2监听到消息】" + new String(s));
    }

}

