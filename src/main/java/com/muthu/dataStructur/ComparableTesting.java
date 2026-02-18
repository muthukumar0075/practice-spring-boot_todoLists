package com.muthu.dataStructur;

public class ComparableTesting implements Comparable<ComparableTesting>{
	@Override
	public String toString() {
		return "[" + age + "]";
	}
	private int mark;
	private int age;
	public ComparableTesting(int mark,int age) {
		this.mark = mark;
		this.age = age;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	@Override
//	public int compareTo(ComparableTesting o) {
//		return this.age - o.age;
//	}
	@Override
	public int compareTo(ComparableTesting o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
