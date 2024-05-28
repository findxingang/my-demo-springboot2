package pers.xingang.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author xingang
 * @since 2024/05/27 21:40
 */
@Data
public class Book {
    private Long id;
    private String bookName;
    private Double price;
    private Date publishedDate;
}
