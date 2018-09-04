package com.szl.oa.project.module.dailyApprove.controller;

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
import com.szl.oa.project.module.dailyApprove.domain.DailyApprove;
import com.szl.oa.project.module.dailyApprove.service.IDailyApproveService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;

/**
 * 日报管理 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-17
 */
@Controller
@RequestMapping("/module/dailyApprove")
public class DailyApproveController extends BaseController
{
    private String prefix = "module/dailyApprove";
	
	@Autowired
	private IDailyApproveService dailyApproveService;
	
	@RequiresPermissions("module:dailyApprove:view")
	@GetMapping()
	public String dailyApprove()
	{
	    return prefix + "/dailyApprove";
	}
	
	/**
	 * 查询日报管理列表
	 */
	@RequiresPermissions("module:dailyApprove:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DailyApprove dailyApprove)
	{
		startPage();
        List<DailyApprove> list = dailyApproveService.selectDailyApproveList(dailyApprove);
		return getDataTable(list);
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
	@RequiresPermissions("module:dailyApprove:add")
	@Log(title = "日报管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DailyApprove dailyApprove)
	{		
		return toAjax(dailyApproveService.insertDailyApprove(dailyApprove));
	}

	/**
	 * 审批日报管理
	 */
	@GetMapping("/approve/{approveId}")
	public String approve(@PathVariable("approveId") Long approveId, ModelMap mmap)
	{
		DailyApprove dailyApprove = dailyApproveService.selectDailyApproveById(approveId);
		mmap.put("dailyApprove", dailyApprove);
	    return prefix + "/approve";
	}
	
	/**
	 * 审批保存日报管理
	 */
	@RequiresPermissions("module:dailyApprove:approve")
	@Log(title = "日报管理", businessType = BusinessType.APPROVE)
	@PostMapping("/approve")
	@ResponseBody
	public AjaxResult approveSave(DailyApprove dailyApprove)
	{		
		return toAjax(dailyApproveService.updateDailyApprove(dailyApprove));
	}
	
	/**
	 * 删除日报管理
	 */
	@RequiresPermissions("module:dailyApprove:remove")
	@Log(title = "日报管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(dailyApproveService.deleteDailyApproveByIds(ids));
	}
	
}
