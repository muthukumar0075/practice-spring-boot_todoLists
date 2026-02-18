package com.practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AutowiredBeanAndLookupMethodInjection {
	private BeanOverview mental;
	private String name;
	public BeanOverview getMental() {
		return mental;
	}
	public void setMental(BeanOverview mental) {
		this.mental = mental;
	}
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("autowiredAndLookUp.xml");
		AutowiredBeanAndLookupMethodInjection obj = container.getBean("auto",AutowiredBeanAndLookupMethodInjection.class);
		System.out.print(obj.mental);
		System.out.println(obj.name);
		System.out.print(obj.myMethod());
		
		
	}
	protected abstract BeanOverview myMethod();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
