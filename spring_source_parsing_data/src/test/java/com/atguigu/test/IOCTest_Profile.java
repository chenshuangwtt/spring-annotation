package com.atguigu.test;


import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.bean.Yellow;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.config.MainConfigOfProfile;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    //1. 命令行动态参数: 在虚拟机参数位置配置 -Dspring.profiles.active=test
    //2. 代码方式激活某种环境
    @Test
    public void test01(){
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        //1.创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2. 设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //3. 设置主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4. 刷新容器
        applicationContext.refresh();


        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);
        applicationContext.close();
    }

}
