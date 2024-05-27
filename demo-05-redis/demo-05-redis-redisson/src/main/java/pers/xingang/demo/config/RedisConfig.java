package pers.xingang.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author xingang
 * @since 2024/04/02 14:58
 */

@Configuration
public class RedisConfig {

    @Bean
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建一个新的 RedisTemplate 实例
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置连接工厂
        redisTemplate.setConnectionFactory(connectionFactory);

        // 设置 key 的序列化器为 StringRedisSerializer
        // 确保 key 被序列化和反序列化为字符串
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());

        // 设置 value 的序列化器为 GenericJackson2JsonRedisSerializer
        // 允许序列化和反序列化任意 Java 对象作为 value
        redisTemplate.setValueSerializer(RedisSerializer.json());
        redisTemplate.setHashValueSerializer(RedisSerializer.json());

        // 在设置所有属性后初始化 RedisTemplate
        redisTemplate.afterPropertiesSet();

        // 返回配置好的 RedisTemplate
        return redisTemplate;
    }
}
