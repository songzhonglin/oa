package com.szl.oa.project.module.employee.domain;

import com.szl.oa.project.system.dept.domain.Dept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.szl.oa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 员工管理表 sys_employee
 * 
 * @author songzl
 * @date 2018-08-19
 */
public class Employee extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 部门ID */
	private Long deptId;
	/** 员工主键 */
	private Long empId;
	/** 员工名称 */
	private String empName;
	/** 性别（0男 1女 2未知） */
	private String empSex;
	/** 出生日期 */
	private String empBirth;
	/** 现居住地址 */
	private String empCurrentAddress;
	/** 员工岗位 */
	private Long postId;
	/** 办公电话 */
	private String empTelephone;
	/** 移动电话 */
	private String empMobilephone;
	/** QQ */
	private String empQq;
	/** 电子邮件 */
	private String empEmail;
	/** 员工账号 */
	private String empAccount;
	/** 身份证 */
	private String empIdcard;
	/** 头像路径 */
	private String avatar;
	/** 入职时间 */
	private String empAddDate;
	/** 推荐人员 */
	private String empAddPerson;
	/** 员工职位 */
	private String empJob;
	/** 银行卡号 */
	private String empBank;
	/** 国籍 */
	private String empNationality;
	/** 出生地 */
	private String empOrigin;
	/** 民族 */
	private String empNation;
	/** 学校名称 */
	private String empSchool;
	/** 文化程度 */
	private String empEducation;
	/** 员工专业 */
	private String empProfession;
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

	private String status;

	private Dept dept;

	/**社保卡号**/
	private String empSocialSecurity;
	/**婚姻状况**/
	private String empMarriage;
	/**政治面貌**/
	private String empPolitics;

	private String openStatus;

	private String empLeaveDate;

	private String empOpenDate;

	private String empWebchat;

	public void setDeptId(Long deptId)
	{
		this.deptId = deptId;
	}

	public Long getDeptId()
	{
		return deptId;
	}
	public void setEmpId(Long empId) 
	{
		this.empId = empId;
	}

	public Long getEmpId() 
	{
		return empId;
	}
	public void setEmpName(String empName) 
	{
		this.empName = empName;
	}

	public String getEmpName() 
	{
		return empName;
	}
	public void setEmpSex(String empSex) 
	{
		this.empSex = empSex;
	}

	public String getEmpSex() 
	{
		return empSex;
	}
	public void setEmpBirth(String empBirth) 
	{
		this.empBirth = empBirth;
	}

	public String getEmpBirth() 
	{
		return empBirth;
	}
	public void setEmpCurrentAddress(String empCurrentAddress) 
	{
		this.empCurrentAddress = empCurrentAddress;
	}

	public String getEmpCurrentAddress() 
	{
		return empCurrentAddress;
	}
	public void setPostId(Long postId)
	{
		this.postId = postId;
	}

	public Long getPostId()
	{
		return postId;
	}
	public void setEmpTelephone(String empTelephone) 
	{
		this.empTelephone = empTelephone;
	}

	public String getEmpTelephone() 
	{
		return empTelephone;
	}
	public void setEmpMobilephone(String empMobilephone) 
	{
		this.empMobilephone = empMobilephone;
	}

	public String getEmpMobilephone() 
	{
		return empMobilephone;
	}
	public void setEmpQq(String empQq) 
	{
		this.empQq = empQq;
	}

	public String getEmpQq() 
	{
		return empQq;
	}
	public void setEmpEmail(String empEmail) 
	{
		this.empEmail = empEmail;
	}

	public String getEmpEmail() 
	{
		return empEmail;
	}
	public void setEmpAccount(String empAccount) 
	{
		this.empAccount = empAccount;
	}

	public String getEmpAccount() 
	{
		return empAccount;
	}
	public void setEmpIdcard(String empIdcard) 
	{
		this.empIdcard = empIdcard;
	}

	public String getEmpIdcard() 
	{
		return empIdcard;
	}
	public void setAvatar(String avatar) 
	{
		this.avatar = avatar;
	}

	public String getAvatar() 
	{
		return avatar;
	}
	public void setEmpAddDate(String empAddDate)
	{
		this.empAddDate = empAddDate;
	}

	public String getEmpAddDate()
	{
		return empAddDate;
	}
	public void setEmpAddPerson(String empAddPerson) 
	{
		this.empAddPerson = empAddPerson;
	}

	public String getEmpAddPerson() 
	{
		return empAddPerson;
	}
	public void setEmpJob(String empJob)
	{
		this.empJob = empJob;
	}

	public String getEmpJob()
	{
		return empJob;
	}
	public void setEmpBank(String empBank) 
	{
		this.empBank = empBank;
	}

	public String getEmpBank() 
	{
		return empBank;
	}
	public void setEmpNationality(String empNationality)
	{
		this.empNationality = empNationality;
	}

	public String getEmpNationality()
	{
		return empNationality;
	}
	public void setEmpOrigin(String empOrigin)
	{
		this.empOrigin = empOrigin;
	}

	public String getEmpOrigin()
	{
		return empOrigin;
	}
	public void setEmpNation(String empNation)
	{
		this.empNation = empNation;
	}

	public String getEmpNation()
	{
		return empNation;
	}
	public void setEmpSchool(String empSchool)
	{
		this.empSchool = empSchool;
	}

	public String getEmpSchool()
	{
		return empSchool;
	}
	public void setEmpEducation(String empEducation)
	{
		this.empEducation = empEducation;
	}

	public String getEmpEducation()
	{
		return empEducation;
	}
	public void setEmpProfession(String empProfession) 
	{
		this.empProfession = empProfession;
	}

	public String getEmpProfession() 
	{
		return empProfession;
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


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getEmpSocialSecurity() {
		return empSocialSecurity;
	}

	public void setEmpSocialSecurity(String empSocialSecurity) {
		this.empSocialSecurity = empSocialSecurity;
	}

	public String getEmpMarriage() {
		return empMarriage;
	}

	public void setEmpMarriage(String empMarriage) {
		this.empMarriage = empMarriage;
	}

	public String getEmpPolitics() {
		return empPolitics;
	}

	public void setEmpPolitics(String empPolitics) {
		this.empPolitics = empPolitics;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getEmpLeaveDate() {
		return empLeaveDate;
	}

	public void setEmpLeaveDate(String empLeaveDate) {
		this.empLeaveDate = empLeaveDate;
	}

	public String getEmpOpenDate() {
		return empOpenDate;
	}

	public void setEmpOpenDate(String empOpenDate) {
		this.empOpenDate = empOpenDate;
	}

	public String getEmpWebchat() {
		return empWebchat;
	}

	public void setEmpWebchat(String empWebchat) {
		this.empWebchat = empWebchat;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("empId", getEmpId())
            .append("empName", getEmpName())
            .append("empSex", getEmpSex())
            .append("empBirth", getEmpBirth())
            .append("empCurrentAddress", getEmpCurrentAddress())
            .append("postId", getPostId())
            .append("empTelephone", getEmpTelephone())
            .append("empMobilephone", getEmpMobilephone())
            .append("empQq", getEmpQq())
            .append("empEmail", getEmpEmail())
            .append("empAccount", getEmpAccount())
            .append("empIdcard", getEmpIdcard())
            .append("avatar", getAvatar())
            .append("empAddDate", getEmpAddDate())
            .append("empAddPerson", getEmpAddPerson())
            .append("empJob", getEmpJob())
            .append("empBank", getEmpBank())
            .append("empNationality", getEmpNationality())
            .append("empOrigin", getEmpOrigin())
            .append("empNation", getEmpNation())
            .append("empSchool", getEmpSchool())
            .append("empEducation", getEmpEducation())
            .append("empProfession", getEmpProfession())
            .append("createId", getCreateId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("status",getStatus())
			.append("dept",getDept())
			.append("empSocialSecurity",getEmpSocialSecurity())
			.append("empMarriage",getEmpMarriage())
			.append("empPolitics",getEmpPolitics())
				.append("openStatus",getOpenStatus())
				.append("empLeaveDate",getEmpLeaveDate())
				.append("empOpenDate",getEmpOpenDate())
				.append("empWebchat",getEmpWebchat())
            .toString();
    }
}
