package pers.xingang.demo.serialization;

import java.io.*;

/**
 * @author xingang
 * @since 2024/03/04 13:47
 */
public class DeSerializationTest {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("data.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn);) {
            // 反序列化
            MyClass obj2;
            obj2 = (MyClass) in.readObject();
            // 反序列化出来的对象：MyClass(number=1, text=wangxingang)
            System.out.println("反序列化出来的对象：" + obj2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}




