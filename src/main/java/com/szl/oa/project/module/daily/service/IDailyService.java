package com.szl.oa.project.module.daily.service;

import com.szl.oa.project.module.daily.domain.Daily;
import java.util.List;

/**
 * 日报管理 服务层
 * 
 * @author songzl
 * @date 2018-08-09
 */
public interface IDailyService 
{
	/**
     * 查询日报管理信息
     * 
     * @param dailyId 日报管理ID
     * @return 日报管理信息
     */
	public Daily selectDailyById(Long dailyId);
	
	/**
     * 查询日报管理列表
     * 
     * @param daily 日报管理信息
     * @return 日报管理集合
     */
	public List<Daily> selectDailyList(Daily daily);
	
	/**
     * 新增日报管理
     * 
     * @param daily 日报管理信息
     * @return 结果
     */
	public int insertDaily(Daily daily);
	
	/**
     * 修改日报管理
     * 
     * @param daily 日报管理信息
     * @return 结果
     */
	public int updateDaily(Daily daily);
		
	/**
     * 删除日报管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDailyByIds(String ids);
	
}
