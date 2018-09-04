package com.szl.oa.project.module.weeklyApprove.domain;

import com.szl.oa.project.module.daily.domain.Daily;
import com.szl.oa.project.module.weeklyReport.domain.WeeklyReport;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 周报管理表 sys_weekly_approve
 * 
 * @author songzl
 * @date 2018-08-18
 */
public class WeeklyApprove extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 周报审批主键 */
	private Long approveId;
	/** 创建者ID */
	private Long createId;
	/** 周报ID */
	private Long weekId;
	/** 创建时间 */
	private Date createTime;

	private Date updateTime;

	private WeeklyReport weeklyReport;

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
	public void setWeekId(Long weekId) 
	{
		this.weekId = weekId;
	}

	public Long getWeekId() 
	{
		return weekId;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

	public WeeklyReport getWeeklyReport() {
		return weeklyReport;
	}

	public void setWeeklyReport(WeeklyReport weeklyReport) {
		this.weeklyReport = weeklyReport;
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

	@Override
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("approveId", getApproveId())
            .append("createId", getCreateId())
            .append("weekId", getWeekId())
            .append("createTime", getCreateTime())
				.append("updateTime", getUpdateTime())
				.append("weeklyReport",getWeeklyReport())
				.append("status",getStatus())
				.append("opinion",getOpinion())
            .toString();
    }
}
