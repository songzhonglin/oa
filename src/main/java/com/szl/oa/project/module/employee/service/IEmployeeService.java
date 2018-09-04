package com.szl.oa.project.module.employee.service;

import com.szl.oa.project.module.employee.domain.Employee;
import java.util.List;

/**
 * 员工管理 服务层
 * 
 * @author songzl
 * @date 2018-08-19
 */
public interface IEmployeeService 
{
	/**
     * 查询员工管理信息
     * 
     * @param empId 员工管理ID
     * @return 员工管理信息
     */
	public Employee selectEmployeeById(Long empId);
	
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
     * 删除员工管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEmployeeByIds(String ids);
	
}
