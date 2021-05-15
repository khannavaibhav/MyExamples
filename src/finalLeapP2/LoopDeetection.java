package finalLeapP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoopDeetection {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//3:55 - 4:25
		int nodes = 9;
		int edges = 9;
		int[] from = new int[] {1,2,2,2,3,4,5,6,6,8};
		int[] to = new int[] {2,7,4,5,5,6,6,8,9,9};
		
		List<List<Integer>> map = new ArrayList<>();
		for(int i =0;i<nodes+1;i++) {
			List<Integer> n = new ArrayList<>();
			map.add(n);
		}
		for(int i =0;i<=edges;i++) {
			map.get(from[i]).add(to[i]);
			map.get(to[i]).add(from[i]);
		}
		System.out.println(map);
		boolean[] visited = new boolean[nodes+1];
		int[] parents = new int[nodes+1];
		Arrays.fill(parents,-1);
		List<List<Integer>> loops = new ArrayList<>();
		for(int i = 1;i<nodes+1;i++) {
			if(!visited[i]) {
				dfs(i,map,visited,parents,loops);
				System.out.println(loops);
			}
			
		}
	}
	
	static void  dfs(int u, List<List<Integer>> map,boolean[] visited,int[] parents,List<List<Integer>> loops) {
		if(visited[u]) return;
		visited[u] = true;
		for(int v:map.get(u)) {
			if(v == parents[u]) continue;
			
			if(!visited[v]) {
				parents[v] = u;
				dfs(v,map,visited,parents,loops);
			}
			else {
				System.out.println("LOOP");
				int n = u;
				List<Integer> loop = new ArrayList<>();
				while(n!=v && n!=-1) {
					loop.add(n);
					n=parents[n];
				}
				loop.add(n);
				if(n!=-1) loops.add(loop);
				
			}
		}
	}
}
