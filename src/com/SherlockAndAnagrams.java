package com;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndAnagrams {

	   static int sherlockAndAnagrams(String s) {
		   char[] str = new char[s.length()];
		   s.getChars(0, s.length(), str, 0);
		   int anagrams = 0;
		   /*int[] counts = new int[123];
		   for(char c:str) {
			   counts[c]+=1;
		   }
		   for()*/
		   
		   char[] subStr1;
		   char[] subStr2;
		   for(int len = 1; len<str.length;len++) {
			   for (int i = 0; i<str.length - len; i++ ) {
				   subStr1 =  new char[len];
				   s.getChars(i, i+len, subStr1, 0);
				   Arrays.sort(subStr1);
				   String st1 = Arrays.toString(subStr1);
				   for (int j = i+1; j<=str.length - len; j++ ) {
					   subStr2 = new char[len];
					   s.getChars(j, j+len, subStr2, 0);
					   Arrays.sort(subStr2);
					   String st2 = Arrays.toString(subStr2);
					   if(st1.equals(st2)) anagrams++;
				   }
			   }
		   }
		   
		   
		   return anagrams;
		   
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {

	        int q = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int qItr = 0; qItr < q; qItr++) {
	            String s = scanner.nextLine();

	            int result = sherlockAndAnagrams(s);

	            System.out.println(String.valueOf(result));
	        }


	        scanner.close();
	    }
	
	
	/*
	 Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example , the list of all anagrammatic pairs is  at positions  respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

sherlockAndAnagrams has the following parameter(s):

s: a string .
Input Format

The first line contains an integer , the number of queries. 
Each of the next  lines contains a string  to analyze.

Constraints

 
 
String  contains only lowercase letters  ascii[a-z].

Output Format

For each query, return the number of unordered anagrammatic pairs.

Sample Input 0

2
abba
abcd
Sample Output 0

4
0
Explanation 0

The list of all anagrammatic pairs is  and  at positions  and  respectively.

No anagrammatic pairs exist in the second query as no character repeats.

Sample Input 1

2
ifailuhkqq
kkkk
Sample Output 1

3
10
Explanation 1

For the first query, we have anagram pairs  and  at positions  and respectively.

For the second query: 
There are 6 anagrams of the form  at positions  and . 
There are 3 anagrams of the form  at positions  and . 
There is 1 anagram of the form  at position .

Sample Input 2

1
cdcd
Sample Output 2

5
Explanation 2

There are two anagrammatic pairs of length :  and . 
There are three anagrammatic pairs of length :  at positions respectively
	 
	 * */
}
