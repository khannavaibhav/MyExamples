package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {
	
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> result = new ArrayList();
		HashMap<Integer,Integer> freq = new HashMap();
		
		Integer key = null;
		Integer val = null;
		
		for (List q:queries){
			key = (Integer)q.get(0);
			val = (Integer)q.get(1);
			if(key == 1){
				freq.put(val, freq.get(val)==null?1:freq.get(val)+1);
			}
			else if(key == 2){
				freq.put(val, (Integer)( (freq.get(val)==null || freq.get(val)==0)?0:freq.get(val)-1));
			}
			else if (freq.containsValue(val)){
					result.add(1);
			}else{
				result.add(0);
			}
		}
		
		return result;
    }

    public static void main(String[] args) throws IOException {


        int q = 8;

        List<List<Integer>> queries = new ArrayList<List<Integer>>();
        
        List<Integer> queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(1);
        queriesRowItems.add(5);
        queries.add(queriesRowItems);
        queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(1);
        queriesRowItems.add(6);
        queries.add(queriesRowItems);
        queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(3);
        queriesRowItems.add(2);
        queries.add(queriesRowItems);
        queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(1);
        queriesRowItems.add(10);
        queries.add(queriesRowItems);
        queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(1);
        queriesRowItems.add(10);
        queries.add(queriesRowItems);
        queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(1);
        queriesRowItems.add(6);
        queries.add(queriesRowItems);
        queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(2);
        queriesRowItems.add(5);
        queries.add(queriesRowItems);
        queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(3);
        queriesRowItems.add(2);
        queries.add(queriesRowItems);
        queriesRowItems = new ArrayList<Integer>();
        queriesRowItems.add(1);
        queriesRowItems.add(5);
        queries.add(queriesRowItems);

        

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
        		System.out.println(ans.get(i));
        }


    }
    
    /*
     
     You are given  queries. Each query is of the form two integers described below:
-  x: Insert x in your data structure.
-  y: Delete one occurence of y from your data structure, if present.
-  z: Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

The queries are given in the form of a 2-D array queries of size q where queries[i][0] contains the operation, and queries[i][1] contains the data element. 
For example, you are given array . The results of each operation are:

Operation   Array   Output
(1,1)       [1]
(2,2)       [1]
(3,2)                   0
(1,1)       [1,1]
(1,1)       [1,1,1]
(2,1)       [1,1]
(3,2)                   1
Return an array with the output: .

Function Description

Complete the freqQuery function in the editor below. It must return an array of integers where each element is a  if there is at least one element value with the queried number of occurrences in the current array, or 0 if there is not.

freqQuery has the following parameter(s):

queries: a 2-d array of integers
Input Format

The first line contains of an integer , the number of queries.
Each of the next  lines contains two integers denoting the 2-d array .

Constraints

All 
Output Format

Return an integer array consisting of all the outputs of queries of type .

Sample Input 0

8
1 5
1 6
3 2
1 10
1 10
1 6
2 5
3 2
Sample Output 0

0
1
Explanation 0

For the first query of type , there is no integer whose frequency is  (). So answer is .
For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .

Sample Input 1

4
3 4
2 1003
1 16
3 1
Sample Output 1

0
1
Explanation 1

For the first query of type , there is no integer of frequency . The answer is .
For the second query of type , there is one integer,  of frequency  so the answer is .

Sample Input 2

10
1 3
2 3
3 2
1 4
1 5
1 5
1 4
3 2
2 4
3 2
Sample Output 2

0
1
1
Explanation 2

When the first output query is run, the array is empty. We insert two 's and two 's before the second output query,  so there are two instances of elements occurring twice. We delete a  and run the same query. Now only the instances of  satisfy the query.
     
     * */

}
