package pers.xingang.demo.ds.service;

import pers.xingang.demo.ds.domain.DsDatasource;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 数据源（暂时只考虑MySQL） 服务类
 * </p>
 *
 * @author xingang
 * @since 2024-03-01
 */
public interface IDsDatasourceService extends IService<DsDatasource> {

    boolean createDataSource(DsDatasource dsDatasource);

    boolean connect(String id);
}
