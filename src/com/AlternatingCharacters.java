package com;

import java.io.IOException;

public class AlternatingCharacters {

	// Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	
    	char[] c = new char[s.length()];
    	s.getChars(0, s.length(), c, 0);
    	int res = 0;

    	for(int i = 0; i<c.length-1; i++){
    		
    		if(c[i]==c[i+1]) res++;
    	}
    	
    	return res;
    }


    public static void main(String[] args) throws IOException {

        String[] q = new String[]{"AAAA",
        		"BBBBB",
        		"ABABABAB",
        		"BABABA",
        		"AAABBB"};


        for (int qItr = 0; qItr < q.length; qItr++) {
        	String s = "";
            int result = alternatingCharacters(q[qItr]);
            System.out.println(result);

        }


    }
	
	/*
	 
	 You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, given the string , remove an  at positions  and  to make  in  deletions.

Function Description

Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of deletions to make the alternating string.

alternatingCharacters has the following parameter(s):

s: a string
Input Format

The first line contains an integer , the number of queries.
The next  lines each contain a string .

Constraints

Each string  will consist only of characters  and 
Output Format

For each query, print the minimum number of deletions required on a new line.

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
	 
	 * */
}
