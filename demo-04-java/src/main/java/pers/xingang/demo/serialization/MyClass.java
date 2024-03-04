package pers.xingang.demo.serialization;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xingang
 * @since 2024/03/04 16:14
 */
@Data
class MyClass implements Serializable {
    private final int num;
    private final String text;
}
