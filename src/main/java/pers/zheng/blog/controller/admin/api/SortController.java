package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
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
@CrossOrigin
@RestController()
@RequestMapping("/api/admin/sorts")
public class SortController {
    @Autowired
    private SortService sortService;

    @GetMapping("")
    public Result listSortVO() {
        return Result.success(sortService.listSortVO());
    }

    @PostMapping("/delete")
    public Result deleteSortById(@RequestParam("sortId") Integer sortId) {
        sortService.deleteSortById(sortId);
        return Result.success();
    }

    @PostMapping("/add")
    public Result addSort(@Valid @RequestBody SortDTO sortDTO) {
        sortService.insertSort(sortDTO);
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateSort(@Valid @RequestBody SortDTO sortDTO) {
        sortService.updateSort(sortDTO);
        return Result.success();
    }
}
