package pers.zheng.blog.service;

import pers.zheng.blog.entity.XzLabels;

import java.util.List;

/**
 * (XzLabels)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
public interface XzLabelsService {

    /**
     * 通过ID查询单条数据
     *
     * @param labelId 主键
     * @return 实例对象
     */
    XzLabels queryById(Integer labelId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XzLabels> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xzLabels 实例对象
     * @return 实例对象
     */
    XzLabels insert(XzLabels xzLabels);

    /**
     * 修改数据
     *
     * @param xzLabels 实例对象
     * @return 实例对象
     */
    XzLabels update(XzLabels xzLabels);

    /**
     * 通过主键删除数据
     *
     * @param labelId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer labelId);

}