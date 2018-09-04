package com.szl.oa.project.module.overtime.domain;

import com.szl.oa.framework.aspectj.lang.annotation.Excel;
import com.szl.oa.project.system.dept.domain.Dept;
import com.szl.oa.project.system.user.domain.User;
import lombok.Data;

/**
 * @Author: songzl
 * @Date: 2018/8/30 13:46
 * @Description:
 */
@Data
public class OvertimeExcel {

    /** 加班主键 */
    @Excel(name = "序号")
    private Long overtimeId;
    /** 加班人 */
    @Excel(name = "加班人")
    private String createBy;
    /** 加班时间 */
    @Excel(name = "加班时间")
    private String workDate;
    /** 加班内容 */
    @Excel(name = "加班时间")
    private String overtimeContent;
    /** 加班时长 */
    @Excel(name = "加班时长")
    private String overtimeHours;
    @Excel(name = "所属部门")
    private String deptName;
    @Excel(name = "审批人")
    private String approveUserName;
    /** 审批状态（0:申请中 1:审批通过 2:审批驳回） */
    @Excel(name = "审批状态")
    private String statusName;
    /** 审批意见（0:申请中 1:审批通过 2:审批驳回） */
    @Excel(name = "审批意见")
    private String opinion;
    @Excel(name = "创建时间")
    private String createTimes;

}
