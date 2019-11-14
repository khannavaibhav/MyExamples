package com;

import java.io.IOException;

public class MakingAnagrams {
	 // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

    	int[] freqA = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    	int[] freqB = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    	
    	char[] chA = new char[a.length()];
		a.getChars(0, a.length(), chA, 0);
		
		char[] chB = new char[b.length()];
		b.getChars(0, b.length(), chB, 0);
		
		int d = 'a';
		int res = 0;
		for(char c:chA){
			freqA[c - d] = freqA[c - d] +1;
		}
		
		for(char c:chB){
			freqB[c - d] = freqB[c - d] + 1;
		}
		int index = 0;
		for(int i:freqA){
			int val = i - freqB[index];
			if(val<0) val = val*-1;
			res+=val;
			index ++;
		}

    	return res;
    }


    public static void main(String[] args) throws IOException {

        String a = "fcrxzwscanmligyxyvym";

        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        int res = makeAnagram(a, b);

        System.out.println(res);

    }
    
    /*
     *
     Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

For example, if  and , we can delete  from string  and  from string  so that both remaining strings are  and  which are anagrams.

Function Description

Complete the makeAnagram function in the editor below. It must return an integer representing the minimum total characters that must be deleted to make the strings anagrams.

makeAnagram has the following parameter(s):

a: a string
b: a string
Input Format

The first line contains a single string, .
The second line contains a single string, .

Constraints

The strings  and  consist of lowercase English alphabetic letters ascii[a-z].
Output Format

Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

Sample Input

cde
abc
Sample Output

4
Explanation

We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.
     
     
     * */
}
