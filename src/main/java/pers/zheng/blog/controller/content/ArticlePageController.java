package pers.zheng.blog.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pers.zheng.blog.model.util.MarkdownEntity;
import pers.zheng.blog.model.vo.ArticleVO;
import pers.zheng.blog.model.vo.ArticleItemVO;
import pers.zheng.blog.service.ArticleService;
import pers.zheng.blog.util.MarkDown2HtmlWrapper;

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
    private ArticleService articleService;

    @GetMapping("/article/{articleSlug}")
    public String test(Model model, @PathVariable("articleSlug") String articleSlug) {
        ArticleVO articleVO = articleService.getArticleBySlug(articleSlug, "publish");
        //markdown转换
        MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofContent(articleVO.getArticleContent());
        articleVO.setArticleContent(markdownEntity.toString());
        articleVO.setArticleTocHtml(markdownEntity.getHtmlTOC());
        model.addAttribute("article", articleVO);


        //上一篇文章，下一篇文章
        ArticleItemVO articleItemPrev = articleService.getPrevArticleItemByArticleId(articleVO.getArticleId());
        ArticleItemVO articleItemNext = articleService.getNextArticleItemByArticleId(articleVO.getArticleId());
        model.addAttribute("articleItemPrev", articleItemPrev);
        model.addAttribute("articleItemNext", articleItemNext);
        return "article";
    }

    @GetMapping("/article/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword,
                         @RequestParam(value = "p", defaultValue = "1", required = false) int p) {
        IPage<ArticleItemVO> articleItems = articleService.listArticleItemsByName(p, 10, keyword);

        model.addAttribute("articleItems", articleItems);
        model.addAttribute("keyword", keyword);
        return "search";
    }
}
