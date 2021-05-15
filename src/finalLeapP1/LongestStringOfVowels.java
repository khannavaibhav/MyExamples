package finalLeapP1;

import java.util.*;

public class LongestStringOfVowels {

	public static void main(String[] args) {
		LongestStringOfVowels s = new LongestStringOfVowels();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		//4:10
		String input = "output";
		int front = 0;
		int end = 0;
		
		int curr = 0;
		int max = 0;
		int left = 0; int right = input.length()-1;
		boolean st = true, en = true;
		if(input.length() == 0) return "0";

		while(st && left<=right) {
			char ch=input.charAt(left++);
			if(!(ch == 'a' || ch=='e' || ch == 'i' || ch=='o' || ch == 'u')) {
				st = false;
			}
			else {
				front++;
			}
		}
		while(en && right>=left) {
			char ch=input.charAt(right--);
			if(!(ch == 'a' || ch=='e' || ch == 'i' || ch=='o' || ch == 'u')) {
				en = false;
			}
			else {
				end++;
			}
		}
		while(left<=right) {
			char ch=input.charAt(left++);
			if(ch == 'a' || ch=='e' || ch == 'i' || ch=='o' || ch == 'u') {
				curr++;
				if(curr>max) max = curr;
			}
			else {
				curr=0;
			}
		}
		System.out.println(front + " "+end + " "+max);
		return "END   " + (front+end+max);
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
 