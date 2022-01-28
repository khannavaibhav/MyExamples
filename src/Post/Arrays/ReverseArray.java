package Post.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class ReverseArray {

	public static void main(String[] args) {
		ReverseArray s = new ReverseArray();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * Reverse an array
	 * @return
	 */
	public String solution() {
		
		int[] a = new int[] {4, 5, 1, 2};
		int l=0;
		int r=a.length-1;
		
		while(l<r) {
			int t =a[l];
			a[l] = a[r];
			a[r] = t;
			l++;
			r--;
		}
		
		for(int i:a) {
			System.out.println(i);
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
 