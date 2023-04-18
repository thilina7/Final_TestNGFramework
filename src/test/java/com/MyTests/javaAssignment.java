package com.MyTests;

import java.util.HashMap;

public class javaAssignment {

	public static void main(String[] args) {
		
		String str = "This this is is done by Java Java";
		String [] ary = str.split(" ");
		int count =0;
		HashMap<String, Integer> hashMap=new HashMap<>();
		for(String stringVal: ary) {
			if(stringVal.equals(hashMap.get(stringVal))) {
			count = count +1;
			hashMap.put(stringVal, count);
			}
			else {
				count = 0 ;
				count = count+1;
				hashMap.put(stringVal, count);
				
			}
			
		}
		System.out.println(hashMap);
		
		
		
//		int count = 0 ;
//		for(int i=0;i<ary.length;i++) {
//			count =0;
//			for(int j=1;j<ary.length;j++) {
//				if(ary[i].equalsIgnoreCase(ary[j])) {
//					count = count +1;	
//				}
//			}
//			System.out.println(ary[i]+" = "+ count);
//		}
	}
	
}
