package finalLeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {

//	Given a non-empty list of words, return the k most frequent elements.
//
//			Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
//			Example 1:
//			Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//			Output: ["i", "love"]
//			Explanation: "i" and "love" are the two most frequent words.
//			    Note that "i" comes before "love" due to a lower alphabetical order.
	
	public static void main(String[] args) {
		
		List<String> r = topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2);
		for(int i =0;i<r.size();i++) {
			System.out.println(r.get(i));
		}
	}
	public static List<String> topKFrequent(String[] words, int k) {
        //4:35
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for(String s:words){
            Integer i = counts.getOrDefault(s,0);
            i = i +1;
            counts.put(s,i);
        }

        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String o1,String o2){
                if(counts.get(o1) > counts.get(o2)) return 1;
                else  if(counts.get(o2) > counts.get(o1)) return -1;
                else return o2.compareTo(o1);
            }
        });
        
        for(String s: counts.keySet()){
            pq.add(s);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> l =  new ArrayList<String>(k);
        for(int i = 0;i<k;i++){
            l.add(pq.poll());
        }
        Collections.reverse(l);
        return l;
        
        //5:05
    }
}
