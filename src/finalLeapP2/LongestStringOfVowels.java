package finalLeapP2;

import java.util.*;

public class LongestStringOfVowels {

	public static void main(String[] args) {
		LongestStringOfVowels s = new LongestStringOfVowels();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		//3:35 - 3:53
		String input = "b";
		int left = 0, right = input.length()-1;
		int total = 0;
		while(left <= right && isVowel(input.charAt(left))) {
			left++;
			total++;
		}
		while(left <= right && isVowel(input.charAt(right))) {
			right--;
			total++;
		}
		int max = 0, curr = 0;
		while(left <= right) {
			if(isVowel(input.charAt(left++))){
				curr++;
				if(curr>max) max = curr;
			}
			else curr=0;
		}
		
		return "END   " + (total+max);
    }
	
	boolean isVowel(char c) {
		return (c == 'a' || c=='e' || c=='i' || c=='o' || c=='u' ) ;
	}
	
}
/*
Given a string of lower charasters, remove at most two substrings of any length from the given string such that the remaining string contains vowels('a','e','i','o','u') only.

Your aim is to maximise the length of the remaining string. Output the length of remaining string after removal of at most two substrings.

NOTE: The answer may be 0, i.e. removing the entire string.
Example1:
Input:
earthproblem
Output:
2
Example2:
Input:
letsgosomewhere
Output:
3
 * */
 