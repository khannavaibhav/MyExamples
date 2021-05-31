package finalLeap;

import java.util.*;

public class MinCostToAddNewRoads2 {

	public static void main(String[] args) {
		MinCostToAddNewRoads2 s = new MinCostToAddNewRoads2();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int n = 9;
		
		int[][] connects  = new int[][] {{0, 1, 12},
										 {0, 2, 100},
										 {0, 3, 100},
										 {0, 4, 100},
										 {0, 5, 100},
										 {0, 6, 100},
										 {0, 7, 100},
										 {0, 8, 25},
										 {1, 2, 10},
										 {1, 3, 100},
										 {1, 4, 100},
										 {1, 5, 100},
										 {1, 6, 100},
										 {1, 7, 40},{1, 8, 8},{2, 3, 18},{2, 4, 100},
										 {2, 5, 100},{2, 6, 55},{2, 7, 100},{2, 8, 100},
										 {3, 4, 44},{3, 5, 100},{3, 6, 100},{3, 7, 100},
										 {3, 8, 100},{4, 5, 60},{4, 6, 38},{4, 7, 100},{4, 8, 100},{5, 6, 100},
										 {5, 7, 100},{5, 8, 100},{6, 7, 35},{6, 8, 100},{7, 8, 35}};
//		int[][] connects  = new int[][]{{0,1,5},
//										{0,3,3},
//										{0,2,6},
//										{0,5,4},
//										{1,3,10},
//										{4,5,10},
//										{2,4,9}};
		
		Map<Integer,List<int[]>> map =  new HashMap<>();
		for(int[] con:connects) {
			List<int[]> l = map.getOrDefault(con[0],new ArrayList<>());
			l.add(new int[] {con[1],con[2]});
			map.put(con[0],l);
			l = map.getOrDefault(con[1],new ArrayList<>());
			l.add(new int[] {con[0],con[2]});
			map.put(con[1],l);
		}
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		int[] cost = new int[n];
//		visited[0] = true;

		for(int i = 0;i<n;i++) {
			parent[i] = -1;
			cost[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1,Integer i2) {
				return cost[i1] - cost[i2];
			}
		});

		cost[0] = 0; 
		pq.offer(0);
		while(!pq.isEmpty()) {
			int node = pq.poll();
			visited[node] = true;
			List<int[]> l = map.get(node);
			if(l!=null) {
				for(int[] c:l) {
					if(!visited[c[0]]) {
						if(cost[c[0]]>c[1]) {
							parent[c[0]] = node;
							cost[c[0]] = c[1];
						}
						pq.add(c[0]);
					}
				}
			}
		}
		int totalCost = 0;
		for(int i=0;i<visited.length;i++) {
			System.out.println(i + " " + visited[i] + " " + parent[i]+ " "+cost[i] );
			totalCost+=cost[i];
			if(!visited[i]) return "-1";
		}
		return "END "+totalCost;
    }
	

}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 