package pers.xingang.demo.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author xingang
 * @since 2024/02/29 15:15
 */
@SpringBootTest
class InsertDataTest {

    @Resource
    private InsertData insertData;

    @BeforeEach
    void setUp() {
        insertData.truncateTable();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertByJDBC() {
        insertData.insertByJDBC();
    }

    @Test
    void insertBatchByJDBC() {
        insertData.insertBatchByJDBC();
    }


    @Test
    void insertBatchByJDBC2() {
        insertData.insertBatchByJDBC2();
    }

    @Test
    void insertBatchByJDBC3() {
        insertData.insertBatchByJDBC3();
    }

    @Test
    void insertBatchByJDBC4() {
        insertData.insertBatchByJDBC4();
    }

    @Test
    void insertByMyBatis() {
        insertData.insertByMyBatis();
    }

    @Test
    void insertBatchByMyBatis() {
        insertData.insertBatchByMyBatis();
    }

    @Test
    void insertBatchByMyBatis2() {
        insertData.insertBatchByMyBatis2();
    }
}