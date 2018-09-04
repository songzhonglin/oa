package com.szl.oa;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author: songzl
 * @Date: 2018/8/3 17:00
 * @Description: web容器中进行部署
 */
public class OaServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(OaApplication.class);
    }
}
