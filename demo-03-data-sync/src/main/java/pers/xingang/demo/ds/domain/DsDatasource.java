package pers.xingang.demo.ds.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import pers.xingang.demo.ds.enums.DsType;

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
    @TableId("id")
    private Long id;

    /**
     * 数据源名称
     */
    @TableField("ds_name")
    private String dsName;

    /**
     * 数据源类型
     */
    @TableField("ds_type")
    private DsType dsType;

    /**
     * 主机
     */
    @TableField("host")
    private String host;

    /**
     * 端口号
     */
    @TableField("port")
    private String port;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    public static final String ID = "id";

    public static final String DS_NAME = "ds_name";

    public static final String DS_TYPE = "ds_type";

    public static final String HOST = "host";

    public static final String PORT = "port";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";
}
