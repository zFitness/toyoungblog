package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.ArticleDto;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.service.ArticlesService;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/23 21:42
 * @Version 1.0
 */
@Slf4j
@CrossOrigin
@RestController()
@RequestMapping("/api/admin/articles")
public class ArticleController {
    @Autowired
    private ArticlesService articlesService;

    @GetMapping("")
    public Result list(@RequestParam("page") int page,
                       @RequestParam("limit") int limit) {
        return Result.success(articlesService.getArticleDtoItems(page, limit));
    }

    @PostMapping("add")
    public Result add(@RequestBody ArticleDto article) {
        log.info(article.toString());
        articlesService.createArticle(article);
        return Result.success();
    }


    @GetMapping("{id}")
    public Result fetchArticle(@PathVariable("id") int id) {
        log.info("fetchArticle: " + id);
        ArticleDto articleDto = articlesService.getArticleDtoById(id);

        return Result.success(articleDto);
    }

    @PostMapping("update")
    public Result updateArticle(@RequestBody ArticleDto articleDto) {
        log.info("updateArticle: " + articleDto.getArticleId());
        articlesService.updateArticle(articleDto);
        return Result.success();
    }


    @PostMapping("delete")
    public Result deleteArticleById(@RequestParam("id") int id) {
        log.info("deleteArticle: " + id);
        int i = articlesService.deleteArticleById(id);
        return i == 0 ? Result.failure() : Result.success();
    }

    @PostMapping("setStatus")
    public Result setArticleStatus(@RequestParam("articleId") int articleId,
                                   @RequestParam("articleStatus") String articleStatus) {
        log.info("setArticleStatus: " + articleId + " " + articleStatus);

        int i = articlesService.setArticleStatus(articleId, articleStatus);

        return Result.success();
    }
}
