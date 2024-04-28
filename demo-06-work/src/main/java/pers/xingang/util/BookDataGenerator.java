package pers.xingang.util;

import cn.hutool.core.util.NumberUtil;
import pers.xingang.domain.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BookDataGenerator {

    private static final String[] BOOK_NAMES = {
            "活着",
            "围城",
            "红楼梦",
            "百年孤独",
            "解忧杂货店",
            "三体",
            "平凡的世界",
            "小王子",
            "追风筝的人",
            "人间失格",
            "白夜行",
            "挪威的森林",
            "嫌疑人X的献身",
            "不能承受的生命之轻",
            "围脖"
    };

    private static final String[] AUTHORS = {
            "余华",
            "钱钟书",
            "曹雪芹",
            "加西亚·马尔克斯",
            "东野圭吾",
            "刘慈欣",
            "路遥",
            "安东尼·德·圣-埃克苏佩里",
            "卡勒德·胡赛尼",
            "太宰治",
            "东野圭吾",
            "村上春树",
            "东野圭吾",
            "米兰·昆德拉",
            "郭敬明"
    };

    private static final String[] CATEGORIES = {
            "小说",
            "文学",
            "传记",
            "历史",
            "推理",
            "科幻",
            "言情",
            "哲学",
            "自助",
            "心理",
            "散文"
    };

    private static final String[] PUBLISHERS = {
            "人民文学出版社",
            "上海译文出版社",
            "中华书局",
            "南海出版公司",
            "北京联合出版公司",
            "江苏凤凰文艺出版社",
            "北京大学出版社",
            "商务印书馆",
            "译林出版社",
            "广西师范大学出版社"
    };

    public static List<Book> generateBooks(int count) {
        List<Book> books = new ArrayList<>();
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < count; i++) {
            Book book = new Book();
            book.setName(BOOK_NAMES[i]);
            book.setAuthor(AUTHORS[i]);
            book.setDescription("《" + book.getName() + "》的描述");
            book.setPrice(NumberUtil.round(10.0 + random.nextDouble() * 40.0, 2).doubleValue()); // 价格在10.0到50.0之间的随机值
            book.setCategory(CATEGORIES[i]);
            book.setPublisher(PUBLISHERS[i]);

            // 随机生成过去10年内的出版日期
            int year = 2014 + random.nextInt(10);
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(28) + 1;
            String dateString = String.format("%04d-%02d-%02d", year, month, day);
            try {
                Date publishDate = dateFormat.parse(dateString);
                book.setPublishDate(publishDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            books.add(book);
        }

        return books;
    }

    public static void main(String[] args) {
        List<Book> books = generateBooks(10);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
