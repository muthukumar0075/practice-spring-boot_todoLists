package com.muthu.dataStructur;

public class MyException implements Cloneable{
	public int age;
	public String name;
	public int[] arr;
	
	
	public MyException(int age,String name,int[] sequence) {
		this.age = age;
		this.name = name;
		this.arr = sequence;
	}
	

	public Object getClone() throws CloneNotSupportedException {
		return (MyException) super.clone();
	}
}
