package com.muthu.dataStructur;

public class KarprabinAlgor {
	// larger the prime number value lesser the collusion.
	private int primeNumber = 101;
	
	public int searchForString(String target,String givenString) {
		int targetHashedValue = doHashing(target);
		int startIndex = findTarget(targetHashedValue,givenString,target);
		return startIndex;
	}
	
	private int doHashing(String target) {
		int hash = 0;
		for(int i = 0;i <  target.length();i++) {
			hash+=target.charAt(i)*Math.pow(256,(target.length() - 1) - i );
		}
		return hash % primeNumber;
	}
	
	private int withoutModlue(String value) {
		int hash = 0;
		for(int i = 0;i <  value.length();i++) {
			hash+=value.charAt(i)*Math.pow(256,(value.length() - 1) - i );
		}
		return hash;
	}
	
	private int findTarget(int hashValue,String given,String target) {
		int prevHashedValue = 0;
		int unModuledValue = 0;
		int d = (int) Math.pow(256,target.length()-1);
		for(int i = 0;i <= given.length() - target.length();i++) {
			if(i == 0) {
				unModuledValue = withoutModlue(given.substring(i, i+target.length()));
				prevHashedValue = unModuledValue % primeNumber;
				if(prevHashedValue == hashValue) {
					return i;
				}
			}else {
				unModuledValue = (unModuledValue - (given.charAt(i - 1) * d))  * 256 + given.charAt(i+(target.length()-1));
				prevHashedValue = Math.abs(unModuledValue % primeNumber);
				if(prevHashedValue == hashValue) {
					return i;
				}
				
			}
		}
		return - 1;
	}

}
