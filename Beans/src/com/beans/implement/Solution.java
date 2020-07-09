package com.beans.implement;

public class Solution {
	static Long l;
	 static int divide(int dividend, int divisor) { 
		
	
		if(dividend == Integer.MIN_VALUE) 
			dividend = Integer.MAX_VALUE + 1;
			l = Long.valueOf(dividend);
		
	        int sign = ((l < 0) ^  (divisor < 0)) ? -1 : 1; 
	       
	        l = Math.abs(l); 
	       
	        divisor = Math.abs(divisor); 
	        int quotient = 0; 
	        int ans = 0;
	        while (l >= divisor){ 
	            l -= divisor; 
	            ++quotient; 
	        } 
	        for(int i=0;i<quotient;i++){
                ans=ans+sign;       
		}
		return 0;
	 }
	    public static void main (String[] args)  { 	
	        int a = -2147483648; 
	        int b = -1; 
	          
	        System.out.println(divide(a, b)); 
	    } 
	} 

	  