package pers.xingang.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author xingang
 * @since 2024/02/29 16:08
 */
@TableName("big_insert_data")
@Data
public class BigInsertData {

    Integer id;
    String name;
    String sex;
    String tel;
    String email;
    String road;
}
