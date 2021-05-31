package finalLeapP3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class AlgorithmSwap {

	public static void main(String[] args) {
		AlgorithmSwap s = new AlgorithmSwap();
		
		System.out.println(s.solution().toString());
	}
	int swaps = 0;
	public String solution() {
		int[] arr = new int[] {1,20,6,7,5,8,11,3};
		
		partitionAndMerge(arr, 0, arr.length-1);

		for(int i:arr) {
			System.out.print(i);
		}
		
		return "END " + swaps ;
	}
	
	void partitionAndMerge(int[] a,int start,int end) {
		if(start>=end) return;
		int mid = start+(end-start)/2;
		partitionAndMerge(a,start,mid);
		partitionAndMerge(a,mid+1,end);
		mergeAndSort(a, start, mid, end);
		
	}
	
	void mergeAndSort(int[] a,int start,int mid,int end) {
		int i = start;
		int j = mid+1;
		int k = start;
		int[] tmp = new int[a.length];
		
		while(i<=mid && j<=end) {
			if(a[i] > a[j]) {
				swaps +=mid+1-i;
				tmp[k++] = a[j++];
			}
			else {
				tmp[k++] = a[i++];
			}
		}
		while(i<=mid) {
			tmp[k++] = a[i++];
		}
		while(j<=end) {
			tmp[k++] = a[j++];
		}
		
		for(i=start;i<=end;i++) {
			a[i] = tmp[i];
		}
	}

	public String bruteForce() {
		int[] arr = new int[] {9,6,8,4};
		
		int swaps = 0;
		for(int i = 0 ;i<arr.length-1;i++) {
			for(int j = i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					swaps++;
//					int tmp =arr[i];
//					arr[i] = arr[j];
//					arr[j] = tmp;
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
 