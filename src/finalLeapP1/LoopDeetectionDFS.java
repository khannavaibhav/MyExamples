package finalLeapP1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoopDeetectionDFS {
	
//	static class Edges{
//		int a;
//		int b;
//		public Edges(int c, int d) {
//			a=c>d?d:c;
//			b=c>d?c:d;
//		}
//		public boolean equals(Object e) {
//			if(e instanceof Edges){
//				Edges toCompare = (Edges) e;
//				return (toCompare.a == this.a && toCompare.b == this.b );
//			  }
//			  return false;
//		}
//		@Override
//	    public int hashCode() {
//	        return (a+b+"").hashCode();
//	    }
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Edges a = new Edges(1,2);
//		Edges b = new Edges(2,1);
//		System.out.println(a.equals(b));
		
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
		boolean[] visited = new boolean[nodes+1];
		List<Set<Integer>> paths = new ArrayList<>();
		for(int i =1;i<=nodes;i++) {
			//Set<Edges> elements = new HashSet<>();
			int[] parents = new int[nodes+1];
			if(!visited[i]) {
				parents[i] = -1;
				DFS(i, map, visited, parents,paths);
				System.out.println("END " + paths);
			}
		}
	}
	static void DFS(int node,HashMap<Integer,List<Integer>> map,
			boolean[] visited,int[] parents,List<Set<Integer>> paths) {
		//if(visited[start]) return;
		
		visited[node] = true;

		ArrayList<Integer> l = (ArrayList<Integer>)map.get(node);
		if(l!=null) {
			for(int i:l) {
				
				if(!visited[i]) {
					parents[i] = node;
					DFS(i, map, visited, parents,paths);
				}
				else if(i!=parents[node]) {
					int p = node;
					Set<Integer> s = new HashSet<>();
					while(p!=i && p!=-1) {
						s.add(p);
						p=parents[p];
					}
					if(p!=-1) {
						s.add(p);
						paths.add(s);
					}
				}
			}
		}
	}
}
