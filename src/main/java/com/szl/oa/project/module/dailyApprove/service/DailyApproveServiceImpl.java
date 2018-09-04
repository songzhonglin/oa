package com.szl.oa.project.module.dailyApprove.service;

import java.util.List;
import java.util.Objects;

import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.project.module.daily.domain.Daily;
import com.szl.oa.project.module.daily.mapper.DailyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.dailyApprove.mapper.DailyApproveMapper;
import com.szl.oa.project.module.dailyApprove.domain.DailyApprove;
import com.szl.oa.project.module.dailyApprove.service.IDailyApproveService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 日报管理 服务层实现
 * 
 * @author songzl
 * @date 2018-08-17
 */
@Service
public class DailyApproveServiceImpl implements IDailyApproveService 
{
	@Resource
	private DailyApproveMapper dailyApproveMapper;

	@Resource
	private DailyMapper dailyMapper;

	/**
     * 查询日报管理信息
     * 
     * @param approveId 日报管理ID
     * @return 日报管理信息
     */
    @Override
	public DailyApprove selectDailyApproveById(Long approveId)
	{
	    return dailyApproveMapper.selectDailyApproveById(approveId);
	}
	
	/**
     * 查询日报管理列表
     * 
     * @param dailyApprove 日报管理信息
     * @return 日报管理集合
     */
	@Override
	public List<DailyApprove> selectDailyApproveList(DailyApprove dailyApprove)
	{
        if(!ShiroUtils.getUser().isAdmin()){
            dailyApprove.setCreateId(ShiroUtils.getUserId());
        }
	    return dailyApproveMapper.selectDailyApproveList(dailyApprove);
	}
	
    /**
     * 新增日报管理
     * 
     * @param dailyApprove 日报管理信息
     * @return 结果
     */
	@Override
	public int insertDailyApprove(DailyApprove dailyApprove)
	{
	    return dailyApproveMapper.insertDailyApprove(dailyApprove);
	}
	
	/**
     * 修改日报管理
     * 
     * @param dailyApprove 日报管理信息
     * @return 结果
     */
	@Override
	public int updateDailyApprove(DailyApprove dailyApprove)
	{
		DailyApprove da = dailyApproveMapper.selectDailyApproveById(dailyApprove.getApproveId());
		if(Objects.nonNull(da)){
			da.getDaily().setStatus(dailyApprove.getStatus());
			da.getDaily().setOpinion(dailyApprove.getOpinion());
			dailyMapper.updateDaily(da.getDaily());
		}
	    return dailyApproveMapper.updateDailyApprove(dailyApprove);
	}

	/**
     * 删除日报管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDailyApproveByIds(String ids)
	{
		return dailyApproveMapper.deleteDailyApproveByIds(Convert.toStrArray(ids));
	}
	
}
