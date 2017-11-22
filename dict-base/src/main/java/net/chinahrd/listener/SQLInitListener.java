package net.chinahrd.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;

/**
 * @author jxzhang on 2017年09月01
 * @Verdion 1.0版本
 */
//@WebListener
public class SQLInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化SQL脚本（数据字典）");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁SQL脚本（数据字典）");
    }
}
