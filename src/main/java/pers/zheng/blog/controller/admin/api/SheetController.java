package pers.zheng.blog.controller.admin.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.SheetDTO;
import pers.zheng.blog.model.dto.SheetItemDTO;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.model.entity.Sheet;
import pers.zheng.blog.service.SheetService;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/10
 */
@Slf4j
@RestController
@RequestMapping("/api/admin/sheets")
public class SheetController {
    @Autowired
    private SheetService sheetService;

    /**
     * 分页
     *
     * @param page
     * @param limit
     * @param sheetTitle
     * @param sheetStatus
     * @return
     */
    @GetMapping("")
    public Result listSheets(@RequestParam("page") int page,
                             @RequestParam("limit") int limit,
                             @RequestParam(value = "title", required = false) String sheetTitle,
                             @RequestParam(value = "status", required = false) String sheetStatus) {

        IPage<SheetItemDTO> sheets = sheetService.listSheetItems(page, limit, sheetTitle, sheetStatus);
        return Result.success(sheets);
    }

    /**
     * 插入
     *
     * @param sheetDTO
     * @return
     */
    @PostMapping("")
    public Result insertSheet(@RequestBody SheetDTO sheetDTO) {
        int i = sheetService.insertSheet(sheetDTO);
        if (i != 0) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    /**
     * 更新
     *
     * @param sheetDTO
     * @return
     */
    @PutMapping("/{sheetId}")
    public Result updateSheet(@PathVariable Long sheetId,
                              @RequestBody SheetDTO sheetDTO) {
        log.info(sheetDTO.toString());
        int i = sheetService.updateSheet(sheetId, sheetDTO);
        if (i != 0) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    /**
     * 设置状态
     *
     * @param status
     * @return
     */
    @PostMapping("/{sheetId}/status")
    public Result updateStatus(@RequestParam("status") String status,
                               @PathVariable Long sheetId) {
        int i = sheetService.updateStatus(sheetId, status);
        if (i != 0) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    /**
     * 得到一个页面
     *
     * @param sheetSlug
     * @return
     */
    @GetMapping("/{sheetSlug}")
    public Result getSheet(@PathVariable String sheetSlug) {
        Sheet sheet = sheetService.getSheetBySlug(sheetSlug, null);
        return Result.success(sheet);
    }


    @DeleteMapping("/{sheetId}")
    public Result deleteSheet(@PathVariable Long sheetId) {
        sheetService.deleteSheet(sheetId);
        return Result.success();
    }
}
