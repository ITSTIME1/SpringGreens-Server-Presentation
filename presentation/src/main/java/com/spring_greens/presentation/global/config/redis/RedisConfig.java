package com.spring_greens.presentation.global.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.util.List;
import java.util.ArrayList;

/**
 * That's RedisConfig file. It defines Redis-related settings.<br>
 * RedisMessageListener, Topic Setting<br>
 * <br>
 * <Step 1>
 *     First. Define host that aws ec2 public Ipv4 or local ip and port, password <br>
 *     Second. Start redis server. <br>
 *     Third. Define how to access redis server by using template.
 * </Step>
 */
@Configuration
public class RedisConfig {
    /**
     * Define host, port, password into application.properties then use @Value annotation for take variable.
     */
    @Value("${spring.data.redis.host}")
    private String host;
    @Value("${spring.data.redis.port}")
    private int port;
    @Value("${spring.data.redis.password}")
    private String password;

    /**
     * Setting redis database connection. LettuceConnectionFactory is Asynchronous.<br>
     * so, It's very easy to control multi-thread environment better than jedis.
     *
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
        redisConfiguration.setHostName(host);
        redisConfiguration.setPort(port);
        redisConfiguration.setPassword(password);
        return new LettuceConnectionFactory(redisConfiguration);
    }

    /**
     * RedisTemplate is very important to control redis data-structures.
     * if we use jsonStructure or HashStructure, you should define each template of purpose <br>
     * <br>
     * RedisJsonTemplate controls 'MallProducts' when client send HTTP GET method for get products of specific mall.
     *
     */
    @Bean
    public RedisTemplate<String, Object> redisJsonTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @Bean
    public RedisTemplate<String, String> redisStringTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory); // RedisServer에 연결하기 위한. connectionFactory를 주입.ㅁ
        template.setKeySerializer(new StringRedisSerializer()); // Key Serilializer같네.
        template.setValueSerializer(new StringRedisSerializer()); // 상품 구조가 Json으로 들어가는게 더 효율적인 구조이므로 J
        return template; // 이렇게 설정한 RedisTemplate를 반환해서 사용.
    }

    /**
     * RedisTemplate is very important to control redis data-structures. if we use HashStructure for increment view count.<br>
     * I think that suitable data-structure for increment view count.
     */
    @Bean
    public RedisTemplate<String, Long> redisHashTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Long> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericToStringSerializer<>(Long.class));
        return template;
    }

    /**
     * MessageListenerAdapter controls publishing messages that increment message from publisher.
     */

//    @Bean
//    public MessageListenerAdapter messageListenerAdapter(RedisMessageSubscriber redisMessageSubscriber) {
//        return new MessageListenerAdapter(redisMessageSubscriber, "onMessage");
//    }
//
//    @Bean
//    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
//        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
//        redisMessageListenerContainer.addMessageListener(messageListenerAdapter(new RedisMessageSubscriber(simpMessagingTemplate)), registerTopic());
//        return redisMessageListenerContainer;
//    }


    /**
     * Topics means 'Mall' so Topic is channel of mall.<br>
     * The number of topics is the same as the number of mall
     *
     */
//    @Bean
//    public List<Topic> registerTopic() {
//        List<Topic> topics = new ArrayList<>();
//        topics.add(new ChannelTopic("/test"));
//        topics.add(new ChannelTopic("/apm"));
//        topics.add(new ChannelTopic("/apmPlace"));
//        return topics;
//    }
}
