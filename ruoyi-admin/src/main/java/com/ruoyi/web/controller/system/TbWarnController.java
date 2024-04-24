package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TbWarn;
import com.ruoyi.system.service.ITbWarnService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预警设置Controller
 * 
 * @author ruoyi
 * @date 2024-04-23
 */
@RestController
@RequestMapping("/system/warn")
public class TbWarnController extends BaseController
{
    @Autowired
    private ITbWarnService tbWarnService;

    /**
     * 查询预警设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:warn:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbWarn tbWarn)
    {
        startPage();
        List<TbWarn> list = tbWarnService.selectTbWarnList(tbWarn);
        return getDataTable(list);
    }

    /**
     * 导出预警设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:warn:export')")
    @Log(title = "预警设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbWarn tbWarn)
    {
        List<TbWarn> list = tbWarnService.selectTbWarnList(tbWarn);
        ExcelUtil<TbWarn> util = new ExcelUtil<TbWarn>(TbWarn.class);
        util.exportExcel(response, list, "预警设置数据");
    }

    /**
     * 获取预警设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:warn:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbWarnService.selectTbWarnById(id));
    }

    /**
     * 新增预警设置
     */
    @PreAuthorize("@ss.hasPermi('system:warn:add')")
    @Log(title = "预警设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbWarn tbWarn)
    {
        return toAjax(tbWarnService.insertTbWarn(tbWarn));
    }

    /**
     * 修改预警设置
     */
    @PreAuthorize("@ss.hasPermi('system:warn:edit')")
    @Log(title = "预警设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbWarn tbWarn)
    {
        return toAjax(tbWarnService.updateTbWarn(tbWarn));
    }

    /**
     * 删除预警设置
     */
    @PreAuthorize("@ss.hasPermi('system:warn:remove')")
    @Log(title = "预警设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbWarnService.deleteTbWarnByIds(ids));
    }
}
