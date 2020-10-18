package pers.zheng.blog.service;

import pers.zheng.blog.entity.XzComments;

import java.util.List;

/**
 * (XzComments)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
public interface XzCommentsService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    XzComments queryById(Integer commentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XzComments> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xzComments 实例对象
     * @return 实例对象
     */
    XzComments insert(XzComments xzComments);

    /**
     * 修改数据
     *
     * @param xzComments 实例对象
     * @return 实例对象
     */
    XzComments update(XzComments xzComments);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer commentId);

}