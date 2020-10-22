package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.entity.Option;

/**
 * @ClassName OptionDao
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/22 22:14
 * @Version 1.0
 */
@Mapper
@Repository
public interface OptionDao extends BaseMapper<Option> {

}
