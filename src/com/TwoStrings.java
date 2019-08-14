package com;

import java.io.IOException;
import java.util.Scanner;

public class TwoStrings {
	
	static String isContained(char[] stream, String str) {
		
		for (int i=0;i<stream.length;i++) {
			if(str.contains(""+stream[i])) {
				return "YES";
			}
		}
		return "NO";
	}
	
	static String twoStrings(String s1, String s2) {
		
		char[] stream;
		
		if(s1.length()<26 && s1.length() < s2.length()) {
			stream = new char[s1.length()];
			s1.getChars(0, s1.length(), stream, 0);
			return isContained(stream, s2);
		}else if(s2.length()<26 && s2.length() <= s1.length()){
			stream = new char[s2.length()];
			s2.getChars(0, s2.length(), stream, 0);
			return isContained(stream, s1);
		}
		else {
			stream = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			for (int i=0;i<26;i++) {
				if(s1.contains(""+stream[i]) && s2.contains(""+stream[i])) return "YES";
			}
			
			return "NO";
		}
		
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }


        scanner.close();
    }

	
/*
 * 
 Given two strings, determine if they share a common substring. A substring may be as small as one character.

For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.

Function Description

Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the strings share a common substring.

twoStrings has the following parameter(s):

s1, s2: two strings to analyze .
Input Format

The first line contains a single integer , the number of test cases.

The following  pairs of lines are as follows:

The first line contains string .
The second line contains string .
Constraints

 and  consist of characters in the range ascii[a-z].
Output Format

For each pair of strings, return YES or NO.

Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
 */
}
