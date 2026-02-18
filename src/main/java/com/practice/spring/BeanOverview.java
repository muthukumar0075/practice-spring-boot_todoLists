package com.practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanOverview {
	private String name;
	
	//Using static factory method
	//public static BeanOverview obj = new BeanOverview();
	
//	//Using non static factory method
//	public BeanOverview nonStaticFactoryBean() {
//		return obj;
//	}
//	
//	public static BeanOverview factoryBean() {
//		return obj;
//	}
	
	
	
	BeanOverview(){
		System.out.println("inconstructor");
	}

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("beanContainer.xml");
		BeanOverview testObj = (BeanOverview) container.getBean("petStore");
		BeanOverview testObj2 = (BeanOverview) container.getBean("nonStaticFactoryMethod");
		BeanOverview testObj3 = (BeanOverview) container.getBean("petStore2");
		BeanOverview testObj4 = (BeanOverview) container.getBean("petStore3");
		System.out.println(testObj3.name);
		System.out.println(testObj4.name);
		
		
		
		

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
