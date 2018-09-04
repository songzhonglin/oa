package com.szl.oa.project.module.weeklyReport.domain;

import com.szl.oa.project.system.user.domain.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 周报管理表 sys_weekly_report
 * 
 * @author songzl
 * @date 2018-08-11
 */
public class WeeklyReport extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 周报主键 */
	private Long weekId;
	/** 工作内容 */
	private String workContent;
	/** 工作开始时间 */
	private String workStart;
	/** 工作结束时间 */
	private String workEnd;
	/** 创建者ID */
	private Long createId;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;

	private Long userId;

	private User user;

	private String status;

	private String opinion;

	public void setWeekId(Long weekId) 
	{
		this.weekId = weekId;
	}

	public Long getWeekId() 
	{
		return weekId;
	}
	public void setWorkContent(String workContent) 
	{
		this.workContent = workContent;
	}

	public String getWorkContent() 
	{
		return workContent;
	}
	public void setWorkStart(String workStart)
	{
		this.workStart = workStart;
	}

	public String getWorkStart()
	{
		return workStart;
	}
	public void setWorkEnd(String workEnd)
	{
		this.workEnd = workEnd;
	}

	public String getWorkEnd()
	{
		return workEnd;
	}
	public void setCreateId(Long createId) 
	{
		this.createId = createId;
	}

	public Long getCreateId() 
	{
		return createId;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
            .append("weekId", getWeekId())
            .append("workContent", getWorkContent())
            .append("workStart", getWorkStart())
            .append("workEnd", getWorkEnd())
            .append("createId", getCreateId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("userId",getUserId())
			.append("user",getUser())
			.append("status",getStatus())
			.append("opinion",getOpinion())
            .toString();
    }
}
