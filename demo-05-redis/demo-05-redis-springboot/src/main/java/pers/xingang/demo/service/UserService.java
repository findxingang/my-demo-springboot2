package pers.xingang.demo.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import pers.xingang.demo.domain.User;

/**
 * @author xingang
 * @since 2024/05/29 11:25
 */
@Service
public class UserService {

    private final RedisTemplate<String, Object> redisTemplate;

    public UserService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveUser(User user) {
        String key = "user:" + user.getId();
        redisTemplate.opsForValue().set(key, user);
    }

    public User getUser(Long userId) {
        String key = "user:" + userId;
        return (User) redisTemplate.opsForValue().get(key);
    }
}
