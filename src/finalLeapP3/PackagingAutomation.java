package finalLeapP3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class PackagingAutomation {

	public static void main(String[] args) {
		PackagingAutomation s = new PackagingAutomation();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		
		int[] a = {3,2,3,5};
		
		Arrays.sort(a);
		
		for(int i =0;i<a.length;i++) {
			int prev = i==0?1:a[i-1]+1;
			a[i] = Math.min(prev, a[i]);
		}
		
		return "END " + a[a.length-1];
    }
}


/*
 * 
 Packaging bay where orders are automatically packaged in groups.
 First group can have 1 item 
 subsequent groups can have 1 more than prev group  > 1<=i<n, arr[i]-arr[i-1]<=1;
 
 Rearrange in any way, reduce any group to any number that is atleast 1
 
 Find max items that can be packaged in last group
 
 Example 1
 [3,1,3,4]  >> [1,2,3,4] > max = 4
 
 Example 2:
 [1,3,2,2]  >> [1,2,2,3] > max = 3
 
 https://www.youtube.com/watch?v=rRtK_U-bTpM

 * */
 