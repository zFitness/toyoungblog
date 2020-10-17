package pers.zheng.blog.service;

import pers.zheng.blog.entity.XzUsers;

import java.util.List;

/**
 * (XzUsers)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:04
 */
public interface XzUsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    XzUsers queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XzUsers> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xzUsers 实例对象
     * @return 实例对象
     */
    XzUsers insert(XzUsers xzUsers);

    /**
     * 修改数据
     *
     * @param xzUsers 实例对象
     * @return 实例对象
     */
    XzUsers update(XzUsers xzUsers);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}