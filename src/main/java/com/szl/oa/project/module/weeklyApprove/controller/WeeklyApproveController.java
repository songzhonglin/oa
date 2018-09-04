package com.szl.oa.project.module.weeklyApprove.controller;

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
import com.szl.oa.project.module.weeklyApprove.domain.WeeklyApprove;
import com.szl.oa.project.module.weeklyApprove.service.IWeeklyApproveService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;

/**
 * 周报管理 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-18
 */
@Controller
@RequestMapping("/module/weeklyApprove")
public class WeeklyApproveController extends BaseController
{
    private String prefix = "module/weeklyApprove";
	
	@Autowired
	private IWeeklyApproveService weeklyApproveService;
	
	@RequiresPermissions("module:weeklyApprove:view")
	@GetMapping()
	public String weeklyApprove()
	{
	    return prefix + "/weeklyApprove";
	}
	
	/**
	 * 查询周报管理列表
	 */
	@RequiresPermissions("module:weeklyApprove:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WeeklyApprove weeklyApprove)
	{
		startPage();
        List<WeeklyApprove> list = weeklyApproveService.selectWeeklyApproveList(weeklyApprove);
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
	@RequiresPermissions("module:weeklyApprove:add")
	@Log(title = "周报管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WeeklyApprove weeklyApprove)
	{		
		return toAjax(weeklyApproveService.insertWeeklyApprove(weeklyApprove));
	}

	/**
	 * 审批周报管理
	 */
	@GetMapping("/approve/{approveId}")
	public String approve(@PathVariable("approveId") Long approveId, ModelMap mmap)
	{
		WeeklyApprove weeklyApprove = weeklyApproveService.selectWeeklyApproveById(approveId);
		mmap.put("weeklyApprove", weeklyApprove);
	    return prefix + "/approve";
	}

	
	/**
	 * 审批周报管理
	 */
	@RequiresPermissions("module:weeklyApprove:approve")
	@Log(title = "周报管理", businessType = BusinessType.APPROVE)
	@PostMapping("/approve")
	@ResponseBody
	public AjaxResult approveSave(WeeklyApprove weeklyApprove)
	{		
		return toAjax(weeklyApproveService.updateWeeklyApprove(weeklyApprove));
	}
	
	/**
	 * 删除周报管理
	 */
	@RequiresPermissions("module:weeklyApprove:remove")
	@Log(title = "周报管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(weeklyApproveService.deleteWeeklyApproveByIds(ids));
	}
	
}
