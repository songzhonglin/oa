package com.szl.oa.project.module.leaveApprove.service;

import java.util.List;
import java.util.Objects;

import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.project.module.leave.mapper.LeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.leaveApprove.mapper.LeaveApproveMapper;
import com.szl.oa.project.module.leaveApprove.domain.LeaveApprove;
import com.szl.oa.project.module.leaveApprove.service.ILeaveApproveService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 请假管理 服务层实现
 * 
 * @author songzl
 * @date 2018-08-18
 */
@Service
public class LeaveApproveServiceImpl implements ILeaveApproveService 
{
	@Resource
	private LeaveApproveMapper leaveApproveMapper;

	@Resource
	private LeaveMapper leaveMapper;

	/**
     * 查询请假管理信息
     * 
     * @param approveId 请假管理ID
     * @return 请假管理信息
     */
    @Override
	public LeaveApprove selectLeaveApproveById(Long approveId)
	{
	    return leaveApproveMapper.selectLeaveApproveById(approveId);
	}
	
	/**
     * 查询请假管理列表
     * 
     * @param leaveApprove 请假管理信息
     * @return 请假管理集合
     */
	@Override
	public List<LeaveApprove> selectLeaveApproveList(LeaveApprove leaveApprove)
	{
        if(!ShiroUtils.getUser().isAdmin()){
            leaveApprove.setCreateId(ShiroUtils.getUserId());
        }
	    return leaveApproveMapper.selectLeaveApproveList(leaveApprove);
	}
	
    /**
     * 新增请假管理
     * 
     * @param leaveApprove 请假管理信息
     * @return 结果
     */
	@Override
	public int insertLeaveApprove(LeaveApprove leaveApprove)
	{
	    return leaveApproveMapper.insertLeaveApprove(leaveApprove);
	}
	
	/**
     * 修改请假管理
     * 
     * @param leaveApprove 请假管理信息
     * @return 结果
     */
	@Override
	public int updateLeaveApprove(LeaveApprove leaveApprove)
	{

		LeaveApprove la = leaveApproveMapper.selectLeaveApproveById(leaveApprove.getApproveId());
		if(Objects.nonNull(la)){
			la.getLeave().setLeaveStatus(leaveApprove.getLeaveStatus());
			la.getLeave().setOpinion(leaveApprove.getOpinion());
			leaveMapper.updateLeave(la.getLeave());
		}
	    return leaveApproveMapper.updateLeaveApprove(leaveApprove);
	}

	/**
     * 删除请假管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLeaveApproveByIds(String ids)
	{
		return leaveApproveMapper.deleteLeaveApproveByIds(Convert.toStrArray(ids));
	}
	
}
