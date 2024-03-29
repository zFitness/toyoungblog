package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.ArticleDTO;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.model.enums.ArticleStatusEnum;
import pers.zheng.blog.service.ArticleService;

import javax.validation.Valid;

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

    /**
     * @param page
     * @param limit
     * @param title
     * @return
     */
    @GetMapping("")
    public Result list(@RequestParam(value = "page", defaultValue = "1") int page,
                       @RequestParam(value = "limit", defaultValue = "10") int limit,
                       @RequestParam(value = "title", required = false) String title) {
        return Result.success(articleService.listArticleDtoItems(page, limit, title));
    }

    /**
     * 添加文章接口
     *
     * @param article
     * @return
     */
    @PostMapping("")
    public Result add(@Valid @RequestBody ArticleDTO article) {
        log.info(article.toString());
        articleService.insertArticle(article);
        return Result.success();
    }

    /**
     * 更新文章
     *
     * @param articleDTO
     * @return
     */
    @PutMapping("")
    public Result updateArticle(@Valid @RequestBody ArticleDTO articleDTO) {
        log.info("updateArticle: " + articleDTO.getArticleId());
        articleService.updateArticle(articleDTO);
        return Result.success();
    }


    /**
     * 根据id获取文章接口
     *
     * @param id
     * @return
     */
    @GetMapping("{id:\\d+}")
    public Result getArticle(@PathVariable("id") int id) {
        log.info("fetchArticle: " + id);
        ArticleDTO articleDto = articleService.getArticleDTOById(id);

        return Result.success(articleDto);
    }


    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @DeleteMapping("{id:\\d+}")
    public Result deleteArticleById(@PathVariable int id) {
        log.info("deleteArticle: " + id);
        int i = articleService.deleteArticleById(id);
        return i == 0 ? Result.failure() : Result.success();
    }

    /**
     * 修改文章状态
     * @param id
     * @param status
     * @return
     */
    @PutMapping("{id:\\d+}/status/{status}")
    public Result setArticleStatus(@PathVariable("id") int id,
                                   @PathVariable("status") String status) {
        log.info("setArticleStatus: " + id + " " + status);

        int i = articleService.setArticleStatus(id, status);

        return Result.success();
    }
}
