package com.szl.oa.project.module.leaveApprove.mapper;

import com.szl.oa.project.module.leaveApprove.domain.LeaveApprove;
import java.util.List;	

/**
 * 请假管理 数据层
 * 
 * @author songzl
 * @date 2018-08-18
 */
public interface LeaveApproveMapper 
{
	/**
     * 查询请假管理信息
     * 
     * @param approveId 请假管理ID
     * @return 请假管理信息
     */
	public LeaveApprove selectLeaveApproveById(Long approveId);

	public LeaveApprove selectLeaveByLeaveId(Long leaveId);
	
	/**
     * 查询请假管理列表
     * 
     * @param leaveApprove 请假管理信息
     * @return 请假管理集合
     */
	public List<LeaveApprove> selectLeaveApproveList(LeaveApprove leaveApprove);
	
	/**
     * 新增请假管理
     * 
     * @param leaveApprove 请假管理信息
     * @return 结果
     */
	public int insertLeaveApprove(LeaveApprove leaveApprove);
	
	/**
     * 修改请假管理
     * 
     * @param leaveApprove 请假管理信息
     * @return 结果
     */
	public int updateLeaveApprove(LeaveApprove leaveApprove);
	
	/**
     * 删除请假管理
     * 
     * @param approveId 请假管理ID
     * @return 结果
     */
	public int deleteLeaveApproveById(Long approveId);
	
	/**
     * 批量删除请假管理
     * 
     * @param approveIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteLeaveApproveByIds(String[] approveIds);
	
}