package com.szl.oa.project.module.leave.domain;

/**
 * 用户状态
 * 
 * @author songzl
 *
 */
public enum LeaveStatus
{
    LOAD("0", "审核中"), PASS("1", "审核通过"), REJECT("2", "审核驳回"),
    APPROVEING("0","审批中"),APPROVE("1","审批通过"),APPROVED("2","审批驳回");

    private final String code;
    private final String info;

    LeaveStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
