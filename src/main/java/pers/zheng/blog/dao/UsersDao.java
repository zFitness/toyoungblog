package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.zheng.blog.model.entity.User;

import java.util.List;

/**
 * (XzUsers)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:04
 */
@Mapper
public interface UsersDao extends BaseMapper<User> {


}