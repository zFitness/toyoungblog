package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.entity.Links;

/**
 * @ClassName LinksDao
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/22 20:08
 * @Version 1.0
 */
@Mapper
@Repository
public interface LinksDao extends BaseMapper<Links> {

}
