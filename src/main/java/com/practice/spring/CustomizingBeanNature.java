package com.practice.spring;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

public class CustomizingBeanNature {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("customizingBeanNature.xml");
		container.getBean("testOfNature");
	}
	
	public void init() {
		System.out.println("initializedBean");
	}
	
	public void destroy() {
		System.out.println("destoryBean");
	}

}
