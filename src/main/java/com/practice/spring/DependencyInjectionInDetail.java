package com.practice.spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionInDetail {
	private Properties name ;
	private Properties url;
	private Properties websitesName;
	private List<String> ourList;
	private Map<String,String> ourMap;
	private Set<String> ourSet;

	

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("dependencyInjectionInDetail.xml");
		DependencyInjectionInDetail obj = container.getBean("DepInDetail",DependencyInjectionInDetail.class);
		System.out.println(obj.name);
		System.out.println(obj.url);
		System.out.println(obj.websitesName);
		System.out.println(obj.ourList);
		System.out.println(obj.ourMap);
		System.out.println(obj.ourSet);

	}

	public Properties getWebsitesName() {
		return websitesName;
	}

	public void setWebsitesName(Properties websitesName) {
		this.websitesName = websitesName;
	}

	public Properties getName() {
		return name;
	}

	public void setName(Properties name) {
		this.name = name;
	}

	public Properties getUrl() {
		return url;
	}

	public void setUrl(Properties url) {
		this.url = url;
	}

	public List getOurList() {
		return ourList;
	}

	public void setOurList(List ourList) {
		this.ourList = ourList;
	}

	public Map<String,String> getOurMap() {
		return ourMap;
	}

	public void setOurMap(Map<String,String> ourMap) {
		this.ourMap = ourMap;
	}

	public Set<String> getOurSet() {
		return ourSet;
	}

	public void setOurSet(Set<String> ourSet) {
		this.ourSet = ourSet;
	}

}
