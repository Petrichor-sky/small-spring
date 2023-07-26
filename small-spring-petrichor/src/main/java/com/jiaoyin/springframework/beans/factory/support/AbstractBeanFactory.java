package com.jiaoyin.springframework.beans.factory.support;


import com.jiaoyin.springframework.beans.BeansException;
import com.jiaoyin.springframework.beans.factory.BeanFactory;
import com.jiaoyin.springframework.beans.factory.config.BeanDefinition;

/**
 *
 * BeanDefinition 注册表接口
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        //BeanFactory中的抽象方法调用DefaultSingletonBeanRegistry的单例bean
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
