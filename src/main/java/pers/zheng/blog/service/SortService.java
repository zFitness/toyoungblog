package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.SortDao;
import pers.zheng.blog.model.entity.Sort;
import pers.zheng.blog.model.vo.SortVo;

import java.util.List;

/**
 * (XzSorts)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:04
 */
@Service
public class SortService {
    @Autowired
    private SortDao sortDao;

    public List<SortVo> getAllSort() {
        return sortDao.getAllSort();
    }

    public Sort getSortByName(String sortName) {
        LambdaQueryWrapper<Sort> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Sort::getSortName, sortName);
        return sortDao.selectOne(wrapper);
    }
}