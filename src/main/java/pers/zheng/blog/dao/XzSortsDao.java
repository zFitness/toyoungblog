package pers.zheng.blog.dao;

import org.apache.ibatis.annotations.Param;
import pers.zheng.blog.entity.XzSorts;

import java.util.List;

/**
 * (XzSorts)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
public interface XzSortsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sortId 主键
     * @return 实例对象
     */
    XzSorts queryById(Integer sortId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XzSorts> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xzSorts 实例对象
     * @return 对象列表
     */
    List<XzSorts> queryAll(XzSorts xzSorts);

    /**
     * 新增数据
     *
     * @param xzSorts 实例对象
     * @return 影响行数
     */
    int insert(XzSorts xzSorts);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XzSorts> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XzSorts> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XzSorts> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<XzSorts> entities);

    /**
     * 修改数据
     *
     * @param xzSorts 实例对象
     * @return 影响行数
     */
    int update(XzSorts xzSorts);

    /**
     * 通过主键删除数据
     *
     * @param sortId 主键
     * @return 影响行数
     */
    int deleteById(Integer sortId);

}