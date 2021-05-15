package finalLeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CriticalRoutes {

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

	private List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
		
		HashMap<Integer,Node> h = new HashMap<Integer,Node>();
		HashMap<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
		HashSet<Integer> start = new HashSet<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i =0;i<numRouters;i++) {
			h.put(i, new Node(i));
			start.add(i);
		}
		for(int i = 0;i<numLinks;i++) {
			Node n = h.get(links[i][0]);
			if(n==null) n = new Node(links[i][0]);
			Node c = new Node(links[i][1]);
			n.children.add(c);
			start.remove(links[i][1]);
			h.put(links[i][0], n);
		}
		
		for(int i = 0;i<numLinks;i++) {
			Node nodeToRemove = h.get(links[i][0]);
			if(nodeToRemove.children.size() != 0) {
				for(Integer j:start) {
					System.out.println("REMOVE "+i +"  Start with " + j);
					if(j == i) continue;
					else {
						for(int k =0;k<numRouters;k++) {
							visited.put(k, false);
						}
						DFS(h, j, i, visited);
						for(int k =0;k<numRouters;k++) {
							if(!visited.get(k) && k!=i && k!= j) {
								result.add(i);
								System.out.println("ADDED "+i);
								break;
							}
						}
					}
				}
			}
		}
		
	
		return result;
	}
	
	public void DFS(HashMap<Integer,Node> h, int st, int remove,HashMap<Integer,Boolean> v ) {
		if(st == remove) return;
		Node n = h.get(st);
		if(n==null) return;
		else {
			v.put(st, true);
		}
		for(Node c:n.children) {
			DFS(h,c.router,remove,v);
		}
		
	}
	
	public class Node{
		int router;
		ArrayList<Node> children;
		public Node(int r) {
			router = r;
			children =  new ArrayList<Node>();
		}
	}
}
