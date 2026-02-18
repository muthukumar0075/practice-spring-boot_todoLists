package com.practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjection {
	
	private String name;
	private int age;
	//setter injection
	private String favFood;
	private BeanOverview beanOverview;
	
	public BeanOverview getBeanOverview() {
		return beanOverview;
	}

	public void setBeanOverview(BeanOverview beanOverview) {
		this.beanOverview = beanOverview;
	}

	public DependencyInjection(String name ,int age) {
		this.age = age;
		this.name = name;
		System.out.println(this.age+"=age "+this.name+"=name");
	}

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("DependencyIn.xml");
		DependencyInjection obj1 = container.getBean("dependConst", DependencyInjection.class);
		DependencyInjection obj2 = container.getBean("dependConst1", DependencyInjection.class);
		DependencyInjection obj3 = container.getBean("dependConst2", DependencyInjection.class);
		DependencyInjection obj4 = container.getBean("dependConst3", DependencyInjection.class);
		System.out.println(obj4.favFood);
		DependencyInjection obj5 = container.getBean("dependConst4", DependencyInjection.class);
		System.out.println(obj5.beanOverview.getName());
		DependencyInjection obj6 = container.getBean("dependConst5", DependencyInjection.class);
		System.out.println(obj6.beanOverview);
		
		

	}

	public String getFavFood() {
		return favFood;
	}

	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}

}
