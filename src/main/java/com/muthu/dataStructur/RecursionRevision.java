package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.List;

public class RecursionRevision {

	public static void main(String[] args) {
		System.out.println(subSet("", "abc"));
	}
	
	//Subset
	public static List<String> subSet(String p,String up){
		if(up.isEmpty()) {
			List<String>list = new ArrayList<>();
			list.add(p);
			return list;
		}
		List<String> take = subSet(p + up.substring(0,1), up.substring(1));
		List<String> notake = subSet(p, up.substring(1));
		take.addAll(notake);
		return take;
	}

}
