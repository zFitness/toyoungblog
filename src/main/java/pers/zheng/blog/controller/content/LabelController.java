package pers.zheng.blog.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.zheng.blog.entity.XzLabels;
import pers.zheng.blog.service.XzArticlesService;
import pers.zheng.blog.service.XzLabelsService;
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
    private XzArticlesService xzArticlesService;

    @Autowired
    private XzLabelsService xzLabelsService;

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
        XzLabels label = xzLabelsService.getLabelByName(labelName);
        IPage<ArticleItemVo> articleItems = xzArticlesService.getArticleItemsByLabel(p, label.getLabelId(), size);
        model.addAttribute("articleItems", articleItems);
        model.addAttribute("labelName", labelName);
        return "label";
    }

}
