package com.szl.oa.project.module.daily.controller;

import java.util.List;

import com.szl.oa.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.szl.oa.framework.aspectj.lang.annotation.Log;
import com.szl.oa.framework.aspectj.lang.enums.BusinessType;
import com.szl.oa.project.module.daily.domain.Daily;
import com.szl.oa.project.module.daily.service.IDailyService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;

/**
 * 日报管理 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-09
 */
@Controller
@RequestMapping("/module/daily")
public class DailyController extends BaseController
{
    private String prefix = "module/daily";
	
	@Autowired
	private IDailyService dailyService;
	
	@RequiresPermissions("module:daily:view")
	@GetMapping()
	public String daily()
	{
	    return prefix + "/daily";
	}
	
	/**
	 * 查询日报管理列表
	 */
	@RequiresPermissions("module:daily:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Daily daily)
	{
		startPage();
        List<Daily> list = dailyService.selectDailyList(daily);
		return getDataTable(list);
	}

	@Log(title = "日报管理", businessType = BusinessType.EXPORT)
	@RequiresPermissions("module:daily:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Daily daily) throws Exception
	{
		try
		{
			List<Daily> list = dailyService.selectDailyList(daily);
			ExcelUtil<Daily> util = new ExcelUtil<Daily>(Daily.class);
			return util.exportExcel(list, "daily");
		}
		catch (Exception e)
		{
			return error("导出Excel失败，请联系管理员！");
		}
	}
	
	/**
	 * 新增日报管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存日报管理
	 */
	@RequiresPermissions("module:daily:add")
	@Log(title = "日报管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Daily daily)
	{		
		return toAjax(dailyService.insertDaily(daily));
	}

	/**
	 * 修改日报管理
	 */
	@GetMapping("/edit/{dailyId}")
	public String edit(@PathVariable("dailyId") Long dailyId, ModelMap mmap)
	{
		Daily daily = dailyService.selectDailyById(dailyId);
		mmap.put("daily", daily);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存日报管理
	 */
	@RequiresPermissions("module:daily:edit")
	@Log(title = "日报管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Daily daily)
	{		
		return toAjax(dailyService.updateDaily(daily));
	}
	
	/**
	 * 删除日报管理
	 */
	@RequiresPermissions("module:daily:remove")
	@Log(title = "日报管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(dailyService.deleteDailyByIds(ids));
	}
	
}
