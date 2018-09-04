package com.szl.oa.project.module.overtime.service;

import java.util.List;
import com.szl.oa.common.utils.security.ShiroUtils;
import com.szl.oa.project.module.daily.domain.DailyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szl.oa.project.module.overtime.mapper.OvertimeMapper;
import com.szl.oa.project.module.overtime.domain.Overtime;
import com.szl.oa.project.module.overtime.service.IOvertimeService;
import com.szl.oa.common.support.Convert;

import javax.annotation.Resource;

/**
 * 我的加班 服务层实现
 * 
 * @author songzl
 * @date 2018-08-30
 */
@Service
public class OvertimeServiceImpl implements IOvertimeService 
{
	@Autowired
	private OvertimeMapper overtimeMapper;

	/**
     * 查询我的加班信息
     * 
     * @param overtimeId 我的加班ID
     * @return 我的加班信息
     */
    @Override
	public Overtime selectOvertimeById(Long overtimeId)
	{
	    return overtimeMapper.selectOvertimeById(overtimeId);
	}
	
	/**
     * 查询我的加班列表
     * 
     * @param overtime 我的加班信息
     * @return 我的加班集合
     */
	@Override
	public List<Overtime> selectOvertimeList(Overtime overtime)
	{
        if(!ShiroUtils.getUser().isAdmin()){
            overtime.setCreateId(ShiroUtils.getUserId());
        }
	    return overtimeMapper.selectOvertimeList(overtime);
	}
	
    /**
     * 新增我的加班
     * 
     * @param overtime 我的加班信息
     * @return 结果
     */
	@Override
	public int insertOvertime(Overtime overtime)
	{
        overtime.setCreateBy(ShiroUtils.getLoginName());
        overtime.setCreateId(ShiroUtils.getUserId());
	    return overtimeMapper.insertOvertime(overtime);
	}
	
	/**
     * 修改我的加班
     * 
     * @param overtime 我的加班信息
     * @return 结果
     */
	@Override
	public int updateOvertime(Overtime overtime)
	{
        overtime.setUpdateBy(ShiroUtils.getLoginName());
		overtime.setStatus(DailyStatus.APPROVEING.getCode());
	    return overtimeMapper.updateOvertime(overtime);
	}

	/**
     * 删除我的加班对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOvertimeByIds(String ids)
	{
		return overtimeMapper.deleteOvertimeByIds(Convert.toStrArray(ids));
	}
	
}
