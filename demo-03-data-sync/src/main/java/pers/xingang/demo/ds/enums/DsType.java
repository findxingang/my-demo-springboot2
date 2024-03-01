package pers.xingang.demo.ds.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 数据源支持的类型
 *
 * @author xingang
 * @since 2024/03/01 15:12
 */
@Getter
public enum DsType {
    MYSQL("MySQL"),
    ORACLE("Oracle"),
    SQLSERVER("SQLServer"),
    POSTGRESQL("PostgreSQL"),
    ;

    /**
     * 数据库的标准名称
     */
    @EnumValue    // 标记数据库存的是这个字段的值
    private final String stdName;

    DsType(String stdName) {
        this.stdName = stdName;
    }
}
