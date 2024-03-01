package pers.xingang.demo.ds.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import pers.xingang.demo.common.enums.DbType;

/**
 * <p>
 * 数据源（暂时只考虑MySQL）
 * </p>
 *
 * @author xingang
 * @since 2024-03-01
 */
@Getter
@Setter
@TableName("t_datasource")
public class DsDatasource {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 数据源名称
     */
    @TableField
    private String dsName;

    /**
     * 数据源类型
     */
    @TableField
    private DbType dsType;

    /**
     * 主机
     */
    @TableField
    private String host;

    /**
     * 端口号
     */
    @TableField
    private String port;

    /**
     * Schema
     */
    @TableField
    private String dsSchema;

    /**
     * 用户名
     */
    @TableField
    private String username;

    /**
     * 密码
     */
    @TableField
    private String password;

    /**
     * JDBC URL
     */
    @TableField
    private String jdbcUrl;
}
