package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxIdDifference {

	public static void main(String[] args) {
		MaxIdDifference s = new MaxIdDifference();
//		int n = 9;
//	    ArrayList<Integer> arr = new ArrayList<Integer>(
//	        Arrays.asList(34, 8, 10, 3, 2, 80, 30, 40, 1));
	         
	    // Function Call
        int arr[] = { 34, 8, 10, 3, 2, 80, 30, 32, 1 };
        int n = arr.length;
        int maxDiff = s.maxIndexDiff(arr, n);
        System.out.println(maxDiff);
	     
//	    System.out.println("The maxIndexDiff is : " + ans);
		//System.out.println(s.solution().toString());
	}

	// Function to find maximum
	// index difference
	     
	/* Utility Functions to get max and minimum of two integers */
    int max(int x, int y)
    {
        return x > y ? x : y;
    }
 
    int min(int x, int y)
    {
        return x < y ? x : y;
    }
 
    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;
 
        int RMax[] = new int[n];
        int LMin[] = new int[n];
 
        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);
 
        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);
 
        
        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0;
        j = n-1;
        maxDiff = -1;
        while (j < n && i < n && maxDiff< j - i) {
            if (LMin[i] < RMax[j]) {
                maxDiff = max(maxDiff, j - i);
                j=n-1;
                i++;
            }
            else
                j--;
        }
 
        return maxDiff;
	}
	
}


/*

 * */
 