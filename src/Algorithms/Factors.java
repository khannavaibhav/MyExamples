package Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Factors {
	public static void main(String args[]) {
		int a = 10;
		System.out.println(Math.floor(a/2));
    }
	
	boolean canGetExactChange(int targetMoney, int[] denominations) {
	    // Write your code here
	    int count = 0;
	   
	    int t = targetMoney;
	    
	    while(t>0){
	      while(denominations[count] > t && count < denominations.length-1) count++;
	      int rem = t%denominations[count];
	      if(rem == 0) return true;
	      int r = t/denominations[count];
	      if(r == 0) break;
	      t -=  r*denominations[count];
	    }
	    return false;
	    
	    
	  }
	
}
