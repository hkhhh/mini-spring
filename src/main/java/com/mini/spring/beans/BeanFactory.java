package com.mini.spring.beans;

public interface BeanFactory {

  Object getBean(String beanName) throws BeansException;

  void registerBeanDefinition(BeanDefinition definition);
}
