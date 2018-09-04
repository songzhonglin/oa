package com.szl.oa.project.module.attendence.mapper;

import com.szl.oa.project.module.attendence.domain.Attendence;
import java.util.List;	

/**
 * 考勤管理 数据层
 * 
 * @author songzl
 * @date 2018-08-31
 */
public interface AttendenceMapper 
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
     * 删除考勤管理
     * 
     * @param attendId 考勤管理ID
     * @return 结果
     */
	public int deleteAttendenceById(Long attendId);
	
	/**
     * 批量删除考勤管理
     * 
     * @param attendIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteAttendenceByIds(String[] attendIds);

	/**
	 * 找到员工本次打卡对应的出勤记录
	 * @param attendence
	 * @return
	 */
    Attendence selectAttendenceByDutyDay(Attendence attendence);

    int updateAttend(Attendence attend);

	int insertAttend(Attendence attendence);
}