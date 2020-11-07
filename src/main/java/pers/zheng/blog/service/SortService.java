package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticleSortDao;
import pers.zheng.blog.dao.SortDao;
import pers.zheng.blog.exception.admin.DefaultNotFoundException;
import pers.zheng.blog.exception.admin.ItemExistException;
import pers.zheng.blog.model.dto.SortDTO;
import pers.zheng.blog.model.entity.Sort;
import pers.zheng.blog.model.vo.SortVO;

import java.util.ArrayList;
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

    @Autowired
    private ArticleSortDao articleSortDao;

    /**
     * 查询所有分类及其下面的文章数量
     *
     * @return
     */
    public List<SortVO> listSortVO() {
        List<Sort> sortList = sortDao.selectList(null);
        List<SortVO> sortVOList = new ArrayList<>();
        //得到每个分类下面的文章数量
        for (Sort sort : sortList) {
            int count = articleSortDao.countPublishArticleBySort(sort.getSortId());
            SortVO sortVO = new SortVO();
            BeanUtils.copyProperties(sort, sortVO);
            sortVO.setCount(count);
            sortVOList.add(sortVO);
        }
        return sortVOList;
    }

    public Sort getSortByName(String sortName) {
        LambdaQueryWrapper<Sort> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Sort::getSortName, sortName);
        return sortDao.selectOne(wrapper);
    }

    public List<Sort> listSort() {
        return sortDao.selectList(null);
    }

    public int deleteSortById(Integer sortId) {
        int i = sortDao.deleteById(sortId);
        if (i == 0) {
            throw new DefaultNotFoundException("分类不存在");
        }
        return i;
    }

    public void insertSort(SortDTO sortDTO) {
        LambdaQueryWrapper<Sort> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Sort::getSortName, sortDTO.getSortName());
        Sort sort = sortDao.selectOne(wrapper);
        if (sort != null) {
            throw new ItemExistException("分类已经存在");
        }
        sort = new Sort();
        BeanUtils.copyProperties(sortDTO, sort);
        sortDao.insert(sort);
    }

    public void updateSort(SortDTO sortDTO) {
        Sort sort = sortDao.selectById(sortDTO.getSortId());
        if (sort == null) {
            throw new DefaultNotFoundException("分类不存在");
        }
        sort.setParentSortId(sortDTO.getParentSortId());
        sort.setSortName(sortDTO.getSortName());
        sort.setSortAlias(sortDTO.getSortAlias());
        sort.setSortDescription(sortDTO.getSortDescription());

        sortDao.updateById(sort);

    }
}