package com.szl.oa.project.module.leaveApprove.domain;

import com.szl.oa.project.module.leave.domain.Leave;
import com.szl.oa.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 请假管理表 sys_leave_approve
 * 
 * @author songzl
 * @date 2018-08-18
 */
public class LeaveApprove extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 请假主键 */
	private Long approveId;
	/** 创建者ID */
	private Long createId;
	/** 请假ID */
	private Long leaveId;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;

	private Dept dept;
	private Leave leave;
	private String leaveStatus;
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
	public void setLeaveId(Long leaveId) 
	{
		this.leaveId = leaveId;
	}

	public Long getLeaveId() 
	{
		return leaveId;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
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
            .append("leaveId", getLeaveId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
				.append("dept",getDept())
				.append("leave",getLeave())
				.append("leaveStatus",getLeaveStatus())
				.append("opinion",getOpinion())
            .toString();
    }
}
