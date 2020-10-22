package pers.zheng.blog.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.zheng.blog.entity.Labels;
import pers.zheng.blog.service.ArticlesService;
import pers.zheng.blog.service.LabelsService;
import pers.zheng.blog.vo.ArticleItemVo;

/**
 * @ClassName LabelController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/18 12:49
 * @Version 1.0
 */
@Controller
@RequestMapping("/labels")
public class LabelController {
    @Autowired
    private ArticlesService articlesService;

    @Autowired
    private LabelsService labelsService;

    /**
     * @return
     */
    @RequestMapping("")
    public String getAll() {
        return "labels";
    }

    @GetMapping("/{labelName}")
    public String getArticlesByLabel(@PathVariable String labelName,
                                     @RequestParam(value = "p", defaultValue = "1", required = false) int p,
                                     Model model) {
        int size = 10;
        Labels label = labelsService.getLabelByName(labelName);
        IPage<ArticleItemVo> articleItems = articlesService.getArticleItemsByLabel(p, label.getLabelId(), size);
        model.addAttribute("articleItems", articleItems);
        model.addAttribute("labelName", labelName);
        return "label";
    }

}
