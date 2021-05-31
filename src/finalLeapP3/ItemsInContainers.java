package finalLeapP3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ItemsInContainers {

	public static void main(String[] args) {
		ItemsInContainers s = new ItemsInContainers();
		System.out.println(s.containerCounts().toString());
	}

	public String containerCounts() {
		
		String s = "|**|*|*";
		int[] startIndices = new int[] {1,1};
		int[] endIndices = new int[] {5,6};
		List<Integer> counts = new ArrayList<>();
		for(int i =0;i<startIndices.length;i++) {
			counts.add(countItems(s,startIndices[i]-1,endIndices[i]-1));
		}
		
		return "END"+counts;
	}
	
	int countItems(String s,int start, int end) {
		int count = 0;
		int curr = 0;
		boolean flag = false;
		for(int i = start;i<=end;i++) {
			
			if(s.charAt(i)=='|') {
				if(flag) count+=curr;
				curr=0;
				flag = true;
			}
			else {
				curr++;
			}
		}
		return count;
	}
	
}
/*
A company would like to know how much inventory exists in their closed inventory compartments. Given a string s
consisting of items as "*" and closed compartments as an open and close "|", an array of starting indices startIndices, and an array of ending indices endIndices, determine the number of items in closed compartments within the substring between the two indices, inclusive.
An item is represented as an asterisk ('*' = ascii decimal 42)
A compartment is represented as a pair of pipes that may or may not have items between them ('|' = ascii decimal 124). 
Example
s = '|**|*|*'
startIndices = [1, 1]
endIndices = [5, 6]
The string has a total of 2 closed compartments, one with 2 items and one with 1 item. For the first pair of indices, (1, 5), the substring is '|**|*'. There are 2 items in a compartment.
For the second pair of indices, (1, 6), the substring is '|**|*|' and there are 2 + 1 = 3 items in compartments.
Both of the answers are returned in an array, [2, 3].
Function Description
Complete the numberOfItems function in the editor below. The function must return an integer array that contains the results for each of the startIndices[i] and endIndices[i] pairs.
numberOfItems has three parameters:
s: A string to evaluate
startIndices: An integer array, the starting indices.
endIndices: An integer array, the ending indices. 
Constraints
1 ≤ m, n ≤ 10^5
1 ≤ startIndices[i] ≤ endIndices[i] ≤ n
Each character of s is either '*' or '|'
Input Format For Custom Testing
 The first line contains a string, s.
The next line contains an integer, n, the number of elements in startIndices.
Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, startIndices[i].
The next line repeats the integer, n, the number of elements in endIndices.
Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, endIndices[i].
Sample Case 0
STDIN
 
Function
*|*|
 
s = "*|*|"
 1
 
startIndices[] size n = 1
 1
 
startIndices = 1
 1
 
endIndices[] size n = 1
 3
 
endIndices = 3 

Sample Output
0 
Explanation
s = '*|*|'
n = 1
startIndices = [1]
n = 1
startIndices = [3]
The substring from index = 1 to index = 3 is '|'. There is no compartments in this string.
Sample Case 1
STDIN
 
Function
*|*|*|
 
s = "*|*|*|"
1
 
startIndices[] size n = 1
1
 
startIndices = 1
1
 
endIndices[] size n = 1
6
 
endIndices = 6

Sample Output
2 
Explanation
s = '*|*|*|'
n = 1
startIndices = [1]
n = 1
startIndices = [1]
The substring from index = 1 to index = 6 is '||*|'. There are two compartments in this string at (index = 2, index = 4) and (index = 4, index = 6). 
There are 2 items between these compartments.
 * */
 