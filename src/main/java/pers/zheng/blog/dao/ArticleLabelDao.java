package pers.zheng.blog.dao;

import org.apache.ibatis.annotations.Param;
import pers.zheng.blog.model.entity.ArticleLabel;

import java.util.List;

/**
 * (XzArticleLabel)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:22:56
 */
public interface ArticleLabelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleLabel queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ArticleLabel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param articleLabel 实例对象
     * @return 对象列表
     */
    List<ArticleLabel> queryAll(ArticleLabel articleLabel);

    /**
     * 新增数据
     *
     * @param articleLabel 实例对象
     * @return 影响行数
     */
    int insert(ArticleLabel articleLabel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XzArticleLabel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ArticleLabel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XzArticleLabel> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ArticleLabel> entities);

    /**
     * 修改数据
     *
     * @param articleLabel 实例对象
     * @return 影响行数
     */
    int update(ArticleLabel articleLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}