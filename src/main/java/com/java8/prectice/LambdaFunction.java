package com.java8.prectice;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaFunction {
	//only works with function interface
	public static void main(String[] args) {
		PracticeInterface pra = new PracticeInterface() {
			
			@Override
			public void doSomething(int a,int b) {
				//System.out.println("example for annonmyns class");
				
			}
		};
		pra .doSomething(5,6);
		
		// Now using the same with lambda 
		
		PracticeInterface praLambda = (a,b) -> {
			//System.out.println("example for lambda expression");
		};
		praLambda.doSomething(5,6);
		List<Family> famDetails = new ArrayList<>();
		famDetails.add(new LambdaFunction().new Family(25,"Muthukumar"));
		famDetails.add(new LambdaFunction().new Family(24,"SashyaNelson"));
		famDetails.add(new LambdaFunction().new Family(0,"Aries"));
		famDetails.add(new LambdaFunction().new Family(0,"Kasandra"));
		Comparator<Family> com = (i,j) -> Integer.compare(i.age,j.age);
		
		Collections.sort(famDetails,com);
		famDetails.stream().map(i -> i.name).forEach(System.out::println);
	}
	
	class Family implements Comparable<Family>{
		int age;
		String name = "";
		public Family(int age,String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Family o) {
			// TODO Auto-generated method stub
			if(this.age > o.age) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}

}
