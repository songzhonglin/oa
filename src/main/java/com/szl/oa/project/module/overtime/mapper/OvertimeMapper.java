package com.szl.oa.project.module.overtime.mapper;

import com.szl.oa.project.module.overtime.domain.Overtime;
import java.util.List;	

/**
 * 我的加班 数据层
 * 
 * @author songzl
 * @date 2018-08-30
 */
public interface OvertimeMapper 
{
	/**
     * 查询我的加班信息
     * 
     * @param overtimeId 我的加班ID
     * @return 我的加班信息
     */
	public Overtime selectOvertimeById(Long overtimeId);
	
	/**
     * 查询我的加班列表
     * 
     * @param overtime 我的加班信息
     * @return 我的加班集合
     */
	public List<Overtime> selectOvertimeList(Overtime overtime);
	
	/**
     * 新增我的加班
     * 
     * @param overtime 我的加班信息
     * @return 结果
     */
	public int insertOvertime(Overtime overtime);
	
	/**
     * 修改我的加班
     * 
     * @param overtime 我的加班信息
     * @return 结果
     */
	public int updateOvertime(Overtime overtime);
	
	/**
     * 删除我的加班
     * 
     * @param overtimeId 我的加班ID
     * @return 结果
     */
	public int deleteOvertimeById(Long overtimeId);
	
	/**
     * 批量删除我的加班
     * 
     * @param overtimeIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteOvertimeByIds(String[] overtimeIds);
	
}