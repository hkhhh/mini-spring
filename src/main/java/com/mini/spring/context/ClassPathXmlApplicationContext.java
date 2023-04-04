package com.mini.spring.context;

import com.mini.spring.beans.BeanDefinition;
import com.mini.spring.beans.BeanFactory;
import com.mini.spring.beans.BeansException;
import com.mini.spring.beans.SimpleBeanFactory;
import com.mini.spring.beans.xml.XmlBeanDefinitionReader;
import com.mini.spring.core.ClassPathXmlResource;
import com.mini.spring.core.Resource;

public class ClassPathXmlApplicationContext implements BeanFactory {

  private final BeanFactory beanFactory;

  public ClassPathXmlApplicationContext(String xmlFileName) {
    this.beanFactory = new SimpleBeanFactory();
    Resource resource = new ClassPathXmlResource(xmlFileName);
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this.beanFactory);
    reader.loadBeanDefinitions(resource);
  }

  @Override
  public Object getBean(String beanName) throws BeansException {
    return beanFactory.getBean(beanName);
  }

  @Override
  public void registerBeanDefinition(BeanDefinition definition) {
    beanFactory.registerBeanDefinition(definition);
  }
}
