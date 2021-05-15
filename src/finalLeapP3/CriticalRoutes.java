package finalLeapP3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalRoutes {

//TARJAN's ALGO	
	
//	You are given an undirected connected graph. An articulation point (or cut vertex) is defined as a vertex which, when removed along with associated edges, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). The task is to find all articulation points in the given graph.
//
//	Input:
//	The input to the function/method consists of three arguments:
//
//	numNodes, an integer representing the number of nodes in the graph.
//	numEdges, an integer representing the number of edges in the graph.
//	edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
//	Output:
//	Return a list of integers representing the critical nodes.
//
//	Example:
//
//	Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]	
	
	public static void main(String[] args) {
		CriticalRoutes g = new CriticalRoutes();
		int numRouters1 = 7;
		int numLinks1 = 7;
		int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
		System.out.println(g.getCriticalNodes(links1, numLinks1, numRouters1));
	}

	int time = 0;
	private List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
		List<List<Integer>> map = new ArrayList<>();
		
		for(int i = 0;i<numRouters;i++) {
			List<Integer> l =  new ArrayList<>();
			map.add(l);
		}
		for(int i = 0;i<numLinks;i++) {
			map.get(links[i][0]).add(links[i][1]);
			map.get(links[i][1]).add(links[i][0]);
		}
		
		int[] disc = new int[numRouters];
		int[] low = new int[numRouters];
		int[] parent = new int[numRouters];
		Arrays.fill(disc,-1);
		Arrays.fill(low,-1);
		Arrays.fill(parent,-1);
		
		List<Integer> crit = new ArrayList<>();
		
		tarjan(0, map, disc, low, parent,crit);
		
		return crit;
		
	}
	
	void tarjan(int u,List<List<Integer>> map,int[] disc,int[] low,int[] parent,List<Integer> crit) {
		
		disc[u] = low[u] = time++;
		for(int v:map.get(u)) {
			
			if(parent[u] == v) continue;
			if(disc[v]==-1) {
				parent[v] = u;
				tarjan(v, map, disc, low, parent,crit);
				low[u] = Math.min(low[u], low[v]);
				if(low[v]>disc[u]) {
					System.out.println("Critical node "+u + " -"+v);
					crit.add(u);
				}
			}
			else {
				low[u] = Math.min(low[u], disc[v]);
			}
			
		}
	}
	
}
