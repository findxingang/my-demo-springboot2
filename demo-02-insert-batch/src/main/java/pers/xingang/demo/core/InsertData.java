package pers.xingang.demo.core;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pers.xingang.demo.domain.BigInsertData;
import pers.xingang.demo.mapper.BigInsertDataMapper;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xingang
 * @since 2024/02/29 15:02
 */
@Component
@Slf4j
public class InsertData {
    @Resource
    private DataSource dataSource;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public void truncateTable() {
        log.info("开始清空表数据...");
        String sql = "truncate table t_big_data_insert";
        jdbcTemplate.execute(sql);
        log.info("结束清空表数据...");
    }

    /**
     * 基于JDBC逐条插入10w数据 耗时：163370ms
     */
    public void insertByJDBC() {
        String sql = "insert into t_big_data_insert (id, name, sex, tel, email, road) values (?,?,?,?,?,?);";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            log.info("10w条数据开始插入...");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10 * 10000; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, pers.xingang.demo.random.RandomValueUtil.getChineseName());
                preparedStatement.setString(3, pers.xingang.demo.random.RandomValueUtil.getSex());
                preparedStatement.setString(4, pers.xingang.demo.random.RandomValueUtil.getTel());
                preparedStatement.setString(5, pers.xingang.demo.random.RandomValueUtil.getEmail(6, 9));
                preparedStatement.setString(6, pers.xingang.demo.random.RandomValueUtil.getRoad());
                preparedStatement.execute();
            }
            log.info("10w条数据插入完毕，耗时：{}ms", System.currentTimeMillis() - start);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 基于JDBC逐条插入10w数据              耗时：163370ms
     * 基于JDBC分批插入10w条数据（不开事务）   耗时：126193ms
     */
    public void insertBatchByJDBC() {
        String sql = "insert into t_big_data_insert (id, name, sex, tel, email, road) values (?,?,?,?,?,?);";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            log.info("10w条数据开始插入...");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10 * 10000; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, pers.xingang.demo.random.RandomValueUtil.getChineseName());
                preparedStatement.setString(3, pers.xingang.demo.random.RandomValueUtil.getSex());
                preparedStatement.setString(4, pers.xingang.demo.random.RandomValueUtil.getTel());
                preparedStatement.setString(5, pers.xingang.demo.random.RandomValueUtil.getEmail(6, 9));
                preparedStatement.setString(6, pers.xingang.demo.random.RandomValueUtil.getRoad());
                preparedStatement.addBatch();

                if (i % 1000 == 0) {
                    preparedStatement.executeBatch();
                }
            }
            log.info("10w条数据插入完毕，耗时：{}ms", System.currentTimeMillis() - start);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 基于JDBC逐条插入10w数据              耗时：163370ms
     * 基于JDBC分批插入10w条数据（不开事务）   耗时：126193ms
     * 基于JDBC分批插入10w条数据（开启事务）   耗时：112559ms
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBatchByJDBC2() {
        String sql = "insert into t_big_data_insert (id, name, sex, tel, email, road) values (?,?,?,?,?,?);";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            log.info("10w条数据开始插入...");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10 * 10000; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, pers.xingang.demo.random.RandomValueUtil.getChineseName());
                preparedStatement.setString(3, pers.xingang.demo.random.RandomValueUtil.getSex());
                preparedStatement.setString(4, pers.xingang.demo.random.RandomValueUtil.getTel());
                preparedStatement.setString(5, pers.xingang.demo.random.RandomValueUtil.getEmail(6, 9));
                preparedStatement.setString(6, pers.xingang.demo.random.RandomValueUtil.getRoad());
                preparedStatement.addBatch();

                if (i % 1000 == 0) {
                    preparedStatement.executeBatch();
                }
            }
            log.info("10w条数据插入完毕，耗时：{}ms", System.currentTimeMillis() - start);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 基于JDBC逐条插入10w数据                  耗时：163370ms
     * 基于JDBC分批插入10w条数据（不开事务）      耗时：126193ms
     * 基于JDBC分批插入10w条数据（Spring事务）   耗时：112559ms
     * 基于JDBC分批插入10w条数据（手动开启事务）   耗时：22414ms
     */
    public void insertBatchByJDBC3() {
        String sql = "insert into t_big_data_insert (id, name, sex, tel, email, road) values (?,?,?,?,?,?);";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            log.info("10w条数据开始插入...");
            long start = System.currentTimeMillis();

            // 禁用自动提交
            connection.setAutoCommit(false);
            try {
                for (int i = 0; i < 10 * 10000; i++) {
                    preparedStatement.setInt(1, i);
                    preparedStatement.setString(2, pers.xingang.demo.random.RandomValueUtil.getChineseName());
                    preparedStatement.setString(3, pers.xingang.demo.random.RandomValueUtil.getSex());
                    preparedStatement.setString(4, pers.xingang.demo.random.RandomValueUtil.getTel());
                    preparedStatement.setString(5, pers.xingang.demo.random.RandomValueUtil.getEmail(6, 9));
                    preparedStatement.setString(6, pers.xingang.demo.random.RandomValueUtil.getRoad());
                    preparedStatement.addBatch();

                    if (i % 1000 == 0) {
                        preparedStatement.executeBatch();
                    }
                }
                // 提交事务
                connection.commit();
            } catch (SQLException e) {
                // 回滚事务
                connection.rollback();
                throw new RuntimeException(e);
            } finally {
                // 恢复自动提交模式
                connection.setAutoCommit(true);
            }
            log.info("10w条数据插入完毕，耗时：{}ms", System.currentTimeMillis() - start);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 基于JDBC逐条插入10w数据                  耗时：163370ms
     * 基于JDBC分批插入10w条数据（不开事务）      耗时：126193ms
     * 基于JDBC分批插入10w条数据（Spring事务）   耗时：112559ms
     * 基于JDBC分批插入10w条数据（手动开启事务）   耗时：22414ms
     * 基于JDBC分批插入10w条数据（手动开启事务，jdbc url后拼接rewriteBatchedStatements=true）   耗时：2629ms
     */
    public void insertBatchByJDBC4() {
        String sql = "insert into t_big_data_insert (id, name, sex, tel, email, road) values (?,?,?,?,?,?);";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            log.info("10w条数据开始插入...");
            long start = System.currentTimeMillis();

            // 禁用自动提交
            connection.setAutoCommit(false);
            try {
                for (int i = 0; i < 10 * 10000; i++) {
                    preparedStatement.setInt(1, i);
                    preparedStatement.setString(2, pers.xingang.demo.random.RandomValueUtil.getChineseName());
                    preparedStatement.setString(3, pers.xingang.demo.random.RandomValueUtil.getSex());
                    preparedStatement.setString(4, pers.xingang.demo.random.RandomValueUtil.getTel());
                    preparedStatement.setString(5, pers.xingang.demo.random.RandomValueUtil.getEmail(6, 9));
                    preparedStatement.setString(6, pers.xingang.demo.random.RandomValueUtil.getRoad());
                    preparedStatement.addBatch();

                    if (i % 1000 == 0) {
                        preparedStatement.executeBatch();
                    }
                }
                // 提交事务
                connection.commit();
            } catch (SQLException e) {
                // 回滚事务
                connection.rollback();
                throw new RuntimeException(e);
            } finally {
                // 恢复自动提交模式
                connection.setAutoCommit(true);
            }
            log.info("10w条数据插入完毕，耗时：{}ms", System.currentTimeMillis() - start);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 基于JDBC逐条插入10w数据                  耗时：163370ms
     * 基于JDBC分批插入10w条数据（不开事务）      耗时：126193ms
     * 基于JDBC分批插入10w条数据（Spring事务）   耗时：112559ms
     * 基于JDBC分批插入10w条数据（手动开启事务）   耗时：22414ms
     * 基于JDBC分批插入10w条数据（手动开启事务，jdbc url后拼接rewriteBatchedStatements=true）   耗时：2629ms
     * 基于MyBatis逐条插入10w条数据（jdbc url后拼接rewriteBatchedStatements=true）   耗时：145951ms
     */
    public void insertByMyBatis() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            log.info("10w条数据开始插入...");
            long start = System.currentTimeMillis();
            BigInsertData one;
            for (int i = 0; i < 10 * 10000; i++) {
                one = new BigInsertData();
                one.setId(i);
                one.setTel(pers.xingang.demo.random.RandomValueUtil.getTel());
                one.setSex(pers.xingang.demo.random.RandomValueUtil.getSex());
                one.setRoad(pers.xingang.demo.random.RandomValueUtil.getRoad());
                one.setName(pers.xingang.demo.random.RandomValueUtil.getChineseName());
                one.setEmail(pers.xingang.demo.random.RandomValueUtil.getEmail(6, 9));
                BigInsertDataMapper mapper = sqlSession.getMapper(BigInsertDataMapper.class);
                mapper.insert(one);
            }
            log.info("10w条数据插入完毕，耗时：{}ms", System.currentTimeMillis() - start);
        }
    }

    /**
     * 基于JDBC逐条插入10w数据                  耗时：163370ms
     * 基于JDBC分批插入10w条数据（不开事务）      耗时：126193ms
     * 基于JDBC分批插入10w条数据（Spring事务）   耗时：112559ms
     * 基于JDBC分批插入10w条数据（手动开启事务）   耗时：22414ms
     * 基于JDBC分批插入10w条数据（手动开启事务，jdbc url后拼接rewriteBatchedStatements=true）   耗时：2629ms
     * 基于MyBatis分批插入10w条数据（jdbc url后拼接rewriteBatchedStatements=true）   耗时：2129ms
     */
    public void insertBatchByMyBatis() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            log.info("10w条数据开始插入...");
            long start = System.currentTimeMillis();
            BigInsertData one;
            for (int i = 0; i < 10 * 10000; i++) {
                one = new BigInsertData();
                one.setId(i);
                one.setTel(pers.xingang.demo.random.RandomValueUtil.getTel());
                one.setSex(pers.xingang.demo.random.RandomValueUtil.getSex());
                one.setRoad(pers.xingang.demo.random.RandomValueUtil.getRoad());
                one.setName(pers.xingang.demo.random.RandomValueUtil.getChineseName());
                one.setEmail(pers.xingang.demo.random.RandomValueUtil.getEmail(6, 9));
                BigInsertDataMapper mapper = sqlSession.getMapper(BigInsertDataMapper.class);
                mapper.insert(one);
            }
            log.info("10w条数据插入完毕，耗时：{}ms", System.currentTimeMillis() - start);
        }
    }

    /**
     * 基于JDBC逐条插入10w数据                  耗时：163370ms
     * 基于JDBC分批插入10w条数据（不开事务）      耗时：126193ms
     * 基于JDBC分批插入10w条数据（Spring事务）   耗时：112559ms
     * 基于JDBC分批插入10w条数据（手动开启事务）   耗时：22414ms
     * 基于JDBC分批插入10w条数据（手动开启事务，jdbc url后拼接rewriteBatchedStatements=true）   耗时：2629ms
     * 基于MyBatis分批插入10w条数据（jdbc url后拼接rewriteBatchedStatements=true）   耗时：2129ms
     * 基于MyBatis分批插入10w条数据（jdbc url后不拼接rewriteBatchedStatements=true）  耗时：2868ms
     */
    public void insertBatchByMyBatis2() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            log.info("10w条数据开始插入...");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10 * 10000; i++) {
                BigInsertData one = new BigInsertData();
                one.setId(i);
                one.setTel(pers.xingang.demo.random.RandomValueUtil.getTel());
                one.setSex(pers.xingang.demo.random.RandomValueUtil.getSex());
                one.setRoad(pers.xingang.demo.random.RandomValueUtil.getRoad());
                one.setName(pers.xingang.demo.random.RandomValueUtil.getChineseName());
                one.setEmail(pers.xingang.demo.random.RandomValueUtil.getEmail(6, 9));
                // BigInsertDataMapper mapper = sqlSession.getMapper(BigInsertDataMapper.class);
                // mapper.insert(one);
                // 等同于
                sqlSession.insert("pers.xingang.demo.mapper.BigInsertDataMapper.insert", one);
            }
            log.info("10w条数据插入完毕，耗时：{}ms", System.currentTimeMillis() - start);
        }
    }
}
