package com.szl.oa.project.module.leave.mapper;

import com.szl.oa.project.module.leave.domain.Leave;
import java.util.List;	

/**
 * 请假管理 数据层
 * 
 * @author songzl
 * @date 2018-08-11
 */
public interface LeaveMapper 
{
	/**
     * 查询请假管理信息
     * 
     * @param leaveId 请假管理ID
     * @return 请假管理信息
     */
	public Leave selectLeaveById(String leaveId);
	
	/**
     * 查询我的请假管理列表
     * 
     * @param leave 请假管理信息
     * @return 请假管理集合
     */
	public List<Leave> selectLeaveList(Leave leave);

	/**
	 * 查询请假管理列表
	 *
	 * @param leave 请假管理信息
	 * @return 请假管理集合
	 */
	public List<Leave> queryLeaveList(Leave leave);
	
	/**
     * 新增请假管理
     * 
     * @param leave 请假管理信息
     * @return 结果
     */
	public int insertLeave(Leave leave);
	
	/**
     * 修改请假管理
     * 
     * @param leave 请假管理信息
     * @return 结果
     */
	public int updateLeave(Leave leave);
	
	/**
     * 删除请假管理
     * 
     * @param leaveId 请假管理ID
     * @return 结果
     */
	public int deleteLeaveById(String leaveId);
	
	/**
     * 批量删除请假管理
     * 
     * @param leaveIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteLeaveByIds(String[] leaveIds);
	
}