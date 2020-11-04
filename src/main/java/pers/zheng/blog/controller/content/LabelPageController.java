package pers.zheng.blog.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.model.util.MarkdownEntity;
import pers.zheng.blog.model.vo.ArticleItemVO;
import pers.zheng.blog.service.ArticleService;
import pers.zheng.blog.service.LabelService;
import pers.zheng.blog.util.MarkDown2HtmlWrapper;

/**
 * @ClassName LabelPageController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/31 16:36
 * @Version 1.0
 */
@Controller
public class LabelPageController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private LabelService labelService;

    @GetMapping("/labels/{labelName}")
    public String getArticlesByLabel(@PathVariable String labelName,
                                     @RequestParam(value = "p", defaultValue = "1", required = false) int p,
                                     Model model) {
        int size = 10;
        Label label = labelService.getLabelByName(labelName);
        if (label == null) {
            Page<ArticleItemVO> articleItems = new Page<>(p, 10);
            //没有这个标签
            model.addAttribute("articleItems", articleItems);
        } else {
            IPage<ArticleItemVO> articleItems = articleService.getArticleItemsByLabel(p, label.getLabelId(), size);
            for (ArticleItemVO itemVo : articleItems.getRecords()) {
                MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofContent(itemVo.getArticleSummary());
                itemVo.setArticleSummary(markdownEntity.toString());
            }
            model.addAttribute("articleItems", articleItems);
        }


        model.addAttribute("labelName", labelName);
        return "label";
    }

}
