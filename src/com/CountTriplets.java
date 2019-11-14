package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

	static long countTriplets2(List<Long> arr, long r) {
		int count = 0;
		for(int i = 0; i< arr.size() - 2; i++) {
			for (int j = i+1;j<arr.size() -1; j++) {
				if(arr.get(i) * r == arr.get(j)) {
					for(int k = j + 1; k<arr.size(); k++) {
						if(arr.get(j) * r == arr.get(k)) {
							count ++;
						}
					}
				}
			}
		}

		return count;
    }
	
	
	
	static long countTriplets1(List<Long> arr, long r) {
		int count = 0;
		int counter[] = new int[arr.size()];
		for(int i = 0; i< arr.size(); i++) {
			
			int a = findMultiple(r,arr.get(i));
			if(a!=-1){
				counter[a] = counter[a] + 1;
			}
		}
		for(int i = 0; i< counter.length-2; i++) {
			count = count + (counter[i]*counter[i+1]*counter[i+2]);
		}

		return count;
    }

	
	 static long countTriplets(List<Long> arr, long r) {
	        long cnt = 0;
	        Map<Long, Long> map = new HashMap<Long, Long>();
	        Map<Long, Long> rMap = new HashMap<Long, Long>();
	        for (long n : arr) {
	        	System.out.println(n + " " + (n % r));
	            if (n % r == 0) {
	                long pre = n / r;
	                Long cnt2 = rMap.get(pre);
	                if (cnt2 != null) cnt += cnt2;
	                
	                Long cnt1 = map.get(pre);
	                if (cnt1 != null) rMap.put(n, (rMap.get(n)==null?0:rMap.get(n)) + cnt1);
	                
	                System.out.println("COUNT " + cnt);
	            }
	            System.out.println(n + "-- " + ((map.get(n)==null?0:map.get(n)) + 1));
	            map.put(n, (map.get(n)==null?0:map.get(n)) + 1);
	        }
	        return cnt;
	    }

	
	static int findMultiple(long r,long val){
		if(val == 1) return 0;
		int multiplier = 1;
		long result = 1;
		while (result <= val){
			result = result*r;
			if(val == result) return multiplier;
			multiplier++;
		}
		return -1;
	}
	
	
	
	
    public static void main(String[] args) throws IOException {
        


        int n = 7;

        long r = 4;

        String[] arrItems = new String[] {"1","2", "4", "16", "1", "4" , "16" };

        List<Long> arr = new ArrayList<Long>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        System.out.println(String.valueOf(ans));
    }
	
	
	
	/*
	 * 
	 * You are given an array and you need to find number of tripets of indices  such that the elements at those indices are in geometric progression for a given common ratio  and .

For example, . If , we have  and  at indices  and .

Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given  as an integer.

countTriplets has the following parameter(s):

arr: an array of integers
r: an integer, the common ratio
Input Format

The first line contains two space-separated integers  and , the size of  and the common ratio. 
The next line contains  space-seperated integers .

Constraints

Output Format

Return the count of triplets that form a geometric progression.

Sample Input 0

4 2
1 2 2 4
Sample Output 0

2
Explanation 0

There are  triplets in satisfying our criteria, whose indices are  and 

Sample Input 1

6 3
1 3 9 9 27 81
Sample Output 1

6
Explanation 1

The triplets satisfying are index , , , ,  and .

Sample Input 2

5 5
1 5 5 25 125
Sample Output 2

4
Explanation 2

The triplets satisfying are index , , , .
	 * */
}
