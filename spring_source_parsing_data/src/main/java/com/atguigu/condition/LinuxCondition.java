package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否linux系统
public class LinuxCondition implements Condition {
    /**
     * @param ConditionContext      判断条件能是否的上下文
     * @param AnnotatedTypeMetadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // TODO 是否linux系统
        //1. 获取ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2. 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3. 获取当前环境信息
        Environment environment = context.getEnvironment();

        //4. 获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        //可以判断容器中bean的注册情况，也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");
        String property = environment.getProperty("os.name");
        if (property.contains("Linux")) {
            return true;
        }
        return false;
    }
}
