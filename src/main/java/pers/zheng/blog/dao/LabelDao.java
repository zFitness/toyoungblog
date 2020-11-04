package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.model.vo.LabelVO;

import java.util.List;

/**
 * (XzLabels)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
@Mapper
@Repository
public interface LabelDao extends BaseMapper<Label> {

    List<LabelVO> listLabelVOs();
}