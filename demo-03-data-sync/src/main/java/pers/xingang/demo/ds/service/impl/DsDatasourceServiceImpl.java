package pers.xingang.demo.ds.service.impl;

import pers.xingang.demo.ds.domain.DsDatasource;
import pers.xingang.demo.ds.mapper.DsDatasourceMapper;
import pers.xingang.demo.ds.service.IDsDatasourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据源（暂时只考虑MySQL） 服务实现类
 * </p>
 *
 * @author xingang
 * @since 2024-03-01
 */
@Service
public class DsDatasourceServiceImpl extends ServiceImpl<DsDatasourceMapper, DsDatasource> implements IDsDatasourceService {

    @Override
    public boolean createDataSource(DsDatasource dsDatasource) {
        return baseMapper.insert(dsDatasource) > 0;
    }
}
