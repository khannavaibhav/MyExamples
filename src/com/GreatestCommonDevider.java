package com;

public class GreatestCommonDevider {

	public static void main(String[] a){
		int res = GCD(new int[]{12,20});
		System.out.println("RES: "+res);
		
	}
	
	static int GCD(int[] arr){
		int result = arr[0]; 
        for (int i = 1; i < arr.length; i++) 
            result = gcdByEuclidsAlgorithm(arr[i], result); 
  
        return result; 
	}
	
	static int gcdByEuclidsAlgorithm(int n1, int n2) {
	    if (n2 == 0) {
	        return n1;
	    }
	    return gcdByEuclidsAlgorithm(n2, n1 % n2);
	}
}
