package com.szl.oa.project.module.employee.controller;

import java.util.ArrayList;
import java.util.List;

import com.szl.oa.common.utils.StringUtils;
import com.szl.oa.common.utils.poi.ExcelUtil;
import com.szl.oa.project.module.employee.domain.EmployeeExcel;
import com.szl.oa.project.system.dept.service.IDeptService;
import com.szl.oa.project.system.dict.service.DictTypeServiceImpl;
import com.szl.oa.project.system.dict.service.IDictDataService;
import com.szl.oa.project.system.post.service.IPostService;
import com.szl.oa.project.system.user.domain.User;
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
import com.szl.oa.project.module.employee.domain.Employee;
import com.szl.oa.project.module.employee.service.IEmployeeService;
import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.framework.web.page.TableDataInfo;
import com.szl.oa.framework.web.domain.AjaxResult;

import javax.annotation.Resource;

/**
 * 员工管理 信息操作处理
 * 
 * @author songzl
 * @date 2018-08-19
 */
@Controller
@RequestMapping("/module/employee")
public class EmployeeController extends BaseController
{
    private String prefix = "module/employee";
	
	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private IPostService postService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IDictDataService dictDataService;

	@Autowired
	private IDeptService deptService;

	
	@RequiresPermissions("module:employee:view")
	@GetMapping()
	public String employee()
	{
	    return prefix + "/employee";
	}
	
	/**
	 * 查询员工管理列表
	 */
	@RequiresPermissions("module:employee:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Employee employee)
	{
		startPage();
        List<Employee> list = employeeService.selectEmployeeList(employee);
		return getDataTable(list);
	}
	
	/**
	 * 新增员工管理
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("posts", postService.selectPostAll());
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存员工管理
	 */
	@RequiresPermissions("module:employee:add")
	@Log(title = "员工管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Employee employee)
	{		
		return toAjax(employeeService.insertEmployee(employee));
	}

	/**
	 * 修改员工管理
	 */
	@GetMapping("/edit/{empId}")
	public String edit(@PathVariable("empId") Long empId, ModelMap mmap)
	{
		Employee employee = employeeService.selectEmployeeById(empId);
		mmap.put("employee", employee);
		mmap.put("posts", postService.selectPostsByUserId(employee.getCreateId()));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存员工管理
	 */
	@RequiresPermissions("module:employee:edit")
	@Log(title = "员工管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Employee employee)
	{		
		return toAjax(employeeService.updateEmployee(employee));
	}
	
	/**
	 * 删除员工管理
	 */
	@RequiresPermissions("module:employee:remove")
	@Log(title = "员工管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(employeeService.deleteEmployeeByIds(ids));
	}

	/**
	 * 校验用户名
	 */
	@PostMapping("/checkEmpAccountUnique")
	@ResponseBody
	public String checkEmpAccountUnique(Employee employee)
	{
		String uniqueFlag = "0";
		if (StringUtils.isNotNull(employee))
		{
			uniqueFlag = userService.checkLoginNameUnique(employee.getEmpAccount());
		}
		return uniqueFlag;
	}

	/**
	 * 校验手机号码
	 */
	@PostMapping("/checkEmpMobileUnique")
	@ResponseBody
	public String checkEmpMobileUnique(Employee employee)
	{
		String uniqueFlag = "0";
		if (StringUtils.isNotNull(employee))
		{
			User user =new User();
			user.setPhoneNumber(employee.getEmpMobilephone());
			uniqueFlag = userService.checkPhoneUnique(user);
		}
		return uniqueFlag;
	}

	/**
	 * 校验email邮箱
	 */
	@PostMapping("/checkEmpEmailUnique")
	@ResponseBody
	public String checkEmpEmailUnique(Employee employee)
	{
		String uniqueFlag = "0";
		if (StringUtils.isNotNull(employee))
		{
			User user =new User();
			user.setPhoneNumber(employee.getEmpMobilephone());
			uniqueFlag = userService.checkEmailUnique(user);
		}
		return uniqueFlag;
	}

	@Log(title = "员工管理", businessType = BusinessType.EXPORT)
	@RequiresPermissions("module:employee:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Employee employee) throws Exception
	{
		try
		{
			List<Employee> employeeList = employeeService.selectEmployeeList(employee);

			List<EmployeeExcel> list = new ArrayList<>();
			for (Employee emp:employeeList){
				EmployeeExcel employeeExcel = new EmployeeExcel();
				BeanUtils.copyProperties(emp,employeeExcel);
				employeeExcel.setStatusName(dictDataService.selectDictLabel("sys_emp_status",emp.getStatus()));
				employeeExcel.setOpenStatusName(dictDataService.selectDictLabel("sys_open_status",emp.getOpenStatus()));
				employeeExcel.setEmpSexName(dictDataService.selectDictLabel("sys_user_sex",emp.getEmpSex()));
				employeeExcel.setPostName(postService.selectPostById(emp.getPostId()).getPostName());
				employeeExcel.setDeptName(deptService.selectDeptById(emp.getDeptId()).getDeptName());
				employeeExcel.setEmpEducationName(dictDataService.selectDictLabel("sys_education_type",emp.getEmpEducation()));
				employeeExcel.setEmpNationalityName(dictDataService.selectDictLabel("sys_nationality_type",emp.getEmpNationality()));
				employeeExcel.setEmpNationName(dictDataService.selectDictLabel("sys_nation_type",emp.getEmpNation()));
				employeeExcel.setEmpMarriageName(dictDataService.selectDictLabel("sys_marriage_type",emp.getEmpMarriage()));
				employeeExcel.setEmpPoliticsName(dictDataService.selectDictLabel("sys_politics_type",emp.getEmpPolitics()));
				list.add(employeeExcel);
			}

			ExcelUtil<EmployeeExcel> util = new ExcelUtil<EmployeeExcel>(EmployeeExcel.class);
			return util.exportExcel(list, "员工管理");
		}
		catch (Exception e)
		{
			return error("导出Excel失败，请联系管理员！");
		}
	}
	
}
