package com.muthu.dataStructur;

public class RecursionPart2 {

	public static void main(String[] args) {
		String name = "muappukumarapple";
		System.out.println(removeApple(name, new StringBuffer(), 0));

	}
	
	public static String removeA(String og, StringBuffer modified,int currentItr) {
		if(currentItr == og.length()) {
			return modified.toString();
		}
		else if (og.charAt(currentItr) == 'a' || og.charAt(currentItr) == 'A') {
			return removeA(og, modified, currentItr + 1);
		}
		else {
			modified.append(og.charAt(currentItr));
			return removeA(og, modified, currentItr + 1);
		}
	}
	public static String removeApple(String og, StringBuffer modified,int currentItr) {
		if(currentItr == og.length()) {
			return modified.toString();
		}
		else if(((currentItr +"apple".length()) <= og.length()) && 
				(!og.subSequence(currentItr, currentItr + "apple".length()).equals("apple")) &&
				(og.subSequence(currentItr, currentItr + "app".length()).equals("app"))
				){
			return removeApple(og, modified, currentItr + "app".length());
		}
		else if(((currentItr +"app".length()) <= og.length()) && og.subSequence(currentItr, currentItr + "app".length()).equals("app")) {
			return removeApple(og, modified, currentItr + "app".length());
		}
		else {
			modified.append(og.charAt(currentItr));
			return removeApple(og, modified, currentItr + 1);
		}
	}

}
