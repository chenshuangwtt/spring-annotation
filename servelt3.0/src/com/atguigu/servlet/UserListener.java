package com.atguigu.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
   *  监听项目的启动和停止
 * @author Administrator
 *
 */

public class UserListener implements ServletContextListener {

	//监听ServletContext的销毁
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("UserListener....contextDestroyed.....");
	}

	//监听ServletContext启动初始化
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("UserListener....contextInitialized.....");
	}

}
