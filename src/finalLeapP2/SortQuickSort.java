package finalLeapP2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class SortQuickSort {
	static int invCount = 0;
	public static void main(String[] args) {
		SortQuickSort s = new SortQuickSort();
		
		int[] arr = new int[] {9,6,4,8};
		s.quickSort(arr,0,arr.length-1);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\r\n" + invCount);
	}

	public int partition(int[] arr,int srt,int end) {
		if(srt>=end) return srt;
		int pivot = arr[srt];
		int left = srt+1, right = end;
		while(left<right) {
			while(left<right && arr[left]<=pivot) left++;
			while(left<right && arr[right]>pivot) right--;
			if(left<end) {
				//SWAP
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
		}
		//SWAP PIVOT
		int tmp = arr[srt];
		arr[srt] = arr[left];
		arr[left] = tmp;
		return left;
    }
	
	void quickSort(int[] arr,int srt,int end) {
		if(srt>=end) return;
		int loc = partition(arr, srt, end);
		quickSort(arr, srt, loc-1);
		quickSort(arr, loc, end);
	}
	
	
}


/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 