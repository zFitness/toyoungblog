package pers.zheng.blog.service;

import pers.zheng.blog.entity.XzArticleLabel;

import java.util.List;

/**
 * (XzArticleLabel)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:22:56
 */
public interface XzArticleLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XzArticleLabel queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XzArticleLabel> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xzArticleLabel 实例对象
     * @return 实例对象
     */
    XzArticleLabel insert(XzArticleLabel xzArticleLabel);

    /**
     * 修改数据
     *
     * @param xzArticleLabel 实例对象
     * @return 实例对象
     */
    XzArticleLabel update(XzArticleLabel xzArticleLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}