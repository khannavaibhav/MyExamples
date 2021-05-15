package finalLeapP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MinCostToAddNewRoads {

	public static void main(String[] args) {
		MinCostToAddNewRoads s = new MinCostToAddNewRoads();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		//11:20
		int n = 6;
		
		int[][] connects  = new int[][] {{1, 2, 5},
										 {1, 4, 3},
										 {1, 3, 6},
										 {1, 6, 4},
										 {2, 4, 10},
										 {3, 5, 7},
										 {5, 6, 10}};
		
		HashMap<Integer,List<int[]>> map = new HashMap<>();
		for(int[] c:connects) {
			if(c[0] != c[1]) {
				List<int[]> set = map.getOrDefault(c[0], new ArrayList<>());
				set.add(new int[] {c[1],c[2]});
				map.put(c[0], set);
				set = map.getOrDefault(c[1], new ArrayList<>());
				set.add(new int[] {c[0],c[2]});
				map.put(c[1], set);
			}
		}
		
		boolean[] visited = new boolean[n+1];
		int[] parents = new int[n+1];
		int[] weights = new int[n+1];
		parents[0] = -1;
		parents[1] =-1;
		dfs(1, map, visited, parents, weights);
		System.out.println(map);
		for(int i =1;i<n+1;i++) {
			System.out.println(i + " " + visited[i] + " " +parents[i] + " " +weights[i] );
		}
		
		return "END ";
    }
	
	
	public void dfs(int node,HashMap<Integer,List<int[]>> map,boolean[] visited,int[] parents,int[] weights ) {
		
		visited[node] = true;
		List<int[]> l = map.get(node);
		if(l!=null) {
			Collections.sort(l,new Comparator<int[]>() {
				public int compare(int[] i1,int[] i2) {
					return i1[1] - i2[1];
				}
			});
			for(int[] ch:l) {
				if(!visited[ch[0]]) {
					parents[ch[0]] = node;
					weights[ch[0]] = ch[1];
					dfs(ch[0], map, visited, parents, weights);
				}
				else if(parents[ch[0]] !=-1 && ch[0] != parents[node] && weights[ch[0]] > ch[1]) {
					parents[ch[0]] = node;
					weights[ch[0]] = ch[1];
				}
			}
		}
		
		
	}
}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 