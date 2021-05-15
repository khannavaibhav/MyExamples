package finalLeapP3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoopDeetection {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//2:00 - 4:25
		int nodes = 9;
		int edges = 9;
		int[] from = new int[] {1,2,2,2,3,4,5,6,6,8};
		int[] to = new int[]   {2,7,4,5,5,6,6,8,9,9};
		
		List<List<Integer>> map = new ArrayList<>();
		for(int i =0;i<=nodes;i++) {
			List<Integer> l = new ArrayList<>();
			map.add(l);
		}
		for(int i=0;i<from.length;i++) {
			map.get(from[i]).add(to[i]);
			map.get(to[i]).add(from[i]);
		}
		
		int[] visited = new int[nodes+1];
		int[] parent = new int[nodes+1];
		Arrays.fill(visited, -1);
		Arrays.fill(parent, -1);
		
		for(int i =1;i<=nodes;i++) {
			if(visited[i]==-1) {
				dfs(i,map,visited,parent);
			}
		}
	}
	//[[5, 6, 4, 2], [9, 8, 6]]
	static void dfs(int u,List<List<Integer>> map,int[] visited,int[] parent ) {
		
		visited[u] = 0;
		for(int v:map.get(u)) {
			if(v==parent[u]) continue;
			
			if(visited[v]==-1) {
				parent[v] = u;
				dfs(v,map,visited,parent);
			}
			else if(visited[v]==0) {
				System.out.println("LOOP --- ");
				System.out.print(v+" ");
				int p = u;
				while(p!=v) {
					System.out.print(p+" ");
					p=parent[p];
				}
				System.out.println(" --- END");
			}
		}
		visited[u] = 1;
	}
	
}
