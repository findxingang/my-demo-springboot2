package pers.xingang.demo.common.dbtype;

import cn.hutool.core.util.StrUtil;
import pers.xingang.demo.ds.domain.DsDatasource;
import pers.xingang.demo.common.enums.DbType;
import pers.xingang.demo.util.SpringUtil;

import java.util.Map;

/**
 * 数据库类型接口, 提供通用的数据库相关操作
 * @author xingang
 * @since 2024/03/01 16:47
 */
public interface IDbType {

    /**
     * 获取jdbc字符串
     * @return 根据数据源属性拼接后的jdbc url
     */
    default String getJdbcUrl(DsDatasource dsDatasource){
        return StrUtil.format(DbType.MYSQL.getJdbcUrl(), dsDatasource.getHost(), dsDatasource.getPort(), dsDatasource.getDsSchema());
    }

    static IDbType of(DbType dbType) {
        Map<String, IDbType> map = SpringUtil.getBeansOfType(IDbType.class);
        return map.get(dbType.getDbTypeBeanName());
    }
}
