package pers.xingang.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.xingang.demo.domain.BigInsertData;

/**
 * @author xingang
 * @since 2024/02/29 16:17
 */
@Mapper
public interface BigInsertDataMapper {
    void insert(@Param("one") BigInsertData one);
}
