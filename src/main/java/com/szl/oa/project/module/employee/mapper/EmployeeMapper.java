package com.szl.oa.project.module.employee.mapper;

import com.szl.oa.project.module.employee.domain.Employee;
import java.util.List;	

/**
 * 员工管理 数据层
 * 
 * @author songzl
 * @date 2018-08-19
 */
public interface EmployeeMapper 
{
	/**
     * 查询员工管理信息
     * 
     * @param deptId 员工管理ID
     * @return 员工管理信息
     */
	public Employee selectEmployeeById(Long deptId);
	
	/**
     * 查询员工管理列表
     * 
     * @param employee 员工管理信息
     * @return 员工管理集合
     */
	public List<Employee> selectEmployeeList(Employee employee);
	
	/**
     * 新增员工管理
     * 
     * @param employee 员工管理信息
     * @return 结果
     */
	public int insertEmployee(Employee employee);
	
	/**
     * 修改员工管理
     * 
     * @param employee 员工管理信息
     * @return 结果
     */
	public int updateEmployee(Employee employee);
	
	/**
     * 删除员工管理
     * 
     * @param deptId 员工管理ID
     * @return 结果
     */
	public int deleteEmployeeById(Long deptId);
	
	/**
     * 批量删除员工管理
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteEmployeeByIds(Long[] deptIds);
	
}