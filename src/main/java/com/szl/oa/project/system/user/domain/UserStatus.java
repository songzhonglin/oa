package com.szl.oa.project.system.user.domain;

/**
 * 用户状态
 * 
 * @author ruoyi
 *
 */
public enum UserStatus
{
    OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除"),MANAGER("0","管理员"),LEADER("1","部门领导"),USER("2","普通用户");

    private final String code;
    private final String info;

    UserStatus(String code, String info)
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
