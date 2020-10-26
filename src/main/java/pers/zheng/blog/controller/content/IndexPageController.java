package pers.zheng.blog.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.zheng.blog.model.util.MarkdownEntity;
import pers.zheng.blog.service.ArticlesService;
import pers.zheng.blog.util.MarkDown2HtmlWrapper;
import pers.zheng.blog.util.MarkdownUtils;
import pers.zheng.blog.model.vo.ArticleItemVo;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/10 15:19
 * @Version 1.0
 */
@Slf4j
@Controller
public class IndexPageController {
    @Autowired
    private ArticlesService articlesService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "p", defaultValue = "1", required = false) int p) {
        log.info(p + "");
        int size = 10;
        IPage<ArticleItemVo> articleItems = articlesService.getArticleItems(p, size);
        for (ArticleItemVo itemVo : articleItems.getRecords()) {
            MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofContent(itemVo.getArticleSummary());
            itemVo.setArticleSummary(markdownEntity.toString());
        }
        model.addAttribute("articleItems", articleItems);
        return "index";
    }
}
