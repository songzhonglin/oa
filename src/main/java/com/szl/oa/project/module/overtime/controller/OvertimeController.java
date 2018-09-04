package com.szl.oa.project.module.overtime.controller;

import java.util.ArrayList;
import java.util.List;

import com.szl.oa.common.utils.DateStyle;
import com.szl.oa.common.utils.DateUtils;
import com.szl.oa.project.module.overtime.domain.OvertimeExcel;
import com.szl.oa.project.system.dept.service.IDeptService;
import com.szl.oa.project.system.dict.service.IDictDataService;
import com.szl.oa.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
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
import com.szl.oa.project.module.overtime.domain.Overtime;
import com.szl.oa.project.module.overtime.service.IOvertimeService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;
import com.szl.oa.common.utils.poi.ExcelUtil;


/**
 * 我的加班 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-30
 */
@Controller
@RequestMapping("/module/overtime")
public class OvertimeController extends BaseController
{
    private String prefix = "module/overtime";
	
	@Autowired
	private IOvertimeService overtimeService;

	@Autowired
	private IDeptService deptService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IDictDataService dictDataService;
	
	@RequiresPermissions("module:overtime:view")
	@GetMapping()
	public String overtime()
	{
	    return prefix + "/overtime";
	}
	
	/**
	 * 查询我的加班列表
	 */
	@RequiresPermissions("module:overtime:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Overtime overtime)
	{
		startPage();
        List<Overtime> list = overtimeService.selectOvertimeList(overtime);
		return getDataTable(list);
	}
	
	/**
	 * 新增我的加班
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存我的加班
	 */
	@RequiresPermissions("module:overtime:add")
	@Log(title = "我的加班", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Overtime overtime)
	{		
		return toAjax(overtimeService.insertOvertime(overtime));
	}

	/**
	 * 修改我的加班
	 */
	@GetMapping("/edit/{overtimeId}")
	public String edit(@PathVariable("overtimeId") Long overtimeId, ModelMap mmap)
	{
		Overtime overtime = overtimeService.selectOvertimeById(overtimeId);
		mmap.put("overtime", overtime);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存我的加班
	 */
	@RequiresPermissions("module:overtime:edit")
	@Log(title = "我的加班", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Overtime overtime)
	{		
		return toAjax(overtimeService.updateOvertime(overtime));
	}
	
	/**
	 * 删除我的加班
	 */
	@RequiresPermissions("module:overtime:remove")
	@Log(title = "我的加班", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(overtimeService.deleteOvertimeByIds(ids));
	}

    /**
     * 导出我的加班
     */
    @RequiresPermissions("module:overtime:export")
    @Log(title = "我的加班", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Overtime overtime) throws Exception
    {
        try
        {
            List<Overtime> list = overtimeService.selectOvertimeList(overtime);
            List<OvertimeExcel> overtimeExcelList  =  new ArrayList<>();
            for (Overtime ot : list){
				OvertimeExcel overtimeExcel = new OvertimeExcel();
				BeanUtils.copyProperties(ot,overtimeExcel);
				overtimeExcel.setDeptName(deptService.selectDeptById(ot.getDeptId()).getDeptName());
				overtimeExcel.setApproveUserName(userService.selectUserById(ot.getUserId()).getLoginName());
				overtimeExcel.setStatusName(dictDataService.selectDictLabel("sys_daily_approve",ot.getStatus()));
				overtimeExcel.setCreateTimes(DateUtils.parseDateToStr(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue(),ot.getCreateTime()));
				overtimeExcelList.add(overtimeExcel);
			}
            ExcelUtil<OvertimeExcel> util = new ExcelUtil<OvertimeExcel>(OvertimeExcel.class);
            return util.exportExcel(overtimeExcelList, "我的加班");
        }
        catch (Exception e)
        {
            return error("导出Excel失败，请联系管理员！");
        }
    }
	
}
