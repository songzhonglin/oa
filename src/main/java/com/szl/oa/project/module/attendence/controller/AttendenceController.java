package com.szl.oa.project.module.attendence.controller;

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
import com.szl.oa.project.module.attendence.domain.Attendence;
import com.szl.oa.project.module.attendence.service.IAttendenceService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.aspectj.lang.enums.BusinessType;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;
import com.szl.oa.common.utils.poi.ExcelUtil;
import com.szl.oa.common.utils.StringUtils;


/**
 * 考勤管理 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-31
 */
@Controller
@RequestMapping("/module/attendence")
public class AttendenceController extends BaseController
{
    private String prefix = "module/attendence";
	
	@Autowired
	private IAttendenceService attendenceService;
	
	@RequiresPermissions("module:attendence:view")
	@GetMapping()
	public String attendence()
	{
	    return prefix + "/attendence";
	}
	
	/**
	 * 查询考勤管理列表
	 */
	@RequiresPermissions("module:attendence:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Attendence attendence)
	{
		startPage();
        List<Attendence> list = attendenceService.selectAttendenceList(attendence);
		return getDataTable(list);
	}
	
//	/**
//	 * 新增考勤管理
//	 */
//	@GetMapping("/add")
//	public String add()
//	{
//	    return prefix + "/add";
//	}
	
	/**
	 * 新增保存考勤管理
	 */
	@RequiresPermissions("module:attendence:add")
	@Log(title = "考勤管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Attendence attendence)
	{
		int cout = attendenceService.insertAttendence(attendence);
		if(cout == 0){
			return AjaxResult.error("上班已打卡");
		}else{
			return toAjax(cout);
		}
	}

//	/**
//	 * 修改考勤管理
//	 */
//	@GetMapping("/edit/{attendId}")
//	public String edit(@PathVariable("attendId") Long attendId, ModelMap mmap)
//	{
//		Attendence attendence = attendenceService.selectAttendenceById(attendId);
//		mmap.put("attendence", attendence);
//	    return prefix + "/edit";
//	}
	
	/**
	 * 修改保存考勤管理
	 */
	@RequiresPermissions("module:attendence:edit")
	@Log(title = "考勤管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Attendence attendence)
	{
		int cout = attendenceService.updateAttendence(attendence);
		if(cout == 0){
			return AjaxResult.error("下班已打卡");
		}else{
			return toAjax(cout);
		}
	}
	
	/**
	 * 删除考勤管理
	 */
	@RequiresPermissions("module:attendence:remove")
	@Log(title = "考勤管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(attendenceService.deleteAttendenceByIds(ids));
	}

    /**
     * 导出考勤管理
     */
    @RequiresPermissions("module:attendence:export")
    @Log(title = "考勤管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Attendence attendence) throws Exception
    {
        try
        {
            List<Attendence> list = attendenceService.selectAttendenceList(attendence);
            ExcelUtil<Attendence> util = new ExcelUtil<Attendence>(Attendence.class);
            return util.exportExcel(list, "attendence");
        }
        catch (Exception e)
        {
            return error("导出Excel失败，请联系管理员！");
        }
    }
	
}
