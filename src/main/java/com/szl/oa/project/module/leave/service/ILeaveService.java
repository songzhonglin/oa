package com.szl.oa.project.module.leave.service;

import com.szl.oa.project.module.leave.domain.Leave;
import java.util.List;

/**
 * 请假管理 服务层
 * 
 * @author songzl
 * @date 2018-08-11
 */
public interface ILeaveService 
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
	 *  审核请假管理
	 * @param leave 请假管理信息
	 * @return
	 */
	public int checkLeave(Leave leave);
		
	/**
     * 删除请假管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLeaveByIds(String ids);
	
}
