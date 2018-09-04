package com.szl.oa.project.module.daily.domain;

import com.szl.oa.framework.aspectj.lang.annotation.Excel;
import com.szl.oa.project.system.user.domain.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 日报管理表 sys_daily
 * 
 * @author songzl
 * @date 2018-08-09
 */
public class Daily extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Excel(name = "日报序号")
	/** 日报主键 */
	private Long dailyId;
	@Excel(name = "工作内容")
	/** 工作内容 */
	private String workContent;
	@Excel(name = "工作时间")
	/** 工作时间 */
	private String workDate;
	@Excel(name = "工作时长")
	/** 工作时长 */
	private Long workHours;
	@Excel(name = "是否加班")
	/** 是否加班（1是 0否） */
	private String workOvertime;
	@Excel(name = "加班内容")
	/** 加班内容 */
	private String overtimeContent;
	@Excel(name = "加班时长")
	/** 加班时长 */
	private Long overtimeHours;
	/** 创建者ID */
	private Long createId;
	/** 创建者 */
	private String createBy;
	@Excel(name = "创建时间")
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

	public void setDailyId(Long dailyId) 
	{
		this.dailyId = dailyId;
	}

	public Long getDailyId() 
	{
		return dailyId;
	}
	public void setWorkContent(String workContent) 
	{
		this.workContent = workContent;
	}

	public String getWorkContent() 
	{
		return workContent;
	}
	public void setWorkDate(String workDate) 
	{
		this.workDate = workDate;
	}

	public String getWorkDate() 
	{
		return workDate;
	}
	public void setWorkHours(Long workHours) 
	{
		this.workHours = workHours;
	}

	public Long getWorkHours() 
	{
		return workHours;
	}
	public void setWorkOvertime(String workOvertime) 
	{
		this.workOvertime = workOvertime;
	}

	public String getWorkOvertime() 
	{
		return workOvertime;
	}
	public void setOvertimeContent(String overtimeContent) 
	{
		this.overtimeContent = overtimeContent;
	}

	public String getOvertimeContent() 
	{
		return overtimeContent;
	}
	public void setOvertimeHours(Long overtimeHours) 
	{
		this.overtimeHours = overtimeHours;
	}

	public Long getOvertimeHours() 
	{
		return overtimeHours;
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
            .append("dailyId", getDailyId())
			.append("userId", getUserId())
            .append("workContent", getWorkContent())
            .append("workDate", getWorkDate())
            .append("workHours", getWorkHours())
            .append("workOvertime", getWorkOvertime())
            .append("overtimeContent", getOvertimeContent())
            .append("overtimeHours", getOvertimeHours())
            .append("createId", getCreateId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("user",getUser())
			.append("status",getStatus())
				.append("opinion",getOpinion())

            .toString();
    }
}
