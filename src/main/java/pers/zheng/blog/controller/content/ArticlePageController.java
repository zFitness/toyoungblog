package pers.zheng.blog.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.util.MarkdownEntity;
import pers.zheng.blog.service.ArticlesService;
import pers.zheng.blog.util.MarkDown2HtmlWrapper;
import pers.zheng.blog.util.MarkdownUtils;
import pers.zheng.blog.model.vo.ArticleContentVo;
import pers.zheng.blog.model.vo.ArticleItemVo;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/11 21:53
 * @Version 1.0
 */
@Slf4j
@Controller
public class ArticlePageController {
    @Autowired
    private ArticlesService articlesService;

    @RequestMapping("/article/{articleId}")
    public String test(Model model, @PathVariable("articleId") Long articleId) {
        ArticleContentVo articleContentVO = articlesService.getArticleById(articleId);
        MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofContent(articleContentVO.getArticleContent());
        articleContentVO.setArticleContentHTML(markdownEntity.toString());
        articleContentVO.setArticleTocHTML(markdownEntity.getHtmlTOC());

        model.addAttribute("article", articleContentVO);
        return "article";
    }

    @GetMapping("/article/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword,
                         @RequestParam(value = "p", defaultValue = "1", required = false) int p) {
        IPage<ArticleItemVo> articleItems = articlesService.getArticleItemsByName(p, 10, keyword);
        log.info(articleItems.getRecords().toString());
        log.info(articleItems.getCurrent() + "");
        model.addAttribute("articleItems", articleItems);
        model.addAttribute("keyword", keyword);
        return "search";
    }
}
