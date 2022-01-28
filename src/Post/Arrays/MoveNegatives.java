package Post.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class MoveNegatives {

	public static void main(String[] args) {
		MoveNegatives s = new MoveNegatives();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * Move all negative numbers to beginning and positive to end with constant extra space 
	 * @return
	 */
	public String solution() {
		
		int[] arr = {-12, -13, -5,  -7,  -3, -6};
        int pindex = 0;
        int j = 0, temp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        for(int i=0;i<arr.length;i++) {
        	System.out.println(arr[i]);
        }
		return "END";
    }
	
}


/*

 * */
 