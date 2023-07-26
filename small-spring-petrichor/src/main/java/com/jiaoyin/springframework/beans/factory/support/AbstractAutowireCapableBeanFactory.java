package com.jiaoyin.springframework.beans.factory.support;

import com.jiaoyin.springframework.beans.BeansException;
import com.jiaoyin.springframework.beans.factory.config.BeanDefinition;

/**
 * 实现AbstractBeanFactory中的createBean抽象方法
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

}
