package finalLeapP2;

import java.util.*;

public class LoadBalancer {

	public static void main(String[] args) {
		LoadBalancer s = new LoadBalancer();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] arr = new int[] {2, 4, 5, 3, 3, 9, 2, 2, 2};
		if(arr.length<5) return "FALSE";
		int left = 1; int right = arr.length-2;
		int leftSum = 0; int rightSum = 0;
		int totalSum = 0;
		
		for(int i:arr) {
			totalSum +=i;
		}
		
		while(left<right) {
			if(leftSum ==  rightSum) {
				int midSum = totalSum - (leftSum+rightSum+arr[left]+arr[right]);
				if(midSum == leftSum) return "TRUE";
				else {
					leftSum+=arr[left++];
				}
			}
			else if(leftSum<rightSum) {
				leftSum+=arr[left++];
			}
			else {
				rightSum+=arr[right--];
			}
		}
		
		
		return "FALSE";
    }
	
}
/*
Given an array containing only positive integers, return if you can pick two integers from the array which cuts the array into three pieces such that the sum of elements in all pieces is equal.

 

Example 1:

Input:  array = [1, 3, 4, 2, 2, 8, 1, 1, 1]

Output: true

Explanation: choosing the number 4 and 8 results in three pieces [1, 3], [2, 2] and [1, 1, 1]. Sum = 4.

 

Example 2:

Input:  array =[1, 1, 1, 1],

Output: false

https://aonecode.com/amazon-online-assessment-load-balancer

 * */
 