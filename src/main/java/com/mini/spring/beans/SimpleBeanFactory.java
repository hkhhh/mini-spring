package com.mini.spring.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBeanFactory implements BeanFactory {

  private final List<String> beanNames = new ArrayList<>();
  private final List<BeanDefinition> beanDefinitions = new ArrayList<>();
  private final Map<String, Object> singletons = new HashMap<>();

  @Override
  public Object getBean(String beanName) throws BeansException {
    Object singleton = singletons.get(beanName);
    if (singleton == null) {
      int i = beanNames.indexOf(beanName);
      if (i == -1) {
        throw new BeansException();
      }
      BeanDefinition beanDefinition = beanDefinitions.get(i);
      try {
        singleton = Class.forName(beanDefinition.getClassName()).getDeclaredConstructor().newInstance();
      } catch (Exception ignore) {
      }
      singletons.put(beanDefinition.getId(), singleton);
    }
    return singleton;
  }

  @Override
  public void registerBeanDefinition(BeanDefinition definition) {
    beanNames.add(definition.getId());
    beanDefinitions.add(definition);
  }
}
