package com.jiaoyin.springframework.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiaoyin.springframework.beans.UserService;
import com.jiaoyin.springframework.beans.factory.config.BeanDefinition;
import com.jiaoyin.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;


public class ApiTest {
    @Test
    public void test_beanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }

    @Test
    public void test() {
        String a = "[]";
        JSONArray x = JSONObject.parseArray(a);
        System.out.println(x.size());
        System.out.println(x.toJSONString());
    }
}
