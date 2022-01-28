package Post.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class MinimizeTheHeights {

	public static void main(String[] args) {
		MinimizeTheHeights s = new MinimizeTheHeights();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		int[] arr = new int[] {6, 1, 9, 1, 1, 7, 9, 5, 2,10};
		int n =arr.length;
		int k = 4;
		
		int min = arr[0]+k;
        int max = arr[0]-k;
        Arrays.sort(arr);
        
        for(int i = 0;i<n;i++){
            if(arr[i]-k < 0){
                min = Math.min(min,arr[i]+k);
                max = Math.max(max,arr[i]+k);
                arr[i] = arr[i]+k;
            }
            else if((arr[i]+k - min) < (max - (arr[i]-k))){
                max = Math.max(max,arr[i]+k);
                arr[i] = arr[i]+k;
            }
            else{
                min = Math.min(min,arr[i]-k);
                arr[i] = arr[i]-k;
            }
        }
        Arrays.sort(arr);

		return "END " + (arr[n-1]-arr[0]);
    }
	
}


/*

 * */
 