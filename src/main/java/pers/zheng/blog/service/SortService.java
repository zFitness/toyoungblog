package pers.zheng.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.SortDao;

/**
 * (XzSorts)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:04
 */
@Service
public class SortService {
    @Autowired
    private SortDao sortsDao;

}