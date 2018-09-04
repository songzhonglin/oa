package com.szl.oa.project.module.leave.domain;

import com.szl.oa.project.system.dept.domain.Dept;
import com.szl.oa.project.system.user.domain.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 请假管理表 sys_leave
 * 
 * @author songzl
 * @date 2018-08-11
 */
public class Leave extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long leaveId;
	/** 请假类型 */
	private String leaveType;
	/** 请假标题 */
	private String leaveTitle;
	/** 请假人 */
	private String leavePeople;
	/** 用户性别（0男 1女 2未知） */
	private String sex;
	/** 请假开始时间 */
	private String beginDate;
	/** 请假结束时间 */
	private String endDate;
	/** 请假天数 */
	private String dayNum;
	/** 所属部门 */
	private Long deptId;
	/** 请假原因 */
	private String leaveReason;
	/** 请假状态（0:申请中 1:审批通过 2:审批驳回） */
	private String leaveStatus;
	/** 部门审批意见 */
	private String content;
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

	/** 部门对象 */
	private Dept dept;

	private Long userId;

	private String opinion;

	private User user;


	public void setLeaveId(Long leaveId)
	{
		this.leaveId = leaveId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Long getLeaveId()
	{
		return leaveId;
	}
	public void setLeaveTitle(String leaveTitle) 
	{
		this.leaveTitle = leaveTitle;
	}

	public String getLeaveTitle() 
	{
		return leaveTitle;
	}
	public void setLeavePeople(String leavePeople) 
	{
		this.leavePeople = leavePeople;
	}

	public String getLeavePeople() 
	{
		return leavePeople;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setBeginDate(String beginDate)
	{
		this.beginDate = beginDate;
	}

	public String getBeginDate()
	{
		return beginDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public String getEndDate()
	{
		return endDate;
	}
	public void setDayNum(String dayNum)
	{
		this.dayNum = dayNum;
	}

	public String getDayNum()
	{
		return dayNum;
	}
	public void setDeptId(Long deptId)
	{
		this.deptId = deptId;
	}

	public Long getDeptId()
	{
		return deptId;
	}
	public void setLeaveReason(String leaveReason) 
	{
		this.leaveReason = leaveReason;
	}

	public String getLeaveReason() 
	{
		return leaveReason;
	}
	public void setLeaveStatus(String leaveStatus) 
	{
		this.leaveStatus = leaveStatus;
	}

	public String getLeaveStatus() 
	{
		return leaveStatus;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("leaveId", getLeaveId())
				.append("leaveType", getLeaveType())
            .append("leaveTitle", getLeaveTitle())
            .append("leavePeople", getLeavePeople())
            .append("sex", getSex())
            .append("beginDate", getBeginDate())
            .append("endDate", getEndDate())
            .append("dayNum", getDayNum())
            .append("deptId", getDeptId())
            .append("leaveReason", getLeaveReason())
            .append("leaveStatus", getLeaveStatus())
            .append("content", getContent())
            .append("createId", getCreateId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("dept", getDept())
			.append("userId",getUserId())
			.append("opinion",getOpinion())
			.append("user",getUser())
			.append("userId",getUserId())
            .toString();
    }
}
