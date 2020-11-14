package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.SheetDao;
import pers.zheng.blog.exception.admin.DefaultNotFoundException;
import pers.zheng.blog.exception.admin.ItemExistException;
import pers.zheng.blog.exception.content.SheetNotFoundException;
import pers.zheng.blog.model.dto.SheetDTO;
import pers.zheng.blog.model.dto.SheetItemDTO;
import pers.zheng.blog.model.entity.Sheet;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/10
 */
@Service
public class SheetService {
    @Autowired
    private SheetDao sheetDao;

    /**
     * 根据页面别名获取页面
     *
     * @param sheetSlug
     * @return
     */
    public Sheet getSheetBySlug(String sheetSlug, String sheetStatus) {
        LambdaQueryWrapper<Sheet> wrapper = new LambdaQueryWrapper<>();
        //like是模糊查询， 类似于 %s%
        wrapper.eq(Sheet::getSheetSlug, sheetSlug)
                .eq(StringUtils.isNotEmpty(sheetStatus), Sheet::getSheetStatus, sheetStatus);
        Sheet sheet = sheetDao.selectOne(wrapper);
        if (sheet == null) {
            throw new SheetNotFoundException("页面不存在");
        }
        return sheet;
    }


    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @param sheetTitle
     * @param sheetStatus
     * @return
     */
    public IPage<SheetItemDTO> listSheetItems(int page, int limit, String sheetTitle, String sheetStatus) {
        Page<SheetItemDTO> pageConf = new Page<>(page, limit);
        return sheetDao.sheetPage(pageConf, sheetTitle, sheetStatus);
    }

    public int insertSheet(SheetDTO sheetDTO) {
        //查询别名是否存在
        LambdaQueryWrapper<Sheet> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Sheet::getSheetSlug, sheetDTO.getSheetSlug())
                .last("limit 1");
        int i = sheetDao.selectCount(wrapper);
        if (i != 0) {
            throw new ItemExistException("相同别名的页面已经存在");
        }
        Sheet sheet = new Sheet();
        BeanUtils.copyProperties(sheetDTO, sheet);
        return sheetDao.insert(sheet);
    }

    public int updateSheet(Integer sheetId, SheetDTO sheetDTO) {
        //查询修改后的别名是否存在
        LambdaQueryWrapper<Sheet> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(Sheet::getSheetSlug, sheetDTO.getSheetSlug())
                .ne(Sheet::getSheetId, sheetId)
                .last("limit 1");
        int i = sheetDao.selectCount(wrapper1);
        if (i != 0) {
            throw new ItemExistException("相同别名的页面已经存在");
        }

        //先查询出对象
        Sheet sheet = sheetDao.selectById(sheetId);
        if (sheet == null) {
            throw new DefaultNotFoundException("页面不存在");
        }
        sheet.setSheetTitle(sheetDTO.getSheetTitle());
        sheet.setSheetSlug(sheetDTO.getSheetSlug());
        sheet.setSheetContent(sheetDTO.getSheetContent());
        sheet.setCommentStatus(sheetDTO.getCommentStatus());
        sheet.setSheetStatus(sheetDTO.getSheetStatus());
        sheet.setCreateTime(sheetDTO.getCreateTime());


        sheet.setSheetId(sheetId);
        return sheetDao.updateById(sheet);
    }

    public int updateStatus(Long sheetId, String status) {
        Sheet sheet = sheetDao.selectById(sheetId);
        if (sheet == null) {
            throw new DefaultNotFoundException("页面不存在");
        }
        sheet.setSheetStatus(status);
        return sheetDao.updateById(sheet);
    }

    public int deleteSheet(Long sheetId) {
        //查询页面是否存在
        if (!isExist(sheetId)) {
            throw new DefaultNotFoundException("页面不存在");
        }

        return sheetDao.deleteById(sheetId);

    }

    public boolean isExist(Long sheetId) {
        LambdaQueryWrapper<Sheet> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Sheet::getSheetId, sheetId)
                .last("limit 1");
        int j = sheetDao.selectCount(wrapper);
        return j != 0;
    }

    public Sheet getSheetById(Long sheetId) {
        Sheet sheet = sheetDao.selectById(sheetId);
        if (sheet == null) {
            throw new DefaultNotFoundException("页面不存在");
        }
        return sheet;
    }
}
