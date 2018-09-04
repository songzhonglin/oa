package com.szl.oa.project.module.leave.controller;

import java.util.List;

import com.szl.oa.project.system.user.service.IUserService;
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
import com.szl.oa.project.module.leave.domain.Leave;
import com.szl.oa.project.module.leave.service.ILeaveService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;

/**
 * 请假管理 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-11
 */
@Controller
@RequestMapping("/module/leave")
public class LeaveController extends BaseController
{
    private String prefix = "module/leave";
	
	@Autowired
	private ILeaveService leaveService;

	@Autowired
	private IUserService userService;
	
	@RequiresPermissions("module:leave:view")
	@GetMapping("/view")
	public String leave()
	{
	    return prefix + "/leave";
	}

	@RequiresPermissions("module:leave:query")
	@GetMapping("/query")
	public String query()
	{
		return prefix + "/query";
	}

	/**
	 * 查询请假管理列表
	 */
	@RequiresPermissions("module:leave:query:list")
	@PostMapping("/queryList")
	@ResponseBody
	public TableDataInfo queryList(Leave leave)
	{
		startPage();
		List<Leave> list = leaveService.queryLeaveList(leave);
		return getDataTable(list);
	}

	/**
	 * 删除请假管理
	 */
	@RequiresPermissions("module:leave:query:delete")
	@Log(title = "请假管理", businessType = BusinessType.DELETE)
	@PostMapping( "/delete")
	@ResponseBody
	public AjaxResult delete(String ids)
	{
		return toAjax(leaveService.deleteLeaveByIds(ids));
	}
	
	/**
	 * 查询请假管理列表
	 */
	@RequiresPermissions("module:leave:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Leave leave)
	{
		startPage();
        List<Leave> list = leaveService.selectLeaveList(leave);
		return getDataTable(list);
	}
	
	/**
	 * 新增请假管理
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
//		mmap.put("users", userService.selectUserList(null));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存请假管理
	 */
	@RequiresPermissions("module:leave:add")
	@Log(title = "我的请假", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Leave leave)
	{		
		return toAjax(leaveService.insertLeave(leave));
	}

	/**
	 * 修改请假管理
	 */
	@GetMapping("/edit/{leaveId}")
	public String edit(@PathVariable("leaveId") String leaveId, ModelMap mmap)
	{
		Leave leave = leaveService.selectLeaveById(leaveId);
		mmap.put("leave", leave);
		mmap.put("users", userService.selectUserById(leave.getUserId()));
	    return prefix + "/edit";
	}

	@GetMapping("/check/{leaveId}")
	public String check(@PathVariable("leaveId") String leaveId, ModelMap mmap)
	{
		Leave leave = leaveService.selectLeaveById(leaveId);
		mmap.put("leave", leave);
		return prefix + "/check";
	}


	
	/**
	 * 修改保存请假管理
	 */
	@RequiresPermissions("module:leave:edit")
	@Log(title = "我的请假", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Leave leave)
	{		
		return toAjax(leaveService.updateLeave(leave));
	}


	/**
	 * 删除请假管理
	 */
	@RequiresPermissions("module:leave:remove")
	@Log(title = "我的请假", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(leaveService.deleteLeaveByIds(ids));
	}
	
}
