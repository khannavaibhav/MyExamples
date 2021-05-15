package finalLeapP3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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
		
		//1:30pm
		TopKFrequentWords t = new TopKFrequentWords();
		List<String> r = t.topKFrequent(new String[] { "I love anacell Best services; Best services provided by Anacell ",
				  "Betacellular has great services Betacellular",
				  "Deltacellular provides much better services than betacellular",
				  "cetracular is worse than anacell",
				  "Betacellular is better than deltacellular. anacell"},
				
				new String[] {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"},
				
				2);
		for(int i =0;i<r.size();i++) {
			System.out.println(r.get(i));
		}
	}
	public List<String> topKFrequent( String[] reviews, String[] games,int topKGames) {
      //4:35
      Map<String,List<Integer>> freqMap = new HashMap<>();
      PriorityQueue<String> topK = new PriorityQueue<>(new Comparator<String>() {
    	  public int compare(String s1,String s2) {
    		  List<Integer> l1 = freqMap.get(s1);
    		  List<Integer> l2 = freqMap.get(s2);
    		  if(l1.size() == l2.size()) {
    			  Set<Integer> t1 = new HashSet<>(l1);
    			  Set<Integer> t2 = new HashSet<>(l2);
    			  return t1.size()-t2.size();
    		  }
    		  else return l1.size() - l2.size();
    	  }
      });
      
      for(String g:games) {
    	  freqMap.put(g.toLowerCase(), new ArrayList<>());
      }
      int revCount = 0;
      for(String rev:reviews) {
    	  revCount++;
    	  List<String> r = findWords(rev);
    	  for(String w:r) {
    		  w = w.toLowerCase();
    		  if(freqMap.containsKey(w)) {
    			  List<Integer> l = freqMap.get(w);
    			  l.add(revCount);
    			  freqMap.put(w, l);
    		  }
    	  }
      }
      for(String s:freqMap.keySet()) {
    	  topK.add(s);
		  if(topK.size()>topKGames) topK.poll();
      }
      List<String> resList = new ArrayList<>();
      while(!topK.isEmpty()) {
    	  String s = topK.poll();
    	  List<Integer> l = freqMap.get(s);
    	  if(l.size()>0) { 
    		  resList.add(0, s);
    	  }
      }
      System.out.println(freqMap);
      return resList;
      //5:05
  }
	public List<String> findWords(String s) {
		List<String> words = new ArrayList<>();
		String w = "";
		for(int i = 0;i<s.length();i++) {
			
			if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
				(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
				w = w+s.charAt(i);
			}
			else {
				if(w.trim().length()>0)words.add(w);
				w = "";
			}
		}
		if(w.trim().length()>0)words.add(w);
		System.out.println(words);
		return words;
	}
}
