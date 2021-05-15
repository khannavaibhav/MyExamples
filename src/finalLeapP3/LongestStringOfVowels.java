package finalLeapP3;

import java.util.*;

public class LongestStringOfVowels {

	public static void main(String[] args) {
		LongestStringOfVowels s = new LongestStringOfVowels();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		//3:35 - 3:53
		String input = "letsgosomewhere";
		int total = 0;
		int l = 0;
		int r = input.length()-1;
		while(l<r && isVowel(input.charAt(l))) {
			total++;
			l++;
		}
		while(r>l && isVowel(input.charAt(r))) {
			total++;
			r--;
		}
		int max = 0;
		while(l<=r) {
			int count = 0;
			if(isVowel(input.charAt(l))) {
				count++;
				if(count > max) max =  count;
			}
			else count=0;
			l++;
		}
		
		return "END   "+(total+max);
    }
	
	boolean isVowel(char c) {
		return (c == 'a' || c=='e' || c=='i' || c=='o' || c=='u' ) ;
	}
	
}
/*
Given a string of lower charasters, remove at most two substrings of any length from the given string such that
 the remaining string contains vowels('a','e','i','o','u') only.

Your aim is to maximise the length of the remaining string. Output the length of remaining string after removal
 of at most two substrings.

NOTE: The answer may be 0, i.e. removing the entire string.
Example1:
Input:
earthproblem
Output:
3
Example2:
Input:
letsgosomewhere
Output:
2
 * */
 