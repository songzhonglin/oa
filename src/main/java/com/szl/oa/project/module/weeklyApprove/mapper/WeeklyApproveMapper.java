package com.szl.oa.project.module.weeklyApprove.mapper;

import com.szl.oa.project.module.weeklyApprove.domain.WeeklyApprove;
import java.util.List;	

/**
 * 周报管理 数据层
 * 
 * @author songzl
 * @date 2018-08-18
 */
public interface WeeklyApproveMapper 
{
	/**
     * 查询周报管理信息
     * 
     * @param approveId 周报管理ID
     * @return 周报管理信息
     */
	public WeeklyApprove selectWeeklyApproveById(Long approveId);
	
	/**
     * 查询周报管理列表
     * 
     * @param weeklyApprove 周报管理信息
     * @return 周报管理集合
     */
	public List<WeeklyApprove> selectWeeklyApproveList(WeeklyApprove weeklyApprove);
	
	/**
     * 新增周报管理
     * 
     * @param weeklyApprove 周报管理信息
     * @return 结果
     */
	public int insertWeeklyApprove(WeeklyApprove weeklyApprove);
	
	/**
     * 修改周报管理
     * 
     * @param weeklyApprove 周报管理信息
     * @return 结果
     */
	public int updateWeeklyApprove(WeeklyApprove weeklyApprove);
	
	/**
     * 删除周报管理
     * 
     * @param approveId 周报管理ID
     * @return 结果
     */
	public int deleteWeeklyApproveById(Long approveId);
	
	/**
     * 批量删除周报管理
     * 
     * @param approveIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteWeeklyApproveByIds(String[] approveIds);

    WeeklyApprove selectWeeklyByWeekId(Long weekId);
}