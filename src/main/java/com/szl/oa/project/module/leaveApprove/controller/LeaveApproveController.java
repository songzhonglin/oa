package com.szl.oa.project.module.leaveApprove.controller;

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
import com.szl.oa.project.module.leaveApprove.domain.LeaveApprove;
import com.szl.oa.project.module.leaveApprove.service.ILeaveApproveService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;

/**
 * 请假管理 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-18
 */
@Controller
@RequestMapping("/module/leaveApprove")
public class LeaveApproveController extends BaseController
{
    private String prefix = "module/leaveApprove";
	
	@Autowired
	private ILeaveApproveService leaveApproveService;
	
	@RequiresPermissions("module:leaveApprove:view")
	@GetMapping()
	public String leaveApprove()
	{
	    return prefix + "/leaveApprove";
	}
	
	/**
	 * 查询请假管理列表
	 */
	@RequiresPermissions("module:leaveApprove:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(LeaveApprove leaveApprove)
	{
		startPage();
        List<LeaveApprove> list = leaveApproveService.selectLeaveApproveList(leaveApprove);
		return getDataTable(list);
	}
	
	/**
	 * 新增请假管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存请假管理
	 */
	@RequiresPermissions("module:leaveApprove:add")
	@Log(title = "请假管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(LeaveApprove leaveApprove)
	{		
		return toAjax(leaveApproveService.insertLeaveApprove(leaveApprove));
	}

	/**
	 * 修改请假管理
	 */
	@GetMapping("/approve/{approveId}")
	public String edit(@PathVariable("approveId") Long approveId, ModelMap mmap)
	{
		LeaveApprove leaveApprove = leaveApproveService.selectLeaveApproveById(approveId);
		mmap.put("leaveApprove", leaveApprove);
	    return prefix + "/approve";
	}
	
	/**
	 * 修改保存请假管理
	 */
	@RequiresPermissions("module:leaveApprove:approve")
	@Log(title = "请假管理", businessType = BusinessType.APPROVE)
	@PostMapping("/approve")
	@ResponseBody
	public AjaxResult approveSave(LeaveApprove leaveApprove)
	{		
		return toAjax(leaveApproveService.updateLeaveApprove(leaveApprove));
	}
	
	/**
	 * 删除请假管理
	 */
	@RequiresPermissions("module:leaveApprove:remove")
	@Log(title = "请假管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(leaveApproveService.deleteLeaveApproveByIds(ids));
	}
	
}
