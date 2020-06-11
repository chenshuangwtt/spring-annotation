package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/async",asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 支持异步模式  asyncSupported = true
		//2. 开启异步处理
		System.out.println("主线程开始...."+Thread.currentThread()+"==>"+System.currentTimeMillis());
		AsyncContext asyncContext =	req.startAsync();
		//3.业务逻辑进行异步处理，开始异步处理
		asyncContext.start(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("副线程开始...."+Thread.currentThread()+"==>"+System.currentTimeMillis());
					sayHello();
					asyncContext.complete();
					AsyncContext asyncContext =	req.startAsync();
					ServletResponse response =asyncContext.getResponse();
					response.getWriter().write("Hello async....");
					System.out.println("副线程结束...."+Thread.currentThread()+"==>"+System.currentTimeMillis());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("主线程结束...."+Thread.currentThread()+"==>"+System.currentTimeMillis());
	}
	
	public void  sayHello() throws Exception{
		System.out.println(Thread.currentThread()+"  processing....");
		Thread.sleep(3000);
	}
	
}
