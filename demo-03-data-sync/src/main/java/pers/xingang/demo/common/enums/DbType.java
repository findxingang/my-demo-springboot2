package pers.xingang.demo.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 数据源支持的类型
 *
 * @author xingang
 * @since 2024/03/01 15:12
 */
@Getter
public enum DbType {
    MYSQL("MySQL", "jdbc:mysql://{}:{}/{}", "DbTypeMySQL"),
    ORACLE("Oracle", "jdbc:mysql://{}:{}/{}", "DbTypeMySQL"),
    SQLSERVER("SQLServer", "jdbc:mysql://{}:{}/{}", "DbTypeMySQL"),
    POSTGRESQL("PostgreSQL", "jdbc:mysql://{}:{}/{}", "DbTypeMySQL"),
    ;

    /**
     * 数据库的标准名称
     */
    @EnumValue    // 标记数据库存的是这个字段的值
    private final String stdName;

    private final String jdbcUrl;

    private final String dbTypeBeanName;

    DbType(String stdName, String jdbcUrl, String dbTypeBeanName) {
        this.stdName = stdName;
        this.jdbcUrl = jdbcUrl;
        this.dbTypeBeanName = dbTypeBeanName;
    }
}
