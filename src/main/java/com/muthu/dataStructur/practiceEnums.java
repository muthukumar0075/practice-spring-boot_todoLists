package com.muthu.dataStructur;

public class practiceEnums {
	
	public practiceEnums() {
		
	}
	enum Family{
		FATHER,
		MOTHER,
		CHILD;
		Family() {
			System.out.println(this);
		}
	}

	public static void main(String[] args) {
		Family fam = Family.FATHER;

	}

}
