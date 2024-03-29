package finalLeapP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptimizatingBoxWeight {

	public static void main(String[] args) {
		OptimizatingBoxWeight sm = new OptimizatingBoxWeight();
		
		int n = 6;
		Integer[] arr = new Integer[]{5, 3, 2, 4, 1, 2};
		//Integer[] arr = new Integer[]{1, 1, 2, 4, 4, 5};
		
		Arrays.sort(arr, Collections.reverseOrder());
		int sum = 0;
		for(int x:arr) {
			sum+=x;
		}
		int k = sum/2;
		int curr = 0;
		int id = -1;
		List<Integer> res = new ArrayList<>();
		for(int i = 0;i<arr.length;i++) {
			if(id == -1) {
				curr+=arr[i];
				res.add(0,arr[i]);
				if(curr > k) {
					id = i;
				}
			}
			else if(arr[i]==arr[id]) {
				res.add(0,arr[i]);
			}
			else {
				break;
			}
		}
		System.out.println(res);
	}
}
/*
An Amazon Fulfillment Associate has a set of items that need to be packed into two boxes. Given an integer 
array of the item weights (arr) to be packed, divide the item weights into two subsets, A and B, 
for packing into the associated boxes, while respecting the following conditions:
The intersection of A and B is null.
The union A and B is equal to the original array.
The number of elements in subset A is minimal.
The sum of A's weights is greater than the sum of B's weights.
Return the subset A in increasing order where the sum of A's weights is greater than the sum of B's weights. 
If more than one subset A exists, return the one with the maximal total weight.

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
