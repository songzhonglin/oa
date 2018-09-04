package com.szl.oa.project.module.weeklyReport.service;

import java.util.List;
import java.util.Objects;

import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.project.module.dailyApprove.domain.DailyApprove;
import com.szl.oa.project.module.weeklyApprove.domain.WeeklyApprove;
import com.szl.oa.project.module.weeklyApprove.mapper.WeeklyApproveMapper;
import com.szl.oa.project.module.weeklyReport.domain.WeeklyReportStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.weeklyReport.mapper.WeeklyReportMapper;
import com.szl.oa.project.module.weeklyReport.domain.WeeklyReport;
import com.szl.oa.project.module.weeklyReport.service.IWeeklyReportService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 周报管理 服务层实现
 * 
 * @author songzl
 * @date 2018-08-11
 */
@Service
public class WeeklyReportServiceImpl implements IWeeklyReportService 
{
	@Resource
	private WeeklyReportMapper weeklyReportMapper;

	@Resource
	private WeeklyApproveMapper weeklyApproveMapper;

	/**
     * 查询周报管理信息
     * 
     * @param weekId 周报管理ID
     * @return 周报管理信息
     */
    @Override
	public WeeklyReport selectWeeklyReportById(Long weekId)
	{
	    return weeklyReportMapper.selectWeeklyReportById(weekId);
	}
	
	/**
     * 查询周报管理列表
     * 
     * @param weeklyReport 周报管理信息
     * @return 周报管理集合
     */
	@Override
	public List<WeeklyReport> selectWeeklyReportList(WeeklyReport weeklyReport)
	{
		if(!ShiroUtils.getUser().isAdmin()){
			weeklyReport.setCreateId(ShiroUtils.getUserId());
		}
	    return weeklyReportMapper.selectWeeklyReportList(weeklyReport);
	}
	
    /**
     * 新增周报管理
     * 
     * @param weeklyReport 周报管理信息
     * @return 结果
     */
	@Override
	public int insertWeeklyReport(WeeklyReport weeklyReport)
	{
		weeklyReport.setCreateBy(ShiroUtils.getLoginName());
		weeklyReport.setCreateId(ShiroUtils.getUserId());
		weeklyReportMapper.insertWeeklyReport(weeklyReport);
		Long weekId = weeklyReport.getWeekId();
		WeeklyApprove weeklyApprove = new WeeklyApprove();
		weeklyApprove.setWeekId(weekId);
		weeklyApprove.setCreateId(weeklyReport.getUserId());
		weeklyApprove.setCreateTime(weeklyReport.getCreateTime());
	    return weeklyApproveMapper.insertWeeklyApprove(weeklyApprove);
	}
	
	/**
     * 修改周报管理
     * 
     * @param weeklyReport 周报管理信息
     * @return 结果
     */
	@Override
	public int updateWeeklyReport(WeeklyReport weeklyReport)
	{
		weeklyReport.setUpdateBy(ShiroUtils.getLoginName());
		weeklyReport.setStatus(WeeklyReportStatus.APPROVEING.getCode());
		weeklyReport.setUserId(weeklyReport.getUserId());
	    weeklyReportMapper.updateWeeklyReport(weeklyReport);
		Long weekId = weeklyReport.getWeekId();

		WeeklyApprove wa = weeklyApproveMapper.selectWeeklyByWeekId(weekId);
		if(Objects.isNull(wa)){
			WeeklyApprove weeklyApprove = new WeeklyApprove();
			weeklyApprove.setCreateId(weeklyReport.getUserId());
			weeklyApprove.setCreateTime(weeklyReport.getCreateTime());
			weeklyApprove.setWeekId(weekId);
			return weeklyApproveMapper.insertWeeklyApprove(weeklyApprove);
		}else{
			wa.setCreateId(weeklyReport.getUserId());
			wa.setUpdateTime(weeklyReport.getUpdateTime());
			return weeklyApproveMapper.updateWeeklyApprove(wa);
		}
	}

	/**
     * 删除周报管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWeeklyReportByIds(String ids)
	{
		String approveId="";
		String id []= Convert.toStrArray(ids);
		for (int i =0;i<id.length;i++){
			WeeklyApprove da = weeklyApproveMapper.selectWeeklyByWeekId(Long.valueOf(id[i]));
			if(Objects.nonNull(da)){
				approveId +=da.getApproveId()+",";
			}
		}
		if(approveId.length() > 0){
			weeklyApproveMapper.deleteWeeklyApproveByIds(Convert.toStrArray(approveId));
		}
		return weeklyReportMapper.deleteWeeklyReportByIds(Convert.toStrArray(ids));
	}
	
}
