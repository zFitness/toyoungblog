package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.SortDTO;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.service.SortService;

import javax.validation.Valid;

/**
 * @ClassName LabelController
 * @Description TODO
 * @Author zheng
 * @Date 2020/11/1 19:29
 * @Version 1.0
 */
@Slf4j
@RestController()
@RequestMapping("/api/admin/sorts")
public class SortController {
    @Autowired
    private SortService sortService;

    /**
     * @param page
     * @param limit
     * @param more  是否查看数量
     * @return
     */
    @GetMapping("")
    public Result listAll(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "10") int limit,
                          @RequestParam(name = "more", required = false, defaultValue = "false") boolean more) {
        if (more) {
            return Result.success(sortService.listSortWithArticleCountDTO());
        }

        return Result.success(sortService.listSort());
    }

    /**
     * 删除分类
     *
     * @param sortId
     * @return
     */
    @DeleteMapping("{sortId:\\d+}")
    public Result deleteSortById(@PathVariable("sortId") Integer sortId) {
        sortService.deleteSortById(sortId);
        return Result.success();
    }

    /**
     * 添加分类
     *
     * @param sortDTO
     * @return
     */
    @PostMapping("")
    public Result addSort(@Valid @RequestBody SortDTO sortDTO) {
        sortService.insertSort(sortDTO);
        return Result.success();
    }

    /**
     * 更新分类
     *
     * @param sortId
     * @param sortDTO
     * @return
     */
    @PutMapping("{sortId:\\d+}")
    public Result updateSort(@PathVariable Integer sortId,
                             @Valid @RequestBody SortDTO sortDTO) {
        sortService.updateSort(sortId, sortDTO);
        return Result.success();
    }
}
