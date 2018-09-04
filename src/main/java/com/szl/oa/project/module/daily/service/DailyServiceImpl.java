package com.szl.oa.project.module.daily.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.project.module.daily.domain.DailyStatus;
import com.szl.oa.project.module.dailyApprove.domain.DailyApprove;
import com.szl.oa.project.module.dailyApprove.mapper.DailyApproveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.daily.mapper.DailyMapper;
import com.szl.oa.project.module.daily.domain.Daily;
import com.szl.oa.project.module.daily.service.IDailyService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 日报管理 服务层实现
 * 
 * @author songzl
 * @date 2018-08-09
 */
@Service
public class DailyServiceImpl implements IDailyService 
{
	@Resource
	private DailyMapper dailyMapper;

	@Resource
	private DailyApproveMapper dailyApproveMapper;

	/**
     * 查询日报管理信息
     * 
     * @param dailyId 日报管理ID
     * @return 日报管理信息
     */
    @Override
	public Daily selectDailyById(Long dailyId)
	{
	    return dailyMapper.selectDailyById(dailyId);
	}
	
	/**
     * 查询日报管理列表
     * 
     * @param daily 日报管理信息
     * @return 日报管理集合
     */
	@Override
	public List<Daily> selectDailyList(Daily daily)
	{
		if(!ShiroUtils.getUser().isAdmin()){
			daily.setCreateId(ShiroUtils.getUserId());
		}
	    return dailyMapper.selectDailyList(daily);
	}
	
    /**
     * 新增日报管理
     * 
     * @param daily 日报管理信息
     * @return 结果
     */
	@Override
	public int insertDaily(Daily daily)
	{
		daily.setCreateBy(ShiroUtils.getLoginName());
		daily.setCreateId(ShiroUtils.getUserId());
		dailyMapper.insertDaily(daily);
		Long dailyId = daily.getDailyId();
		DailyApprove dailyApprove = new DailyApprove();
		dailyApprove.setDailyId(dailyId);
		dailyApprove.setCreateId(daily.getUserId());
		dailyApprove.setCreateTime(daily.getCreateTime());
	    return dailyApproveMapper.insertDailyApprove(dailyApprove);
	}

	/**
     * 修改日报管理
     * 
     * @param daily 日报管理信息
     * @return 结果
     */
	@Override
	public int updateDaily(Daily daily)
	{
		daily.setUpdateBy(ShiroUtils.getLoginName());
		daily.setStatus(DailyStatus.APPROVEING.getCode());
		daily.setUserId(daily.getUserId());
		dailyMapper.updateDaily(daily);
		Long dailyId = daily.getDailyId();

		DailyApprove da= dailyApproveMapper.selectDailyByDailyId(dailyId);
		if(Objects.isNull(da)){
			DailyApprove dailyApprove = new DailyApprove();
			dailyApprove.setCreateId(daily.getUserId());
			dailyApprove.setDailyId(dailyId);
			dailyApprove.setCreateId(daily.getUserId());
			dailyApprove.setCreateTime(daily.getCreateTime());
			return dailyApproveMapper.insertDailyApprove(dailyApprove);
		}else{
			da.setUpdateTime(daily.getUpdateTime());
			da.setCreateId(daily.getUserId());
			return dailyApproveMapper.updateDailyApprove(da);
		}

	}

	/**
     * 删除日报管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDailyByIds(String ids)
	{
		String approveId="";
		String id []= Convert.toStrArray(ids);
		for (int i =0;i<id.length;i++){
			DailyApprove da = dailyApproveMapper.selectDailyByDailyId(Long.valueOf(id[i]));
			if(Objects.nonNull(da)) {
				approveId += da.getApproveId() + ",";
			}
		}
		if(approveId.length()> 0){
			dailyApproveMapper.deleteDailyApproveByIds(Convert.toStrArray(approveId));
		}

		return dailyMapper.deleteDailyByIds(Convert.toStrArray(ids));
	}
	
}
