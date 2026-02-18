package com.practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependOnAndLasyBean {
	private String myName;
	private DependOnAndLasyBean depOnBean;
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("lasyBeanAndDependOn.xml");
		DependOnAndLasyBean obj = (DependOnAndLasyBean) container.getBean("lasyBean");
		DependOnAndLasyBean obj1 = (DependOnAndLasyBean) container.getBean("lasyBeans");
		obj.setDepOnBean(obj1);
		System.out.println(obj.myName);
		System.out.println(obj.getDepOnBean());
		System.out.println(container.containsBean("lasy"));

	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public DependOnAndLasyBean getDepOnBean() {
		return depOnBean;
	}
	public void setDepOnBean(DependOnAndLasyBean depOnBean) {
		this.depOnBean = depOnBean;
	}

}
