package pers.zheng.blog.service;

import pers.zheng.blog.entity.ArticleSort;

import java.util.List;

/**
 * (XzArticleSort)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
public interface ArticleSortService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleSort queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ArticleSort> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param articleSort 实例对象
     * @return 实例对象
     */
    ArticleSort insert(ArticleSort articleSort);

    /**
     * 修改数据
     *
     * @param articleSort 实例对象
     * @return 实例对象
     */
    ArticleSort update(ArticleSort articleSort);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}