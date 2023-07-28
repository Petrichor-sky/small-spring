package com.jiaoyin.springframework.beans.factory.support;

import com.jiaoyin.springframework.beans.BeansException;
import com.jiaoyin.springframework.core.io.Resource;
import com.jiaoyin.springframework.core.io.ResourceLoader;


public interface BeanDefinitionReader {
    //getRegistry()、getResourceLoader()，都是用于提供给后面三个方法的工具
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}