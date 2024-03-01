package pers.xingang.demo.ds.mapper;

import pers.xingang.demo.ds.domain.DsDatasource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 数据源（暂时只考虑MySQL） Mapper 接口
 * </p>
 *
 * @author xingang
 * @since 2024-03-01
 */
@Mapper
public interface DsDatasourceMapper extends BaseMapper<DsDatasource> {

}
