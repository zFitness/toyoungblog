package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.ArticleDTO;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.service.ArticleService;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/23 21:42
 * @Version 1.0
 */
@Slf4j
@RestController()
@RequestMapping("/api/admin/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("")
    public Result list(@RequestParam("page") int page,
                       @RequestParam("limit") int limit,
                       @RequestParam(value = "title", required = false) String title) {
        log.info(title);
        return Result.success(articleService.listArticleDtoItems(page, limit, title));
    }


    @PostMapping("add")
    public Result add(@RequestBody ArticleDTO article) {
        log.info(article.toString());
        articleService.insertArticle(article);
        return Result.success();
    }


    @GetMapping("{id}")
    public Result getArticle(@PathVariable("id") int id) {
        log.info("fetchArticle: " + id);
        ArticleDTO articleDto = articleService.getArticleDtoById(id);

        return Result.success(articleDto);
    }

    @PostMapping("update")
    public Result updateArticle(@RequestBody ArticleDTO articleDto) {
        log.info("updateArticle: " + articleDto.getArticleId());
        articleService.updateArticle(articleDto);
        return Result.success();
    }


    @PostMapping("delete")
    public Result deleteArticleById(@RequestParam("id") int id) {
        log.info("deleteArticle: " + id);
        int i = articleService.deleteArticleById(id);
        return i == 0 ? Result.failure() : Result.success();
    }

    @PostMapping("setStatus")
    public Result setArticleStatus(@RequestParam("articleId") int articleId,
                                   @RequestParam("articleStatus") String articleStatus) {
        log.info("setArticleStatus: " + articleId + " " + articleStatus);

        int i = articleService.setArticleStatus(articleId, articleStatus);

        return Result.success();
    }
}
