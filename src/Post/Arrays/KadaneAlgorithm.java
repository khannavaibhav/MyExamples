package Post.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class KadaneAlgorithm {

	public static void main(String[] args) {
		KadaneAlgorithm s = new KadaneAlgorithm();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		
		int[] arr = new int[] {1,2,3,-2,5};
		int n = arr.length;
		int max = Integer.MIN_VALUE;
        int cum = 0;
        for(int i = 0;i<n;i++){
            cum = Math.max(cum+arr[i], arr[i]);
            max = Math.max(max,cum);
        }
		return "END "+max;
    }
	
}


/*

 * */
 