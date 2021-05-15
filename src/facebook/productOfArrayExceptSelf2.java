package facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class productOfArrayExceptSelf2 {

	public static void main(String[] args) {
		productOfArrayExceptSelf2 s = new productOfArrayExceptSelf2();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		
		int[] arr = new int[] {1,2,3,4};
		int[] res = new int[arr.length];

		Arrays.fill(res, 1);
		int mulL = 1;
		int mulR = 1;
		for(int i = 1;i<arr.length;i++) {
			mulL = mulL*arr[i-1];
			res[i] = res[i]*mulL;
			mulR = mulR*arr[arr.length-i];
			res[(arr.length-i)-1] =res[(arr.length-i)-1]*mulR;
		}
		for(int i = 0;i<res.length;i++) {
			System.out.println(res[i]);
		}
		
		return "END";
    }
	public String solution1() {
		
		int[] arr = new int[] {1,2,3,4};
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		for(int i = 1;i<arr.length;i++) {
			left[i] = left[i-1]*arr[i-1];
			right[(arr.length-i)-1] =right[(arr.length-i)]*arr[(arr.length-i)];
		}
		for(int i = 0;i<arr.length;i++) {
			left[i] = left[i]*right[i];
			System.out.println(left[i]);
		}
		
		return "END";
    }
	
}


/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 