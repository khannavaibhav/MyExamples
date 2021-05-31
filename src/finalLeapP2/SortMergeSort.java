package finalLeapP2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class SortMergeSort {
	static int invCount = 0;
	public static void main(String[] args) {
		SortMergeSort s = new SortMergeSort();
		
		int[] arr = new int[] {1,20,6,7,5,8,11,3};
		s.mergeSort(arr,0,arr.length-1);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\r\n" + invCount);
	}

	public void mergeSort(int[] arr,int srt,int end) {
		if(srt>=end) return;
		int mid = srt + (end-srt)/2;
		mergeSort(arr,srt,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,srt,mid,end);
    }
	
	public void merge(int[] arr, int srt, int mid, int end) {
		
		int i = srt, j = mid+1, k = srt;
		int[] tmp = new int[arr.length];
		while(i<=mid && j<=end) {
			
			if(arr[i] > arr[j]) {
				invCount += mid+1-i;
				tmp[k++] = arr[j++];
			}
			else {
				tmp[k++] = arr[i++];
			}
		}
		if(i>mid) while(j<=end) {
			tmp[k++] = arr[j++];
		}
		else while(i<=mid) {
			tmp[k++] = arr[i++];
		}
		
		for(k = srt;k<=end;k++) {
			arr[k] = tmp[k];
		}
	}
	
}


/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 