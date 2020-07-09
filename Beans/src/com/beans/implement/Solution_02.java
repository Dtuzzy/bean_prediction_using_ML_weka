package com.beans.implement;

import java.util.Vector;

public class Solution_02 {
	String [] alph = {"abc","def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public void comb(String num) {
		 // create default vector 
		int j;
		 Vector v = new Vector();
		for(int i = 0; i < num.length(); i++) {
		    j = Character.digit(num.charAt(i), 10);
		 		  String str = alph[j];
		 		 v.add(i, str);
		  System.out.println(v);
		}
		
	}

	public static void main(String[] args) {
		new Solution_02().comb("12");
	}

}
