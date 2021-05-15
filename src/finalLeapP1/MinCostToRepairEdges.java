package finalLeapP1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToRepairEdges {

	public static void main(String[] args) {
		MinCostToRepairEdges s = new MinCostToRepairEdges();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		//3:00
		int n = 8;
		
//		int[][] edges  = new int[][]    {{1, 2},
//									     {2, 3},
//										 {3, 4},
//										 {4, 5},
//										 {1, 5}};
//		 int[][] edgesToRepair  = new int[][] {{1, 2, 12},
//											   {3, 4, 30},
//											   {1, 5, 8}};
		int[][] edges  = new int[][] {{1, 2},{2,4},{2,3},{2,5},{3,8},{4, 5},{5, 7},{6, 7},{7, 8}};  
				int[][] edgesToRepair  = new int[][]{{2, 4, 100},{2, 4, 16},{2, 3, 7},{2, 5, 15},{3, 8, 17}} ;
		HashMap<Integer,List<int[]>> map = new HashMap<>();								 
		for(int[] e:edges) {
			List<int[]> list = map.getOrDefault(e[0],new ArrayList<>());
			list.add(new int[] {e[1],0});
			map.put(e[0], list);
			list = map.getOrDefault(e[1],new ArrayList<>());
			list.add(new int[] {e[0],0});
			map.put(e[1], list);
		}
		for(int[] e:edgesToRepair) {
			List<int[]> list = map.get(e[0]);
			if(list!=null) {
				for(int[] x:list) {
					if(x[0] == e[1]) {
						x[1] = e[2];
					}
				}
			}
			list = map.get(e[1]);
			if(list!=null) {
				for(int[] x:list) {
					if(x[0] == e[0]) {
						x[1] = e[2];
					}
				}
			}
		}
		boolean[] visited = new boolean[n+1];
		int[] parent = new int[n+1];
		int[] cost =  new int[n+1];
		
		for(int i=1;i<=n;i++) {
			parent[i] = -1;
			cost[i] = Integer.MAX_VALUE;
		}
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1,Integer i2) {
				return cost[i1]-cost[i2];
			}
		});
		pq.offer(1);
		cost[1] = 0;
		
		while(!pq.isEmpty()) {
			int node = pq.poll();
			visited[node] = true;
			List<int[]> list = map.get(node);
			if(list!=null) {
				for(int[] ch:list) {
					if(!visited[ch[0]]) {
						if(cost[ch[0]] > ch[1]) {
							cost[ch[0]] = ch[1];
							parent[ch[0]] = node;
						}
						pq.add(ch[0]);
					}
				}
			}
		}
		
		System.out.println(map);	
		int sum = 0;
		for(int i = 1;i<=n;i++) {
			System.out.println(parent[i] + "-->" + i  + " visted:" + visited[i]+ " cost:" + cost[i]);
			sum+=cost[i];
		}
		return "END "+sum;
    }
}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 