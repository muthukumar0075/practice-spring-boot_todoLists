package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.List;

public class MOsAlgorithm<T extends Integer> {

	private List<T> initialArr;
	private List<T> compressedArr;
	public MOsAlgorithm(List<T> arr) {
		this.initialArr = arr;
		this.compressedArr = new ArrayList<>();
		doTheCompression();
	}
	
	private void doTheCompression() {
		int rootLength = (int) Math.sqrt(initialArr.size());
		Integer sum = 0;
		int count = 0;
		for(T value : initialArr) {
			if(count == rootLength) {
				this.compressedArr.add((T) sum);
				sum = 0;
				count = 0;
			}
			sum = (T) sum + value;
			count++;
		}
		if(sum != 0) {
			this.compressedArr.add((T) sum);
		}
	}
	
	public void doSum(int left,int right) {
		int rootLength = (int) Math.sqrt(initialArr.size());
		int sum = 0;
		while(left <= right) {
			if(left % rootLength == 0) {
				if(left + rootLength < right) {
					sum += this.compressedArr.get(left / rootLength);
					left += rootLength;
					continue;
				}
				else {
					sum += this.initialArr.get(left);
				}
			}
			else {
				sum += this.initialArr.get(left);
			}
			left++;
		}
		System.out.println(sum);
		
	}
	
	public void doPrint() {
		this.compressedArr.stream().forEach(System.out::println);
	}
}
