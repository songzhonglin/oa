package com.szl.oa.project.module.weeklyReport.controller;

import java.util.List;
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
import com.szl.oa.project.module.weeklyReport.domain.WeeklyReport;
import com.szl.oa.project.module.weeklyReport.service.IWeeklyReportService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;

/**
 * 周报管理 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-11
 */
@Controller
@RequestMapping("/module/weeklyReport")
public class WeeklyReportController extends BaseController
{
    private String prefix = "module/weeklyReport";
	
	@Autowired
	private IWeeklyReportService weeklyReportService;
	
	@RequiresPermissions("module:weeklyReport:view")
	@GetMapping()
	public String weeklyReport()
	{
	    return prefix + "/weeklyReport";
	}
	
	/**
	 * 查询周报管理列表
	 */
	@RequiresPermissions("module:weeklyReport:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WeeklyReport weeklyReport)
	{
		startPage();
        List<WeeklyReport> list = weeklyReportService.selectWeeklyReportList(weeklyReport);
		return getDataTable(list);
	}
	
	/**
	 * 新增周报管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存周报管理
	 */
	@RequiresPermissions("module:weeklyReport:add")
	@Log(title = "周报管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WeeklyReport weeklyReport)
	{		
		return toAjax(weeklyReportService.insertWeeklyReport(weeklyReport));
	}

	/**
	 * 修改周报管理
	 */
	@GetMapping("/edit/{weekId}")
	public String edit(@PathVariable("weekId") Long weekId, ModelMap mmap)
	{
		WeeklyReport weeklyReport = weeklyReportService.selectWeeklyReportById(weekId);
		mmap.put("weeklyReport", weeklyReport);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存周报管理
	 */
	@RequiresPermissions("module:weeklyReport:edit")
	@Log(title = "周报管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WeeklyReport weeklyReport)
	{		
		return toAjax(weeklyReportService.updateWeeklyReport(weeklyReport));
	}
	
	/**
	 * 删除周报管理
	 */
	@RequiresPermissions("module:weeklyReport:remove")
	@Log(title = "周报管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(weeklyReportService.deleteWeeklyReportByIds(ids));
	}
	
}
