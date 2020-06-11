package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// 配置类 == 配置文件
@Configuration   //告诉Spring这是一个配置类
@ComponentScans(value = {
        @ComponentScan(value = "com.atguigu",includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = { Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },useDefaultFilters = false)
})
//value 默认为指定扫描的包路径
// excludeFilters = Filter[]  指定扫描的时候按照什么规则排除哪些组件
//includeFilters  = Filter[]  指定扫描的时候只需要包含哪些组件
// FilterType.ANNOTATION  按照注解
// FilterType.ASSIGNABLE_TYPE   按照给定的类型
// FilterType.ASPECTJ  使用ASPECTJ表达式
// FilterType.REGEX   使用正则表达式
// FilterType.CUSTOM  使用自定义的
// useDefaultFilters 禁用默认全局 includeFilters 才会生效
// ComponentScans  数组可以配置多个ComponentScan

public class MainConfig {

    //给容器中注册一个bean 类型为其返回值的类型， id默认为方法名作为id
    @Bean("person")  //括号内为获取的name
    public Person person01(){
        return new Person("list",20);
    }

}
