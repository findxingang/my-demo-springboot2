package pers.xingang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.xingang.dao.BookMapper;
import pers.xingang.domain.Book;
import pers.xingang.util.BookDataGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author xingang
 * @since 2024/04/28 18:43
 */
@Service
public class BookService extends ServiceImpl<BookMapper, Book> {


    public void saveBooks() {
        // 生成10条数据
        List<Book> books = BookDataGenerator.generateBooks(10);
        books.forEach(book -> System.out.println(book.toString()));

        // 插入数据表
        this.saveBatch(books);

    }

    public List<Book> listWithCustomOrder() {
        // 指定顺序
        List<Book> books = this.list();

        // 传入字符串数组
        String[] sortFields = new String[]{"price", "publishDate", "author", "name"};

        books.sort((book1, book2) -> {
            for (String sortField : sortFields) {
                int result = compareBook(book1, book2, sortField);
                // 两者在第一个比较就能区分出排序结果
                // 如果结果为0，说明这一个字段两本书是相同的，继续比较下一个sortField
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        });

        books.forEach(book -> System.out.println(book.toString()));
        return null;
    }

    private int compareBook(Book book1, Book book2, String sortField) {
        if (Objects.equals(sortField, "price")) {
            return Double.compare(book1.getPrice(), book2.getPrice());
        } else if (Objects.equals(sortField, "publishDate")) {
            return book1.getPublishDate().compareTo(book2.getPublishDate());
        } else if (Objects.equals(sortField, "author")) {
            return book1.getAuthor().compareTo(book2.getAuthor());
        } else if (Objects.equals(sortField, "name")) {
            return book1.getName().compareTo(book2.getName());
        }
        return 0;
    }
}
