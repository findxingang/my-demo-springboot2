package pers.xingang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.xingang.domain.Book;

/**
 * @author xingang
 * @since 2024/04/28 19:13
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
