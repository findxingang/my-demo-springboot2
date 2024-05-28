package pers.xingang.demo.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import pers.xingang.demo.domain.Book;

import javax.annotation.Resource;

/**
 * @author xingang
 * @since 2024/05/27 21:42
 */
@Service
public class BookService {
    // @Resource
    // private RedisTemplate<Long, Book> redisTemplate;
    //
    // @Resource
    // private RedisTemplate<String, Book> objectRedisTemplate;
    //
    // public void save(Book book) {
    //     redisTemplate.opsForValue().set(1L, book);
    // }
    //
    // public Book findById(Long id) {
    //     return redisTemplate.opsForValue().get(id);
    // }
    //
    // public void saveStringObject(Book book) {
    //     objectRedisTemplate.opsForValue().set(book.getBookName(), book);
    // }
    //
    // public Book getStringObject(String bookName) {
    //     return objectRedisTemplate.opsForValue().get(bookName);
    // }
}
