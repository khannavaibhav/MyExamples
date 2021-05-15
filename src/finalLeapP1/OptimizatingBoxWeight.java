package finalLeapP1;

import java.util.Arrays;
import java.util.Collections;

public class OptimizatingBoxWeight {

	public static void main(String[] args) {
		OptimizatingBoxWeight sm = new OptimizatingBoxWeight();
//		int[][] b = {{4,  5,10,15,19,20,20},
//					 {4,  9,12,15,22,23,26},
//					 {7, 11,12,20,22,27,27},
//					 {10,14,17,23,27,30,32},
//					 {11,18,19,25,28,34,39}};
		
		int n = 6;
		Integer[] arr = new Integer[]{5, 3, 2, 4, 1, 2};
		
		//Arrays.sort(arr,Collections.reverseOrder());
		Arrays.sort(arr, Collections.reverseOrder());
		
		
		int[] c = new int[n];	
		c[0] = arr[0];
		for(int i=1;i<n;i++) {
			c[i] = c[i-1]+arr[i];
		}
		
		for(int i = 0;i<n;i++) {
			System.out.println(arr[i]);
			if(c[i] > c[n-1]-c[i]) break;
		}
	}
}
/*
An Amazon Fulfillment Associate has a set of items that need to be packed into two boxes. Given an integer array of the item weights (arr) to be packed, divide the item weights into two subsets, A and B, for packing into the associated boxes, while respecting the following conditions:
The intersection of A and B is null.
The union A and B is equal to the original array.
The number of elements in subset Ais minimal.
The sum of A's weights is greater than the sum of B's weights.
Return the subset A in increasing order where the sum of A's weights is greater than the sum of B's weights. If more than one subset A exists, return the one with the maximal total weight.

Input Format For Custom Testing
STDIN   Function
6 -> arr[] size n = 6
5 -> arr[] = [5, 3, 2, 4, 1, 2]
3
2
4
1
2

Sample Output
A[5,4]
*/
