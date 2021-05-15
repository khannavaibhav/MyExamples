package finalLeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Substrings {

//		Input: s = "abcabc", k = 3
//			Output: ["abc", "bca", "cab"]
//			Example 2:
//
//			Input: s = "abacab", k = 3
//			Output: ["bac", "cab"]
//			Example 3:
//
//			Input: s = "awaglknagawunagwkwagl", k = 4
//			Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
//			Explanation: 
//			Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" 
//			"wagl" is repeated twice, but is included in the output once.
	
	public static void main(String[] args) {
		Substrings s1 = new Substrings();
		System.out.println(s1.noOfSubstrings("awaglknagawunagwkwagl", 4));
	}
	
	public List<String> noOfSubstrings(String s, int k) {
		HashSet<String> res = new HashSet<String>();
		Set<Character> unq = new HashSet<Character>();
		int i = 0;
		while(i<=s.length()-k) {
			String ss = s.substring(i,k+i);
			int id = 0;
			unq = new HashSet<Character>();
			while(id<k) {
				
				unq.add(ss.charAt(id));
				id++;
			}
			if(unq.size() == k) {
				res.add(ss);
			}
			i++;
		}
		
		
		return new ArrayList<String>(res);
    }
}
