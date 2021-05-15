package finalLeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentWords2 {

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
		
		List<String> r = topKFrequent(new String[] { "I love anacell Best services; Best services provided by Anacell",
				  "Betacellular has great services",
				  "Deltacellular provides much better services than betacellular",
				  "cetracular is worse than anacell",
				  "Betacellular is better than deltacellular."},
				new String[] {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"},
				2);
		for(int i =0;i<r.size();i++) {
			System.out.println(r.get(i));
		}
	}
	public static List<String> topKFrequent(String[] reviews, String[] comp,int k) {
        //4:35
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for(String c:comp) {
        	counts.put(c.toLowerCase(), 0);
        }
        for(String s:reviews){
        	s = s.toLowerCase();
        	String[] rs = s.split(" ");
        	Set<String> rSet = new HashSet<String>(Arrays.asList(rs));
        	for(String srs:rSet) {
        		
        		if(counts.get(srs) != null)
        			counts.put(srs,counts.get(srs) + 1);
        	}
        }

        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String o1,String o2){
                if(counts.get(o1) > counts.get(o2)) return 1;
                else  if(counts.get(o2) > counts.get(o1)) return -1;
                else return o2.compareTo(o1);
            }
        });
        
        for(String s: comp){
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
        System.out.println(counts);
        return l;
        
        //5:05
    }
}
