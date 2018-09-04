package com.szl.oa.project.module.weeklyReport.domain;

/**
 * 周报状态
 * 
 * @author songzl
 *
 */
public enum WeeklyReportStatus
{
    APPROVEING("0","审批中"),APPROVE("1","审批通过"),APPROVED("2","审批驳回");

    private final String code;
    private final String info;

    WeeklyReportStatus(String code, String info)
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
