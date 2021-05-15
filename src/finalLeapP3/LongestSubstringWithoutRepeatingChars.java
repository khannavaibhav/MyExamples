package finalLeapP3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingChars s = new LongestSubstringWithoutRepeatingChars();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		
		String s = "dddd";
		
		boolean[] visited = new boolean[26];
		String max = "";
		int left = 0; int right = 0;
		while(right<s.length()) {
			
			if(visited[s.charAt(right) - 'a']) {
				String r = s.substring(left,right);
				System.out.println(r);
				if(max.length()<r.length()) {
					max = r;
				}
				while(left<s.length() && visited[s.charAt(right) - 'a']) {
					visited[s.charAt(left++)  - 'a'] = false;
				}
			}
			visited[s.charAt(right++) - 'a'] = true;
			
		}
		String r = s.substring(left,right);
		System.out.println(r);
		if(max.length()<r.length()) {
			max = r;
		}
		return "END " + max;
    }
	
}


/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 