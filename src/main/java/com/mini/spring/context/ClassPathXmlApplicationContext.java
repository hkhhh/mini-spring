package com.mini.spring.context;

import com.mini.spring.beans.BeanDefinition;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext {

  private final List<BeanDefinition> beanDefinitions = new ArrayList<>();
  private final Map<String, Object> singletons = new HashMap<>();

  public ClassPathXmlApplicationContext(String xmlFileName) {
    this.readXml(xmlFileName);
    this.instanceBeans();
  }

  @SuppressWarnings("unchecked")
  private void readXml(String xmlFileName) {
    SAXReader saxReader = new SAXReader();

    try {
      URL xmlPath = this.getClass().getClassLoader().getResource(xmlFileName);
      Document document = saxReader.read(xmlPath);
      Element rootElement = document.getRootElement();

      for (Element element : (List<Element>) rootElement.elements()) {
        String beanId = element.attributeValue("id");
        String beanClassName = element.attributeValue("class");
        BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
        beanDefinitions.add(beanDefinition);
      }
    } catch (Exception ignore) {
    }
  }

  private void instanceBeans() {
    for (BeanDefinition beanDefinition : beanDefinitions) {
      try {
        singletons.put(
          beanDefinition.getId(),
          Class.forName(beanDefinition.getClassName()).getDeclaredConstructor().newInstance()
        );
      } catch (Exception ignore) {
      }
    }
  }

  public Object getBean(String beanId) {
    return singletons.get(beanId);
  }
}
