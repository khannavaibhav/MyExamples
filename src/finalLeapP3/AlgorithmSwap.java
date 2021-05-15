package finalLeapP3;

import java.util.*;

public class AlgorithmSwap {

	public static void main(String[] args) {
		AlgorithmSwap s = new AlgorithmSwap();
		
		System.out.println(s.solution().toString());
	}

	public String solution() {
		int[] arr = new int[] {8, 2, 3};
		
		int swaps = 0;
		for(int i = 0 ;i<arr.length-1;i++) {
			for(int j = i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					swaps++;
					int tmp =arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		
		return "END " + swaps ;
    }
	
}
/*
Given an array and a sorting algorithm, the sorting algorithm will do a selection swap. Find the number of swaps to sort the array.

For example the initical array is [5, 4, 1, 2], this is how the sorting algorithm works:
Swap index 0 with 1 to form the sorted array [4, 5, 1, 2].
Swap index 0 with 2 to form the sorted array [1, 5, 4, 2].
Swap index 1 with 2 to form the sorted array [1, 4, 5, 2].
Swap index 1 with 3 to form the sorted array [1, 2, 5, 4].
Swap index 2 with 3 to form the sorted array [1, 2, 4, 5].

Constraints
1 <= n <= 10^5
1 <= arr[i] <= 10^9
all elements of arr are unique


Example:
arr = [8, 2, 3]
return 2
explanation:
Swap a[0] and a[1]. The resulting array is [2, 8, 3].
Swap a[1] and a[2]. The resulting array is [2, 3, 8].
Return the number of swaps which is 2.


 * */
 