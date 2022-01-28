package Post.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class MaxAndMinElements {

	public static void main(String[] args) {
		MaxAndMinElements s = new MaxAndMinElements();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * Maximum and minimum of an array using minimum number of comparisons
	 * @return
	 * SOLN : Compare in pairs to minimize the number of comparisons
	 */
	public String solution() {
		int[] arr = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
       
        int swaps = 0;
        int max = 0;
        int min = 0;
        int i = 0;
        if(arr_size%2 == 0) {
        	if(arr[0]<arr[1]) {
        		min = arr[0];
        		max=arr[1];
        	}
        	else {
        		min = arr[1];
        		max=arr[0];
        	}
        	i=2;
        }
        else {
        	max=arr[0];
        	min = arr[0];
        	i=1;
        }
        
        while(i<arr_size) {
        	if(arr[i]>arr[i+1]) {
        		max=Math.max(max, arr[i]);
        		min=Math.min(min, arr[i+1]);
        	}
        	else {
        		max=Math.max(max, arr[i+1]);
        		min=Math.min(min, arr[i]);
        	}
        	i+=2;
        }
       
        
		return "END "+max + " "+min;
    }
	
	
}


/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 