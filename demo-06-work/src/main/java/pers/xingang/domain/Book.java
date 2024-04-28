package pers.xingang.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author xingang
 * @since 2024/04/28 18:38
 */
@Data
@TableName("book")
public class Book implements Comparable<Book> {

    // 主键
    @TableId
    private Long id;

    // 书名
    @TableField
    private String name;

    // 作者
    @TableField
    private String author;

    // 描述
    @TableField
    private String description;

    // 价格
    @TableField
    private double price;

    // 种类
    @TableField
    private String category;

    // 出版社
    @TableField
    private String publisher;

    // 出版日期
    @TableField
    private Date publishDate;

    /**
     * 通过实现Comparable接口来实现自定义排序：价格贵的排在后边
     * 如果 compareTo() 方法返回一个负数，排序算法认为第一个元素小于第二个元素，它们的位置不会交换。
     * 如果 compareTo() 方法返回零，排序算法认为第一个元素等于第二个元素，它们的位置不会交换。
     * 如果 compareTo() 方法返回一个正数，排序算法认为第一个元素大于第二个元素，它们的位置会交换。
     */
    @Override
    public int compareTo(Book o) {
        if (this.getPrice() > o.getPrice()) {
            return 1;
        } else if (this.getPrice() < o.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }


}
