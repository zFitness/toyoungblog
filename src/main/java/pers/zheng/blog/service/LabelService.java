package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticleLabelDao;
import pers.zheng.blog.dao.LabelDao;
import pers.zheng.blog.exception.admin.DefaultNotFoundException;
import pers.zheng.blog.exception.admin.ItemExistException;
import pers.zheng.blog.model.dto.LabelDTO;
import pers.zheng.blog.model.dto.LabelWithArticleCountDTO;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.model.entity.Sort;
import pers.zheng.blog.model.vo.LabelVO;

import java.util.ArrayList;
import java.util.List;

/**
 * (XzLabels)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private ArticleLabelDao articleLabelDao;

    public Label getLabelByName(String labelName) {
        LambdaQueryWrapper<Label> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Label::getLabelName, labelName);
        return labelDao.selectOne(queryWrapper);
    }

    /**
     * 返回所有标签及其下的可见文章数量
     *
     * @return
     */
    public List<LabelVO> listLabelVO() {
        List<Label> labelList = labelDao.selectList(null);
        List<LabelVO> labelVOList = new ArrayList<>();
        //得到每个标签下面的可见的文章数量
        for (Label label : labelList) {
            int count = articleLabelDao.countPublishArticleByLabel(label.getLabelId());
            LabelVO labelVO = new LabelVO();
            labelVO.setLabelId(label.getLabelId());
            labelVO.setLabelName(label.getLabelName());
            labelVO.setArticleCount(count);
            labelVOList.add(labelVO);
        }
        return labelVOList;
    }

    public Label addByName(String labelName) {
        //先查询
        LambdaQueryWrapper<Label> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Label::getLabelName, labelName);
        List<Label> labels = labelDao.selectList(queryWrapper);
        if (labels.size() != 0) {
            throw new ItemExistException("标签存在");
        }
        Label label = new Label();
        label.setLabelName(labelName);
        int count = labelDao.insert(label);
        return label;
    }

    public List<Label> listAllLabel() {
        List<Label> labelList = labelDao.selectList(null);
        return labelList;
    }

    public int updateLabel(Integer labelId, LabelDTO labelDTO) {
        //判断标签是否存在
        LambdaQueryWrapper<Label> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Label::getLabelName, labelDTO.getLabelName())
                .ne(Label::getLabelId, labelId)
                .last("limit 1");
        int i = labelDao.selectCount(wrapper);
        if (i != 0) {
            throw new ItemExistException("标签名存在");
        }
        //判断别名是否存在
        LambdaQueryWrapper<Label> wrapperSlug = new LambdaQueryWrapper<>();
        wrapperSlug.eq(Label::getLabelSlug, labelDTO.getLabelSlug())
                .ne(Label::getLabelId, labelId)
                .last("limit 1");
        i = labelDao.selectCount(wrapperSlug);
        if (i != 0) {
            throw new ItemExistException("别名存在");
        }


        Label label = labelDao.selectById(labelId);
        if (label == null) {
            throw new DefaultNotFoundException("标签不存在");
        }
        BeanUtils.copyProperties(labelDTO, label);
        label.setLabelId(labelId);
        return labelDao.updateById(label);
    }

    public int delete(Integer labelId) {
        Label label = labelDao.selectById(labelId);
        if (label == null) {
            throw new DefaultNotFoundException("标签不存在");
        }
        return labelDao.deleteById(label.getLabelId());
    }

    public List<LabelWithArticleCountDTO> listAllLabelWithArticleCountDTO() {
        List<Label> labelList = labelDao.selectList(null);
        List<LabelWithArticleCountDTO> labelDTOList = new ArrayList<>();
        //得到每个标签下面的可见的文章数量
        for (Label label : labelList) {
            int count = articleLabelDao.countPublishArticleByLabel(label.getLabelId());

            LabelWithArticleCountDTO labelDTO = new LabelWithArticleCountDTO();
            BeanUtils.copyProperties(label, labelDTO);
            labelDTO.setArticleCount(count);
            labelDTOList.add(labelDTO);
        }
        return labelDTOList;

    }

    public int insertLabel(LabelDTO labelDTO) {
        //判断标签是否存在
        LambdaQueryWrapper<Label> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Label::getLabelName, labelDTO.getLabelName())
                .last("limit 1");
        int i = labelDao.selectCount(wrapper);
        if (i != 0) {
            throw new ItemExistException("标签名存在");
        }

        //判断标签是否存在
        LambdaQueryWrapper<Label> wrapperSlug = new LambdaQueryWrapper<>();
        wrapperSlug.eq(Label::getLabelSlug, labelDTO.getLabelSlug())
                .last("limit 1");
        i = labelDao.selectCount(wrapperSlug);
        if (i != 0) {
            throw new ItemExistException("别名存在");
        }

        Label label = new Label();
        BeanUtils.copyProperties(labelDTO, label);
        return labelDao.insert(label);
    }
}