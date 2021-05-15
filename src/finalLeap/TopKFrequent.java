package finalLeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {

//	Given a non-empty array of integers, return the k most frequent elements.
//
//
//	Input: nums = [1,1,1,2,2,3], k = 2
//			Output: [1,2]
	
	public static void main(String[] args) {
		
		List<Integer> r = topKFrequent(new int[] {1,2,1}, 2);
		for(int i =0;i<r.size();i++) {
			System.out.println(r.get(i));
		}
	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {

		 Arrays.sort(nums);
        HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>(nums.length);
        
        for(int i:nums){
            counts.put(i, counts.getOrDefault(i,0) +1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                if(counts.get(i1) > counts.get(i2)) return 1;
                else if(counts.get(i1) < counts.get(i2)) return -1;
                else return 0;
            }
        });
        Queue s = new LinkedList();
        
        for(Integer i:counts.keySet()){
            q.add(i);
            if(q.size() > k){
                q.poll();
            }
        }
        
        List<Integer> l = new ArrayList<Integer>();
        for(int i =0;i<k;i++){
            l.add(q.poll());
        }
        Collections.reverse(l);
        return l;
    }
}
