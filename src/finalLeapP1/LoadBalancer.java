package finalLeapP1;

import java.util.*;

public class LoadBalancer {

	public static void main(String[] args) {
		LoadBalancer s = new LoadBalancer();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] arr = new int[] {1,1,1,1};
		int left = 0;
		int right = arr.length-1;
		if(arr.length < 5) return "FALSE";
		int totalSum = 0;
		for(int i:arr) {
			totalSum+=i;
		}
		int leftSum = arr[left], rightSum = arr[right];
		
		while(left+1<right-1) {
			if(leftSum == rightSum) {
				int midSum = totalSum - leftSum - rightSum - arr[left+1] - arr[right-1];
				if(midSum == rightSum) {
					return "TRUE";
				}
				else {
					left++;right--;
					leftSum+= arr[left];
					rightSum+=arr[right];
				}
			}
			else if(leftSum > rightSum) {
				right--;
				rightSum+=arr[right];
			}
			else {
				left++;
				leftSum+=arr[left];
			}
		}
		
		return "FALSE";
    }
	
}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 