package com.practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDefinitionInheritance {
	
private String name;
	
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("beanDefinitionInheritance.xml");
		BeanDefinitionInheritance bean = (BeanDefinitionInheritance) container.getBean("childClass");
		System.out.println(bean.name);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
