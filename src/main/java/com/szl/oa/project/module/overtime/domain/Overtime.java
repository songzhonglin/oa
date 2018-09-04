package com.szl.oa.project.module.overtime.domain;

import com.szl.oa.project.system.dept.domain.Dept;
import com.szl.oa.project.system.user.domain.User;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 我的加班表 sys_overtime
 * 
 * @author songzl
 * @date 2018-08-30
 */
@Data
public class Overtime extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 加班主键 */
	private Long overtimeId;

	/** 加班时间 */
	private String workDate;
	/** 加班内容 */
	private String overtimeContent;
	/** 加班时长 */
	private String overtimeHours;
	/** 创建者ID */
	private Long createId;

	/** 部门对象 */
	private Dept dept;
	/** 所属部门 */
	private Long deptId;
	/** 部门审批人 */
	private String leader;
	/** 审批人 */
	private User user;
	/** 审批人Id */
	private Long userId;
	/** 审批状态（0:申请中 1:审批通过 2:审批驳回） */
	private String status;
	/** 审批意见（0:申请中 1:审批通过 2:审批驳回） */
	private String opinion;




    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("overtimeId", getOvertimeId())
            .append("workDate", getWorkDate())
            .append("overtimeContent", getOvertimeContent())
            .append("overtimeHours", getOvertimeHours())
            .append("createId", getCreateId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("dept", getDept())
			.append("deptId", getDeptId())
			.append("leader", getLeader())
			.append("user",getUser())
			.append("userId",getUserId())
				.append("status",getStatus())
				.append("opinion",getOpinion())
            .toString();
    }
}
