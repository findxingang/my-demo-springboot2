package pers.xingang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.xingang.domain.Book;
import pers.xingang.service.BookService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xingang
 * @since 2024/04/28 19:11
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping
    public String save() {
        bookService.saveBooks();
        return "success";
    }


    @GetMapping("list")
    public List<Book> list() {
        return bookService.listWithCustomOrder();
    }
}
