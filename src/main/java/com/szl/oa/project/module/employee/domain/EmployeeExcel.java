package com.szl.oa.project.module.employee.domain;

import com.szl.oa.framework.aspectj.lang.annotation.Excel;
import com.szl.oa.project.system.dept.domain.Dept;
import lombok.Data;

import java.util.Date;

/**
 * @Author: songzl
 * @Date: 2018/8/28 13:59
 * @Description:
 */
@Data
public class EmployeeExcel {

    /** 员工主键 */
    @Excel(name = "员工序号")
    private Long empId;
    /** 员工账号 */
    @Excel(name = "员工账号")
    private String empAccount;
    /** 员工名称 */
    @Excel(name = "员工名称")
    private String empName;
    /** 性别（0男 1女 2未知） */
    @Excel(name = "员工性别")
    private String empSexName;
    /** 身份证 */
    @Excel(name = "身份证")
    private String empIdcard;
    /** 出生日期 */
    @Excel(name = "出生日期")
    private String empBirth;
    /** 电子邮件 */
    @Excel(name = "电子邮件")
    private String empEmail;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String empMobilephone;

    @Excel(name = "员工状态")
    private String statusName;
    /** 入职时间 */
    @Excel(name = "入职时间")
    private String empAddDate;
    @Excel(name = "离职时间")
    private String empLeaveDate;
    @Excel(name = "账号状态")
    private String openStatusName;
    @Excel(name = "开通时间")
    private String empOpenDate;
    /** 员工岗位 */
    @Excel(name = "员工岗位")
    private String postName;
    @Excel(name = "所属部门")
    private String deptName;

    /** 现居住地址 */
    @Excel(name = "现居住地址")
    private String empCurrentAddress;
    /** 户籍地址 */
    @Excel(name = "户籍地址")
    private String empOrigin;

    /** QQ */
    @Excel(name = "QQ")
    private String empQq;
    @Excel(name = "微信号")
    private String empWebchat;
    /** 银行卡号 */
    @Excel(name = "银行卡号")
    private String empBank;
    /**社保卡号**/
    @Excel(name = "社保卡号")
    private String empSocialSecurity;
    /** 国籍 */
    @Excel(name = "国籍")
    private String empNationalityName;
    /** 民族 */
    @Excel(name = "民族")
    private String empNationName;
    /** 学校名称 */
    @Excel(name = "学校名称")
    private String empSchool;
    /** 文化程度 */
    @Excel(name = "文化程度")
    private String empEducationName;
    /** 员工专业 */
    @Excel(name = "员工专业")
    private String empProfession;
    /**婚姻状况**/
    @Excel(name = "婚姻状况")
    private String empMarriageName;
    /**政治面貌**/
    @Excel(name = "政治面貌")
    private String empPoliticsName;

}
