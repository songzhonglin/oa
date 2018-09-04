package com.szl.oa.project.module.employee.service;

import java.util.List;
import java.util.Objects;

import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.framework.shiro.service.PasswordService;
import com.szl.oa.project.system.user.domain.User;
import com.szl.oa.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.employee.mapper.EmployeeMapper;
import com.szl.oa.project.module.employee.domain.Employee;
import com.szl.oa.project.module.employee.service.IEmployeeService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 员工管理 服务层实现
 * 
 * @author songzl
 * @date 2018-08-19
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService 
{
	@Resource
	private EmployeeMapper employeeMapper;

	@Resource
	private UserMapper userMapper;

	@Resource
	private PasswordService passwordService;

	/**
     * 查询员工管理信息
     * 
     * @param empId 员工管理ID
     * @return 员工管理信息
     */
    @Override
	public Employee selectEmployeeById(Long empId)
	{
	    return employeeMapper.selectEmployeeById(empId);
	}
	
	/**
     * 查询员工管理列表
     * 
     * @param employee 员工管理信息
     * @return 员工管理集合
     */
	@Override
	public List<Employee> selectEmployeeList(Employee employee)
	{
        if(!ShiroUtils.getUser().isAdmin()){
            employee.setCreateId(ShiroUtils.getUserId());
        }
	    return employeeMapper.selectEmployeeList(employee);
	}
	
    /**
     * 新增员工管理
     * 
     * @param employee 员工管理信息
     * @return 结果
     */
	@Override
	public int insertEmployee(Employee employee)
	{
        employee.setCreateBy(ShiroUtils.getLoginName());
        employee.setCreateId(ShiroUtils.getUserId());
		int empId = employeeMapper.insertEmployee(employee);
		User u = userMapper.selectUserByLoginName(employee.getEmpAccount());
		insertUser(employee, u);
		return empId;
	}
	
	/**
     * 修改员工管理
     * 
     * @param employee 员工管理信息
     * @return 结果
     */
	@Override
	public int updateEmployee(Employee employee)
	{
        employee.setUpdateBy(ShiroUtils.getLoginName());
		int empId = employeeMapper.updateEmployee(employee);
		User u = userMapper.selectUserByLoginName(employee.getEmpAccount());
		insertUser(employee, u);
		return empId;

	}

	private void insertUser(Employee employee, User u) {
		if(employee.getOpenStatus().equals("1")){
			if(Objects.nonNull(u)){
				u.setEmpId(employee.getEmpId());
				u.setStatus("0");
				userMapper.updateUser(u);
			}else{
				User user = new User();
				user.randomSalt();
				user.setLoginName(employee.getEmpAccount());
				user.setDeptId(employee.getDeptId());
				user.setUserName(employee.getEmpName());
				user.setUserType("2");
				user.setPassword(passwordService.encryptPassword(employee.getEmpAccount(), "123456", user.getSalt()));
				user.setBirthday(employee.getEmpBirth());
				user.setEmail(employee.getEmpEmail());
				user.setPhoneNumber(employee.getEmpMobilephone());
				user.setSex(employee.getEmpSex());
				user.setEmpId(employee.getEmpId());
				user.setCreateBy(ShiroUtils.getLoginName());
				userMapper.insertUser(user);
			}
		}else{
			if(Objects.nonNull(u)){
				u.setEmpId(employee.getEmpId());
				u.setStatus("1");
				userMapper.updateUser(u);
			}
		}
	}

	/**
     * 删除员工管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEmployeeByIds(String ids)
	{
		return employeeMapper.deleteEmployeeByIds(Convert.toLongArray(ids));
	}
	
}
