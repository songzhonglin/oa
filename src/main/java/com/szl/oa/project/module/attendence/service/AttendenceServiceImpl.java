package com.szl.oa.project.module.attendence.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.project.module.attendence.domain.AttendenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.attendence.mapper.AttendenceMapper;
import com.szl.oa.project.module.attendence.domain.Attendence;
import com.szl.oa.project.module.attendence.service.IAttendenceService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 考勤管理 服务层实现
 * 
 * @author songzl
 * @date 2018-08-31
 */
@Service
public class AttendenceServiceImpl implements IAttendenceService 
{
	@Resource
	private AttendenceMapper attendenceMapper;

	/**
     * 查询考勤管理信息
     * 
     * @param attendId 考勤管理ID
     * @return 考勤管理信息
     */
    @Override
	public Attendence selectAttendenceById(Long attendId)
	{
	    return attendenceMapper.selectAttendenceById(attendId);
	}
	
	/**
     * 查询考勤管理列表
     * 
     * @param attendence 考勤管理信息
     * @return 考勤管理集合
     */
	@Override
	public List<Attendence> selectAttendenceList(Attendence attendence)
	{
        if(!ShiroUtils.getUser().isAdmin()){
            attendence.setCreateId(ShiroUtils.getUserId());
        }
	    return attendenceMapper.selectAttendenceList(attendence);
	}
	
    /**
     * 新增考勤管理
     * 
     * @param attendence 考勤管理信息
     * @return 结果
     */
	@Override
	public int insertAttendence(Attendence attendence)
	{
        attendence.setCreateBy(ShiroUtils.getLoginName());
        attendence.setCreateId(ShiroUtils.getUserId());
		String dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
		attendence.setDutyDay(dutyDay);
        //找到员工本次打卡对应的出勤记录
		Attendence attend= attendenceMapper.selectAttendenceByDutyDay(attendence);

		if(Objects.isNull(attend)){
			onTime(attendence);
			return attendenceMapper.insertAttendence(attendence);
		}else {
			// 如果已经打卡
			if(attend.getCreateTime() !=null){
				return 0;
			}else{
				onTime(attend);
				return attendenceMapper.updateAttend(attend);
			}
		}

	}

	private void onTime(Attendence attendence) {
		int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//9点之前算正常
		if(punchHour < AttendenceType.COME_LIMIT) {
			//1表示正常
			attendence.setOnStatus(AttendenceType.ZERO);
		} else if (punchHour <AttendenceType.LATE_LIMIT) {
			//9点到11点之间算迟到
			attendence.setOnStatus(AttendenceType.ONE);
		}else {
			//11点之后算旷工，不用管，本来初始就是旷工
			attendence.setOnStatus(AttendenceType.THREE);
		}
	}


	private void offTime(Attendence attendence) {
		int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//下班打卡
		//17点之后算正常
		if(punchHour >= AttendenceType.LEAVE_LIMIT) {
			attendence.setOffStatus(AttendenceType.ZERO);
		} else {
			//16到17点算早退
			attendence.setOffStatus(AttendenceType.TWO);
		}
	}

	/**
     * 修改考勤管理
     * 
     * @param attendence 考勤管理信息
     * @return 结果
     */
	@Override
	public int updateAttendence(Attendence attendence)
	{
        attendence.setUpdateBy(ShiroUtils.getLoginName());
        attendence.setCreateId(ShiroUtils.getUserId());
		String dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
		attendence.setDutyDay(dutyDay);
		Attendence attend= attendenceMapper.selectAttendenceByDutyDay(attendence);
		if(Objects.nonNull(attend)){
			if(attend.getUpdateTime() !=null){
				return 0;
			}
			offTime(attend);
			return attendenceMapper.updateAttendence(attend);
		}else{
			offTime(attendence);
			return attendenceMapper.insertAttend(attendence);
		}


	}

	/**
     * 删除考勤管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAttendenceByIds(String ids)
	{
		return attendenceMapper.deleteAttendenceByIds(Convert.toStrArray(ids));
	}
	
}
