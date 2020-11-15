package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.LabelDTO;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.service.LabelService;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName LabelController
 * @Description TODO
 * @Author zheng
 * @Date 2020/11/1 19:29
 * @Version 1.0
 */
@Slf4j
@RestController()
@RequestMapping("/api/admin/labels")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping("")
    public Result listAll(@RequestParam(name = "more", required = false, defaultValue = "false") boolean more) {
        if (more) {
            return Result.success(labelService.listAllLabelWithArticleCountDTO());
        }
        return Result.success(labelService.listAllLabel());
    }

    /**
     * 添加标签
     *
     * @param labelDTO
     * @return
     */
    @PostMapping("")
    public Result insert(@Valid @RequestBody LabelDTO labelDTO) {
        labelService.insertLabel(labelDTO);
        return Result.success();
    }

    /**
     * 更新
     *
     * @param labelDTO
     * @param labelId
     * @return
     */
    @PutMapping("{labelId:\\d+}")
    public Result update(@Valid @RequestBody LabelDTO labelDTO, @PathVariable Integer labelId) {
        labelService.updateLabel(labelId, labelDTO);
        return Result.success();
    }

    @DeleteMapping("{labelId:\\d+}")
    public Result delete(@PathVariable Integer labelId) {
        labelService.delete(labelId);
        return Result.success();
    }
}
