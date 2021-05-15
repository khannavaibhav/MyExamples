package finalLeapP1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LoopDeetectionBFS {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nodes = 9;
		int edges = 9;
		int[] from = new int[] {1,2,2,2,3,4,5,6,6,8};
		int[] to = new int[] {2,7,4,5,5,6,6,8,9,9};
		
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		
		for(int i = 0;i<from.length;i++) {
			List<Integer> l = map.getOrDefault(from[i], new ArrayList<>());
			l.add(to[i]);
			map.put(from[i], l);
			l = map.getOrDefault(to[i], new ArrayList<>());
			l.add(from[i]);
			map.put(to[i], l);
		}
		System.out.println(map);
		
		int[] visited = new int[nodes+1];
		int[] parent = new int[nodes+1];
		
		visited[0] = 2;
		parent[0] = -1;
		for(int i = 1;i<=nodes;i++) {
			visited[i] = -1;
			parent[i] = -1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1;i<=nodes;i++)
		{
			if(visited[i] == -1) {
				q.add(i);
				visited[i] = 0;
				parent[i] = -1;
			}
			int level = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				for(int j = 0;j<size;j++) {
					int x = q.poll();
					visited[x] = 1;
					List<Integer> l = map.get(x);
					if(l!=null) {
						for(int v:l) {
							if(visited[v] == -1)
							{
								q.add(v);
								visited[v] = 0;
								parent[v] = x;
							}
							else if(visited[v] == 0){
						// FIND PARENTS **************
								System.out.print(" "+v);
								
								int p1 = parent[v];
								int p2 = x;
								Set<Integer> p = new HashSet<>();
								while(p1 != -1) {
									p.add(p1);
									p1=parent[p1];
								}
								while(!p.contains(p2) && p2 != -1 )
								{
									p2=parent[p2];
								}
								int d = -1;
								if(p2!=-1) {
									d=p2;
								}
								p1 = parent[v];
								p2 = x;
								while(p1!=d) {
									System.out.print( " "+p1);
									p1=parent[p1];
								}
								while(p2!=d) {
									System.out.print( " "+p2);
									p2=parent[p2];
								}
								System.out.println( " "+d);
							}
						}
					}
				}
				
				level++;
			}
			
		}
		
	
		
	}
}
