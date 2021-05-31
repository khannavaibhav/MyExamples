package finalLeapP3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToAddNewRoads {

	public static void main(String[] args) {
		MinCostToAddNewRoads s = new MinCostToAddNewRoads();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		//4:45 5:29
		int n = 9;
		int[][] connects  = new int[][] {{0, 1, 12},{0, 2, 100},{0, 3, 100},{0, 4, 100},{0, 5, 100},{0, 6, 100},{0, 7, 100},{0, 8, 25},{1, 2, 10},{1, 3, 100},{1, 4, 100},{1, 5, 100},{1, 6, 100},{1, 7, 40},{1, 8, 8},{2, 3, 18},{2, 4, 100},{2, 5, 100},{2, 6, 55},{2, 7, 100},{2, 8, 100},{3, 4, 44},{3, 5, 100},{3, 6, 100},{3, 7, 100},{3, 8, 100},{4, 5, 60},{4, 6, 38},{4, 7, 100},{4, 8, 100},{5, 6, 100},{5, 7, 100},{5, 8, 100},{6, 7, 35},{6, 8, 100},{7, 8, 35}};
		
//		int n = 3;
//		int[][] connects = new int[][] {{0,1,5},{0,2,6},{1,2,1}};
		
		List<List<int[]>> map = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			List<int[]> l = new ArrayList<>();
			map.add(l);
		}
		
		for(int[] r:connects) {
			map.get(r[0]).add(new int[] {r[1],r[2]});
			map.get(r[1]).add(new int[] {r[0],r[2]});
		}
		
		int[] parent = new int[n];
		Arrays.fill(parent,-1);
		boolean[] visited = new boolean[n];
		int[] weight = new int[n];
		Arrays.fill(weight, Integer.MAX_VALUE);
		
//		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//			public int compare(Integer a1,Integer a2) {
//				return weight[a1]- weight[a2];
//			}
//		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(weight[a], weight[b]));
		pq.offer(0);
		weight[0] = 0;
		
		while(!pq.isEmpty()) {
			int u = pq.poll();
			visited[u] = true;
			
			for(int[] v:map.get(u)) {
				if(!visited[v[0]]) {
					if(weight[v[0]] > v[1]) {
						weight[v[0]] = v[1];
						parent[v[0]] = u;
					}
					pq.add(v[0]);
				}
			}
		}
		int total = 0;
		for(int t:weight) total+=t;
		
		return "END "+total;
    }
	
	
}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 