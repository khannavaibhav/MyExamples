package finalLeapP3;

import java.util.*;

public class LoadBalancer {

	public static void main(String[] args) {
		LoadBalancer s = new LoadBalancer();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] arr = new int[] {1, 3, 4, 2, 2, 8, 1, 1, 1,1};
		
		if(arr.length==2) return "TRUE";
		if(arr.length<5) return "FALSE";
		//Total sum
		int total = 0;
		for(int k:arr)  total +=k; 
		
		int l = 1;
		int r = arr.length -2;
		int left = arr[l-1];
		int right = arr[r+1];
		
		while(l<r) {
			if(left==right) {
				int mid = total - (left + right + arr[l] + arr[r]);
				if(mid==left) return "TRUE";
			}
			if(left<right) left+=arr[l++];
			else right+=arr[r--];
		}
		return "FALSE";
    }
	
}
/*
Given an array containing only positive integers, return if you can pick two integers from the array 
which cuts the array into three pieces such that the sum of elements in all pieces is equal.

 

Example 1:

Input:  array = [1, 3, 4, 2, 2, 8, 1, 1, 1]

Output: true

Explanation: choosing the number 4 and 8 results in three pieces [1, 3], [2, 2] and [1, 1, 1]. Sum = 4.

 

Example 2:

Input:  array =[1, 1, 1, 1],

Output: false

https://aonecode.com/amazon-online-assessment-load-balancer
 * */
 