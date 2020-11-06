package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticleLabelDao;
import pers.zheng.blog.dao.LabelDao;
import pers.zheng.blog.model.entity.Label;
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
        Label label = new Label();
        label.setLabelName(labelName);
        int count = labelDao.insert(label);
        return label;
    }

    public List<Label> getAllLabel() {
        return labelDao.selectList(null);
    }
}