package finalLeapP1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingPatternsLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nodes = 5;
		int edges = 6;
		int[] from = new int[] {1,1,2,2,3,4};
		int[] to = new int[] {2,3,3,4,4,5};
		
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		for(int i = 0;i<from.length;i++) {
			List<Integer> l = map.getOrDefault(from[i], new ArrayList<>());
			l.add(to[i]);
			map.put(from[i],l);
			l = map.getOrDefault(to[i], new ArrayList<>());
			l.add(from[i]);
			map.put(to[i],l);
		}
		System.out.println(map);
		boolean[] visited = new boolean[nodes+1];
		int[] parents = new int[nodes+1];
		List<Set<Integer>> path = new ArrayList<>();
		for(int i = 1;i<=nodes;i++) {
			if(!visited[i]) {
				
				myDFS(i, map, visited, parents, path);
				System.out.println(path);
			}
		}
		int min = Integer.MAX_VALUE;
		int count = 0;
		for(Set<Integer> s:path) {
			for(int i:s) {
				List<Integer> l = map.get(i);
				if(l!=null) {
					for(int x:l) {
						if(!s.contains(x)) {
							count++;
						}
					}
				}
			}
			
			if(count < min) min = count;
			count=0;
		}
		System.out.println("PRODUCTS: " + min);
	}
	
	public static void myDFS(int node,HashMap<Integer,List<Integer>> map,boolean[] visited,int[] parents,List<Set<Integer>> path) {
		
		visited[node] = true;
		
		List<Integer> l = map.get(node);
		if(l!=null) {
			for(int u:l) {
				
				if(!visited[u]) {
					parents[u] = node;
					myDFS(u, map, visited, parents, path);
				}
				else if(u!=parents[node]) {
					int curr = node;
					Set<Integer> s = new HashSet<>();
					while(curr!=u && curr>0) {
						s.add(curr);
						curr = parents[curr];
					}
					if(curr>0) {
						s.add(curr);
						path.add(s);
					}
				}
			}
		}
	}
}
