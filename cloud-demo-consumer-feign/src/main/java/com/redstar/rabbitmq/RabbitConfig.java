package com.redstar.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @date: 2019-03-21 下午 10:40
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@Configuration
public class RabbitConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Direct模式
    static final String QUEUE = "direct_queue";

    // Topic模式
    public static final String TOPIC_QUEUE1 = "topic_queue1";
    public static final String TOPIC_QUEUE2 = "topic_queue2";
    public static final String TOPIC_EXCHANGE = "topic_exchange";

    // fanout模式
    public static final String FANOUT_QUEUE1 = "fanout_queue1";
    public static final String FANOUT_QUEUE2 = "fanout_queue2";
    public static final String FANOUT_EXCHANGE = "fanout_exchange";

    // fanout模式
    public static final String HEADERS_QUEUE1 = "headers_queue1";
    public static final String HEADERS_QUEUE2 = "headers_queue2";
    public static final String HEADERS_EXCHANGE = "headers_exchange";

    /**
     * Direct模式
     *
     * @return
     */
    @Bean
    public Queue directQueue() {
        // 第一个参数是队列名字， 第二个参数是指是否持久化
        //return new Queue(QUEUE, true);
        return new Queue(QUEUE);
    }

    /**
     * Topic模式
     *
     * @return
     */
    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2);
    }

    /**
     * topic模式交换机
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * 将队列实例绑定到交换机并设置路由Key （zcb.message/zcb.#）
     *
     * @return
     */
    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("zcb.message");
    }

    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("zcb.#");
    }


    /**
     * Fanout模式 队列实例
     *
     * @return
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE1);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE2);
    }


    /**
     * Fanout模式
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(fanoutExchange());
    }


    /**
     * headers模式队列实例
     *
     * @return
     */
    @Bean
    public Queue headersQueue1() {
        return new Queue(HEADERS_QUEUE1);
    }

    @Bean
    public Queue headersQueue2() {
        return new Queue(HEADERS_QUEUE2);
    }

    /**
     * headers模式交换机
     *
     * @return
     */
    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERS_EXCHANGE);
    }

    @Bean
    public Binding headersBinding1() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("h1", "v1");
        return BindingBuilder.bind(headersQueue1()).to(headersExchange()).whereAll(map).match();
    }
}
