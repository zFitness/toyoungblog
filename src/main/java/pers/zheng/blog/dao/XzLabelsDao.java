package pers.zheng.blog.dao;

import org.apache.ibatis.annotations.Param;
import pers.zheng.blog.entity.XzLabels;

import java.util.List;

/**
 * (XzLabels)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
public interface XzLabelsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param labelId 主键
     * @return 实例对象
     */
    XzLabels queryById(Integer labelId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XzLabels> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xzLabels 实例对象
     * @return 对象列表
     */
    List<XzLabels> queryAll(XzLabels xzLabels);

    /**
     * 新增数据
     *
     * @param xzLabels 实例对象
     * @return 影响行数
     */
    int insert(XzLabels xzLabels);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XzLabels> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XzLabels> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XzLabels> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<XzLabels> entities);

    /**
     * 修改数据
     *
     * @param xzLabels 实例对象
     * @return 影响行数
     */
    int update(XzLabels xzLabels);

    /**
     * 通过主键删除数据
     *
     * @param labelId 主键
     * @return 影响行数
     */
    int deleteById(Integer labelId);

}