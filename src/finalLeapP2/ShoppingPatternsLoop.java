package finalLeapP2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingPatternsLoop {

	
	public static void main(String[] args) {
		ShoppingPatternsLoop s = new ShoppingPatternsLoop();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int nodes = 5;
		int edges = 6;
		int[] from = new int[] {1, 1, 2, 2, 3, 4};
		int[] to = new int[] {2, 3, 3, 4, 4, 5};
		
		List<List<Integer>> map =  new ArrayList<>();
		for(int i=0;i<=nodes;i++) {
			map.add(new ArrayList<>());
		}
		
		for(int i = 0;i<edges;i++) {
			map.get(from[i]).add(to[i]);
			map.get(to[i]).add(from[i]);
		}
		
		System.out.println(map);
		List<List<Integer>> triples = new ArrayList<>();
		boolean[] visited = new boolean[nodes+1];
		int[] parents = new int[nodes+1];
		for(int i = 1;i<=nodes;i++) {
			if(!visited[i]) dfs(i,map,visited,parents,triples);
		}
		if(triples.size() == 0) return "-1";
		System.out.println(triples);
		int count = 0;int min = Integer.MAX_VALUE;
		for(List<Integer> t:triples) {
			for(int u:t) {
				for(int v:map.get(u)) {
					if(!t.contains(v)) {
						count++;
					}
				}
			}
			if(count<min) min =  count;
			count = 0;
		}
		

		System.out.println("PRODUCTS: " + min);
		return "END" ;
    }
	
	void dfs(int u,List<List<Integer>> map,boolean[] visited,int[] parents,List<List<Integer>> triples) {
		
		if(visited[u]) return;
		visited[u] = true;
		
		for(int v:map.get(u)) {
			if(v == parents[u]) continue;
			if(!visited[v]) {
				parents[v] = u;
				dfs(v,map,visited,parents,triples);
			}
			else if(v!=parents[u]){
				System.out.println("LOOP Detected");
				List<Integer> l = new ArrayList<>();
				l.add(v);
				int p = u;
				while(p!=v && p!=0) {
					l.add(p);
					p=parents[p];
				}
				if(p!=0 && l.size() == 3) triples.add(l);
			}
		}
		
		
	}
}
