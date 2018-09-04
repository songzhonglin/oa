package com.szl.oa.project.module.weeklyReport.mapper;

import com.szl.oa.project.module.weeklyReport.domain.WeeklyReport;
import java.util.List;	

/**
 * 周报管理 数据层
 * 
 * @author songzl
 * @date 2018-08-11
 */
public interface WeeklyReportMapper 
{
	/**
     * 查询周报管理信息
     * 
     * @param weekId 周报管理ID
     * @return 周报管理信息
     */
	public WeeklyReport selectWeeklyReportById(Long weekId);
	
	/**
     * 查询周报管理列表
     * 
     * @param weeklyReport 周报管理信息
     * @return 周报管理集合
     */
	public List<WeeklyReport> selectWeeklyReportList(WeeklyReport weeklyReport);
	
	/**
     * 新增周报管理
     * 
     * @param weeklyReport 周报管理信息
     * @return 结果
     */
	public int insertWeeklyReport(WeeklyReport weeklyReport);
	
	/**
     * 修改周报管理
     * 
     * @param weeklyReport 周报管理信息
     * @return 结果
     */
	public int updateWeeklyReport(WeeklyReport weeklyReport);
	
	/**
     * 删除周报管理
     * 
     * @param weekId 周报管理ID
     * @return 结果
     */
	public int deleteWeeklyReportById(Long weekId);
	
	/**
     * 批量删除周报管理
     * 
     * @param weekIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteWeeklyReportByIds(String[] weekIds);
	
}