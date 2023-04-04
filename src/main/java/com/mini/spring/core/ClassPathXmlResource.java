package com.mini.spring.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

public class ClassPathXmlResource implements Resource {

  private Iterator<Element> elementIterator;

  @SuppressWarnings("unchecked")
  public ClassPathXmlResource(String fileName) {
    SAXReader saxReader = new SAXReader();
    URL url = this.getClass().getClassLoader().getResource(fileName);

    try {
      Document document = saxReader.read(url);
      Element rootElement = document.getRootElement();
      this.elementIterator = rootElement.elementIterator();
    } catch (Exception ignore) {
    }
  }

  @Override
  public boolean hasNext() {
    return elementIterator.hasNext();
  }

  @Override
  public Object next() {
    return elementIterator.next();
  }
}
