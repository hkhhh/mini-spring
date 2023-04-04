package com.mini.spring.beans.xml;

import com.mini.spring.beans.BeanDefinition;
import com.mini.spring.beans.BeanFactory;
import com.mini.spring.core.Resource;
import org.dom4j.Element;

public class XmlBeanDefinitionReader {

  private final BeanFactory beanFactory;

  public XmlBeanDefinitionReader(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }

  public void loadBeanDefinitions(Resource resource) {
    while (resource.hasNext()) {
      Element element = (Element) resource.next();
      String beanName = element.attributeValue("id");
      String beanClassName = element.attributeValue("class");
      BeanDefinition beanDefinition = new BeanDefinition(beanName, beanClassName);
      beanFactory.registerBeanDefinition(beanDefinition);
    }
  }
}
