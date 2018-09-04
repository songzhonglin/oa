package com.szl.oa.project.module.attendence.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 考勤管理表 sys_attendence
 * 
 * @author songzl
 * @date 2018-08-31
 */
public class Attendence extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long attendId;
	/** 考勤日期 */
	private String dutyDay;
	/** 创建者ID */
	private Long createId;
	/** 创建者 */
	private String createBy;
	/** 上班时间 */
	private Date createTime;
	/** 上班状态（0：正常1：迟到） */
	private String onStatus;
	/** 更新者 */
	private String updateBy;
	/** 下班时间 */
	private Date updateTime;
	/** 下班状态（0：正常2：早退） */
	private String offStatus;

	public void setAttendId(Long attendId) 
	{
		this.attendId = attendId;
	}

	public Long getAttendId() 
	{
		return attendId;
	}
	public void setDutyDay(String dutyDay) 
	{
		this.dutyDay = dutyDay;
	}

	public String getDutyDay() 
	{
		return dutyDay;
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
	public void setOnStatus(String onStatus) 
	{
		this.onStatus = onStatus;
	}

	public String getOnStatus() 
	{
		return onStatus;
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
	public void setOffStatus(String offStatus) 
	{
		this.offStatus = offStatus;
	}

	public String getOffStatus() 
	{
		return offStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attendId", getAttendId())
            .append("dutyDay", getDutyDay())
            .append("createId", getCreateId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("onStatus", getOnStatus())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("offStatus", getOffStatus())
            .toString();
    }
}
