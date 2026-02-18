package com.java8.prectice;
@FunctionalInterface
public interface PracticeInterface {
	void doSomething(int a,int b);
	default void info() {
		System.out.println("this a practiceInterFace");
	}
}
