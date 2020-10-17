package pers.zheng.blog.dao;

import org.apache.ibatis.annotations.Param;
import pers.zheng.blog.entity.XzArticleSort;

import java.util.List;

/**
 * (XzArticleSort)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
public interface XzArticleSortDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XzArticleSort queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XzArticleSort> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xzArticleSort 实例对象
     * @return 对象列表
     */
    List<XzArticleSort> queryAll(XzArticleSort xzArticleSort);

    /**
     * 新增数据
     *
     * @param xzArticleSort 实例对象
     * @return 影响行数
     */
    int insert(XzArticleSort xzArticleSort);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XzArticleSort> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XzArticleSort> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XzArticleSort> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<XzArticleSort> entities);

    /**
     * 修改数据
     *
     * @param xzArticleSort 实例对象
     * @return 影响行数
     */
    int update(XzArticleSort xzArticleSort);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}