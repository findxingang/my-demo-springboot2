package pers.xingang.demo.test;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xingang
 * @since 2024/04/02 13:45
 */
@RestController
@RequestMapping("/api/redis")
public class RedisTemplateDemo {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/set")
    public void set() {
        redisTemplate.opsForValue().set("myKey", "myValue");
        redisTemplate.opsForList();
        redisTemplate.opsForSet();
        redisTemplate.opsForZSet();
        redisTemplate.opsForHash();
        redisTemplate.opsForHyperLogLog();
        redisTemplate.opsForGeo();
        redisTemplate.opsForCluster();
    }


    @GetMapping("/get")
    public void get() {
        String myValue = redisTemplate.opsForValue().get("myKey");
        System.out.println("myValue=" + myValue);
    }

}
