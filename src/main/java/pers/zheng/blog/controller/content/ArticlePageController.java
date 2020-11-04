package pers.zheng.blog.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.zheng.blog.model.vo.ArticleContentVO;
import pers.zheng.blog.model.vo.ArticleItemVO;
import pers.zheng.blog.service.ArticleService;

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

    @RequestMapping("/article/{articleId}")
    public String test(Model model, @PathVariable("articleId") Long articleId) {
        ArticleContentVO articleContentVO = articleService.getArticleById(articleId);
        model.addAttribute("article", articleContentVO);


        //上一篇文章，下一篇文章
        ArticleItemVO articleItemPrev = articleService.getPrevArticleItemByArticleId(articleId);
        ArticleItemVO articleItemNext = articleService.getNextArticleItemByArticleId(articleId);
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
