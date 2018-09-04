package com.szl.oa.project.module.weeklyApprove.service;

import java.util.List;
import java.util.Objects;

import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.project.module.dailyApprove.domain.DailyApprove;
import com.szl.oa.project.module.weeklyReport.domain.WeeklyReport;
import com.szl.oa.project.module.weeklyReport.mapper.WeeklyReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.weeklyApprove.mapper.WeeklyApproveMapper;
import com.szl.oa.project.module.weeklyApprove.domain.WeeklyApprove;
import com.szl.oa.project.module.weeklyApprove.service.IWeeklyApproveService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 周报管理 服务层实现
 * 
 * @author songzl
 * @date 2018-08-18
 */
@Service
public class WeeklyApproveServiceImpl implements IWeeklyApproveService 
{
	@Resource
	private WeeklyApproveMapper weeklyApproveMapper;

	@Resource
	private WeeklyReportMapper weeklyReportMapper;

	/**
     * 查询周报管理信息
     * 
     * @param approveId 周报管理ID
     * @return 周报管理信息
     */
    @Override
	public WeeklyApprove selectWeeklyApproveById(Long approveId)
	{
	    return weeklyApproveMapper.selectWeeklyApproveById(approveId);
	}
	
	/**
     * 查询周报管理列表
     * 
     * @param weeklyApprove 周报管理信息
     * @return 周报管理集合
     */
	@Override
	public List<WeeklyApprove> selectWeeklyApproveList(WeeklyApprove weeklyApprove)
	{
        if(!ShiroUtils.getUser().isAdmin()){
            weeklyApprove.setCreateId(ShiroUtils.getUserId());
        }
	    return weeklyApproveMapper.selectWeeklyApproveList(weeklyApprove);
	}
	
    /**
     * 新增周报管理
     * 
     * @param weeklyApprove 周报管理信息
     * @return 结果
     */
	@Override
	public int insertWeeklyApprove(WeeklyApprove weeklyApprove)
	{
	    return weeklyApproveMapper.insertWeeklyApprove(weeklyApprove);
	}
	
	/**
     * 修改周报管理
     * 
     * @param weeklyApprove 周报管理信息
     * @return 结果
     */
	@Override
	public int updateWeeklyApprove(WeeklyApprove weeklyApprove)
	{
		WeeklyApprove wa = weeklyApproveMapper.selectWeeklyApproveById(weeklyApprove.getApproveId());
		if(Objects.nonNull(wa)){
			wa.getWeeklyReport().setStatus(weeklyApprove.getStatus());
			wa.getWeeklyReport().setOpinion(weeklyApprove.getOpinion());
			weeklyReportMapper.updateWeeklyReport(wa.getWeeklyReport());
		}
		return weeklyApproveMapper.updateWeeklyApprove(weeklyApprove);
	}

	/**
     * 删除周报管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWeeklyApproveByIds(String ids)
	{
		return weeklyApproveMapper.deleteWeeklyApproveByIds(Convert.toStrArray(ids));
	}
	
}
