package com;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

	static long arrayManipulation1(int n, int[][] queries) {

		long highest = 0;
		int indxL  = Integer.MAX_VALUE;
		int indxH  = 0;
		
		for(int i = 0; i<queries.length; i++) {
			if(queries[i][0] < indxL ) indxL = queries[i][0];
			if(queries[i][1] > indxH ) indxH = queries[i][1];
		}
		
		System.out.println("indxL "+indxL);
		System.out.println("indxH "+indxH);
		
		long array1[] = new long[indxH +1 - indxL];
		for(int i = 0; i<queries.length; i++) {
			for(int j = queries[i][0]-indxL; j<=queries[i][1]-indxL; j++) {
				array1[j] = array1[j] + queries[i][2];
				highest = array1[j] > highest ? array1[j]:highest;
			}
			
		}
		return highest;
				
    }
	//2497169732
	static long arrayManipulation2(int n, int[][] queries) {

		long highest = 0;
		int indxL  = Integer.MAX_VALUE;
		int indxH  = 0;
		
		for(int i = 0; i<queries.length; i++) {
			if(queries[i][0] < indxL ) indxL = queries[i][0];
			if(queries[i][1] > indxH ) indxH = queries[i][1];
		}
		
		System.out.println("indxL "+indxL);
		System.out.println("indxH "+indxH);
		int sum = 0;
		for (int i = indxL; i<=indxH ; i++) {
			sum = 0;
			for(int j = 0; j<queries.length; j++) {
				if( i >= queries[j][0] && i <= queries[j][1]) {
					sum = sum + queries[j][2];
				}
			}
			if(sum > highest) highest = sum;
		}
		
		return highest;
				
    }
	
	static long arrayManipulation(int n, int[][] queries) {

		int m = queries.length;
		
		long[] arr = new long[n];
        
		int lower;
		int upper;
		long sum;

		for(int i=0;i<n;i++) arr[i]=0;
		
		for(int i=0;i<m;i++){
		    lower=queries[i][0];
		    upper=queries[i][1];
		    sum=queries[i][2];
		    arr[lower-1]+=sum;
		    if(upper<n) arr[upper]-=sum; 
		}
		        
		long max=0;
		long temp=0;

		for(int i=0;i<n;i++){
		    temp += arr[i];
		    if(temp> max) max=temp;
		}
		
		return max;
				
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));
        

        scanner.close();
    }

	
	
	/*
	 * 
	 * 
Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros . Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is  after all operations are performed.

Function Description

Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.

arrayManipulation has the following parameters:

n - the number of elements in your array
queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
Input Format

The first line contains two space-separated integers  and , the size of the array and the number of operations. 
Each of the next  lines contains three space-separated integers ,  and , the left index, right index and summand.

Constraints

Output Format

Return the integer maximum value in the finished array.

Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
	 * */
}
