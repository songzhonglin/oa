package com.szl.oa.project.system.user.controller;

import com.szl.oa.framework.config.OAConfig;

import com.szl.oa.framework.web.controller.BaseController;
import com.szl.oa.project.system.menu.domain.Menu;
import com.szl.oa.project.system.menu.service.IMenuService;
import com.szl.oa.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 * 
 * @author szl.oa
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private OAConfig oaConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        User user = getUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUserId(user.getUserId());
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", oaConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", oaConfig.getVersion());
        return "main";
    }

}
