package com.szl.oa.project.module.leave.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.szl.oa.common.utils.DateUtils;
import com.szl.oa.common.utils.StringUtils;
import com.szl.oa.common.utils.calculateDay;
import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.project.module.daily.domain.DailyStatus;
import com.szl.oa.project.module.dailyApprove.domain.DailyApprove;
import com.szl.oa.project.module.leave.domain.LeaveStatus;
import com.szl.oa.project.module.leaveApprove.domain.LeaveApprove;
import com.szl.oa.project.module.leaveApprove.mapper.LeaveApproveMapper;
import com.szl.oa.project.system.dept.domain.Dept;
import com.szl.oa.project.system.dept.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.leave.mapper.LeaveMapper;
import com.szl.oa.project.module.leave.domain.Leave;
import com.szl.oa.project.module.leave.service.ILeaveService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 请假管理 服务层实现
 * 
 * @author songzl
 * @date 2018-08-11
 */
@Service
public class LeaveServiceImpl implements ILeaveService 
{
	@Resource
	private LeaveMapper leaveMapper;

	@Resource
	private LeaveApproveMapper leaveApproveMapper;

	/**
     * 查询请假管理信息
     * 
     * @param leaveId 请假管理ID
     * @return 请假管理信息
     */
    @Override
	public Leave selectLeaveById(String leaveId)
	{
	    return leaveMapper.selectLeaveById(leaveId);
	}
	
	/**
     * 查询请假管理列表
     * 
     * @param leave 请假管理信息
     * @return 请假管理集合
     */
	@Override
	public List<Leave> selectLeaveList(Leave leave)
	{
        if(!ShiroUtils.getUser().isAdmin()){
            leave.setCreateId(ShiroUtils.getUserId());
        }
	    return leaveMapper.selectLeaveList(leave);
	}

	@Override
	public List<Leave> queryLeaveList(Leave leave) {
		if(!ShiroUtils.getUser().isAdmin()){
			leave.setCreateId(ShiroUtils.getUserId());
		}
		return leaveMapper.queryLeaveList(leave);
	}

	/**
     * 新增请假管理
     * 
     * @param leave 请假管理信息
     * @return 结果
     */
	@Override
	public int insertLeave(Leave leave)
	{

		// 请假天数
		if(StringUtils.isNotEmpty(leave.getBeginDate())&& StringUtils.isNotEmpty(leave.getEndDate())){
			leave.setDayNum(calculateDay.getDays(leave.getBeginDate(),leave.getEndDate()));
		}
		leave.setCreateBy(ShiroUtils.getLoginName());
        leave.setCreateId(ShiroUtils.getUserId());
		leaveMapper.insertLeave(leave);

		Long leaveId = leave.getLeaveId();
		LeaveApprove leaveApprove = new LeaveApprove();
		leaveApprove.setLeaveId(leaveId);
		leaveApprove.setCreateId(leave.getUserId());
		leaveApprove.setCreateTime(leave.getCreateTime());
	    return leaveApproveMapper.insertLeaveApprove(leaveApprove);
	}
	
	/**
     * 修改请假管理
     * 
     * @param leave 请假管理信息
     * @return 结果
     */
	@Override
	public int updateLeave(Leave leave)
	{
		// 请假天数
		if(StringUtils.isNotEmpty(leave.getBeginDate())&& StringUtils.isNotEmpty(leave.getEndDate())){
			leave.setDayNum(calculateDay.getDays(leave.getBeginDate(),leave.getEndDate()));
		}
		leave.setLeaveStatus(LeaveStatus.APPROVEING.getCode());
        leave.setUpdateBy(ShiroUtils.getLoginName());
        leave.setUserId(leave.getUserId());
		leaveMapper.updateLeave(leave);

		Long leaveId = leave.getLeaveId();
		LeaveApprove la= leaveApproveMapper.selectLeaveByLeaveId(leaveId);
		if(Objects.isNull(la)){
			LeaveApprove leaveApprove = new LeaveApprove();
			leaveApprove.setLeaveId(leaveId);
			leaveApprove.setCreateId(leave.getUserId());
			leaveApprove.setCreateTime(leave.getCreateTime());
			return leaveApproveMapper.insertLeaveApprove(leaveApprove);
		}else{
			la.setCreateId(leave.getUserId());
			la.setUpdateTime(leave.getUpdateTime());
			return leaveApproveMapper.updateLeaveApprove(la);
		}
	}

	@Override
	public int checkLeave(Leave leave) {
		return leaveMapper.updateLeave(leave);
	}

	/**
     * 删除请假管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLeaveByIds(String ids)
	{
		String approveId="";
		String id []= Convert.toStrArray(ids);
		for (int i =0;i<id.length;i++){
			LeaveApprove da = leaveApproveMapper.selectLeaveByLeaveId(Long.valueOf(id[i]));
			if(Objects.nonNull(da)) {
				approveId += da.getApproveId() + ",";
			}
		}
		if(approveId.length()> 0){
			leaveApproveMapper.deleteLeaveApproveByIds(Convert.toStrArray(approveId));
		}

		return leaveMapper.deleteLeaveByIds(Convert.toStrArray(ids));
	}
	
}
