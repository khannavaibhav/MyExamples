package finalLeapP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TransactionLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] logs = new String[] {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
		int threshold = 2;
		//thresholdTypeIdCount(logs, threshold);
		HashMap<String,Integer> countMap =  new HashMap<>();
		for(String log:logs) {
			String[] ids = log.split(" ");
			countMap.put(ids[0], countMap.getOrDefault(ids[0], 0)+1);
			if(!ids[0].equals(ids[1])) countMap.put(ids[1], countMap.getOrDefault(ids[1], 0)+1);
		}
		List<String> res = new ArrayList<>();
		for(String key:countMap.keySet()) {
			if(countMap.getOrDefault(key, 0)>=threshold) res.add(key);
		}
		Collections.sort(res);
		String[] results = new String[res.size()];
		for(int i = 0;i<res.size();i++) {
			results[i] = res.get(i);
		}
		//return results;
	}

	private static void thresholdTypeIdCount(String[] logs, int threshold) {
		HashMap<String,Integer> countMap =  new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			public int compare(String s1,String s2) {
				return countMap.getOrDefault(s1, 0)-countMap.getOrDefault(s2, 0);
			}
		});
		for(String log:logs) {
			String[] ids = log.split(" ");
			countMap.put(ids[0], countMap.getOrDefault(ids[0], 0)+1);
			if(!ids[0].equals(ids[1])) countMap.put(ids[1], countMap.getOrDefault(ids[1], 0)+1);
		}
		for(String key:countMap.keySet()) {
			pq.add(key);
			if(pq.size()>threshold) pq.poll();
		}
		String[] res = new String[threshold];
		int i = 0;
		while(!pq.isEmpty()) {
			res[i++] = pq.poll();
			System.out.println(res[i-1]);
		}
	}

}
