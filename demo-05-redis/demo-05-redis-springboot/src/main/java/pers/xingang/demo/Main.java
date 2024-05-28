package pers.xingang.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author xingang
 * @since 2024/05/27 21:03
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("===============================");
        System.out.println("=========== 启动完毕 ============");
        System.out.println("===============================");
    }
}