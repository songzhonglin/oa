package com.szl.oa.project.module.attendence.service;

import com.szl.oa.project.module.attendence.domain.Attendence;
import java.util.List;

/**
 * 考勤管理 服务层
 * 
 * @author songzl
 * @date 2018-08-31
 */
public interface IAttendenceService 
{
	/**
     * 查询考勤管理信息
     * 
     * @param attendId 考勤管理ID
     * @return 考勤管理信息
     */
	public Attendence selectAttendenceById(Long attendId);
	
	/**
     * 查询考勤管理列表
     * 
     * @param attendence 考勤管理信息
     * @return 考勤管理集合
     */
	public List<Attendence> selectAttendenceList(Attendence attendence);
	
	/**
     * 新增考勤管理
     * 
     * @param attendence 考勤管理信息
     * @return 结果
     */
	public int insertAttendence(Attendence attendence);
	
	/**
     * 修改考勤管理
     * 
     * @param attendence 考勤管理信息
     * @return 结果
     */
	public int updateAttendence(Attendence attendence);
		
	/**
     * 删除考勤管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAttendenceByIds(String ids);
	
}
