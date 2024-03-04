package pers.xingang.demo.serialization;

import lombok.Data;

import java.io.*;

/**
 * @author xingang
 * @since 2024/03/04 13:47
 */
public class SerializationTest {
    public static void main(String[] args) {
        try (FileOutputStream fileOut = new FileOutputStream("data.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            // 序列化
            MyClass myClass = new MyClass(1, "wangxingang");
            out.writeObject(myClass);
            System.out.println("Serialized data is saved in data.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




