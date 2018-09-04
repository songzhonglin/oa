package com.szl.oa.project.module.dailyApprove.mapper;

import com.szl.oa.project.module.dailyApprove.domain.DailyApprove;
import java.util.List;	

/**
 * 日报管理 数据层
 * 
 * @author songzl
 * @date 2018-08-17
 */
public interface DailyApproveMapper 
{
	/**
     * 查询日报管理信息
     * 
     * @param approveId 日报管理ID
     * @return 日报管理信息
     */
	public DailyApprove selectDailyApproveById(Long approveId);

	public DailyApprove selectDailyByDailyId(Long dailyId);
	
	/**
     * 查询日报管理列表
     * 
     * @param dailyApprove 日报管理信息
     * @return 日报管理集合
     */
	public List<DailyApprove> selectDailyApproveList(DailyApprove dailyApprove);
	
	/**
     * 新增日报管理
     * 
     * @param dailyApprove 日报管理信息
     * @return 结果
     */
	public int insertDailyApprove(DailyApprove dailyApprove);
	
	/**
     * 修改日报管理
     * 
     * @param dailyApprove 日报管理信息
     * @return 结果
     */
	public int updateDailyApprove(DailyApprove dailyApprove);
	
	/**
     * 删除日报管理
     * 
     * @param approveId 日报管理ID
     * @return 结果
     */
	public int deleteDailyApproveById(Long approveId);
	
	/**
     * 批量删除日报管理
     * 
     * @param approveIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDailyApproveByIds(String[] approveIds);
	
}