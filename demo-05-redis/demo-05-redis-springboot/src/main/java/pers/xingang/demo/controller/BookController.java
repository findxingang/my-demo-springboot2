package pers.xingang.demo.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.xingang.demo.domain.Book;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xingang
 * @since 2024/05/28 17:26
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @RequestMapping("/testString")
    public void testString() {
        String key = "key1";
        stringRedisTemplate.opsForValue().set(key, "这是一段文字 666");
        String value = stringRedisTemplate.opsForValue().get(key);
        System.out.println("value = " + value);
    }
    @RequestMapping("/testString2")
    public void testString2() {
        String key = "key1";
        redisTemplate.opsForValue().set(key, "这是一段文字 666");
        String value = stringRedisTemplate.opsForValue().get(key);
        System.out.println("value = " + value);
    }


    @RequestMapping("/testHash")
    public void testBook() {
        Book book = new Book();
        book.setId(10086L);
        book.setBookName("Java从入门到放弃");
        book.setPrice(88.88);
        book.setPublishedDate(new Date());

        Map<String, Object> hash = new HashMap<>();
        hash.put("id", book.getId());
        hash.put("bookName", book.getBookName());
        hash.put("price", book.getPrice());
        hash.put("publishedDate", book.getPublishedDate());

        redisTemplate.opsForHash().putAll(book.getBookName(), hash);
        Map<Object, Object> objectMap = redisTemplate.opsForHash().entries(book.getBookName());
        System.out.println("objectMap = " + objectMap);
    }
    @RequestMapping("/testObject")
    public void testObject() {
        Book book = new Book();
        book.setId(10086L);
        book.setBookName("Java从入门到放弃");
        book.setPrice(88.88);
        book.setPublishedDate(new Date());

        redisTemplate.opsForValue().set(book.getBookName(), book);
    }

}
