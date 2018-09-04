package com.szl.oa.project.module.dailyApprove.domain;

import com.szl.oa.project.module.daily.domain.Daily;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 日报管理表 sys_daily_approve
 * 
 * @author songzl
 * @date 2018-08-17
 */
public class DailyApprove extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 日报审批主键 */
	private Long approveId;
	/** 创建者ID */
	private Long createId;
	/** 日报ID */
	private Long dailyId;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/**日报**/
	private Daily daily;

	private String status;

	private String opinion;

	public void setApproveId(Long approveId) 
	{
		this.approveId = approveId;
	}

	public Long getApproveId() 
	{
		return approveId;
	}
	public void setCreateId(Long createId) 
	{
		this.createId = createId;
	}

	public Long getCreateId() 
	{
		return createId;
	}
	public void setDailyId(Long dailyId) 
	{
		this.dailyId = dailyId;
	}

	public Long getDailyId() 
	{
		return dailyId;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

	public Daily getDaily() {
		return daily;
	}

	public void setDaily(Daily daily) {
		this.daily = daily;
	}

	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("approveId", getApproveId())
            .append("createId", getCreateId())
            .append("dailyId", getDailyId())
            .append("createTime", getCreateTime())
		    .append("daily",getDaily())
			.append("createBy",getCreateBy())
			.append("updateTime",getUpdateTime())
				.append("daily",getDaily())
				.append("status",getStatus())
				.append("opinion",getOpinion())
            .toString();
    }
}
