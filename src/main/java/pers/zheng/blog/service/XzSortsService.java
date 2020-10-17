package pers.zheng.blog.service;

import pers.zheng.blog.entity.XzSorts;

import java.util.List;

/**
 * (XzSorts)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:04
 */
public interface XzSortsService {

    /**
     * 通过ID查询单条数据
     *
     * @param sortId 主键
     * @return 实例对象
     */
    XzSorts queryById(Integer sortId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XzSorts> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xzSorts 实例对象
     * @return 实例对象
     */
    XzSorts insert(XzSorts xzSorts);

    /**
     * 修改数据
     *
     * @param xzSorts 实例对象
     * @return 实例对象
     */
    XzSorts update(XzSorts xzSorts);

    /**
     * 通过主键删除数据
     *
     * @param sortId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sortId);

}