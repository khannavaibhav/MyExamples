package Structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphQuestion {

	public static void main(String[] args) {
		GraphQuestion g = new GraphQuestion();
		int numRouters1 = 7;
		int numLinks1 = 7;
		int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
		System.out.println(g.getCriticalNodes(links1, numLinks1, numRouters1));
	}

	private List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
		
		HashMap<Integer,Node> h = new HashMap<Integer,Node>();
		HashSet<Integer> start = new HashSet<Integer>();
		HashSet<Integer> end = new HashSet<Integer>();
		HashMap<Integer,Integer> found = new HashMap<Integer,Integer>();
		for(int i=0;i<numLinks;i++) {
			found.put(links[i][0], 0);
			found.put(links[i][1], 0);
			start.add(links[i][0]);
			start.add(links[i][1]);
			end.add(links[i][0]);
			end.add(links[i][1]);
		}
		for(int i=0;i<numLinks;i++) {
			start.remove(links[i][1]);
			end.remove(links[i][0]);
			Node n = h.get(links[i][0]);
			if(n == null) {
				n = new Node(links[i][0]);
			}
			Node c = new Node(links[i][1]);
			n.children.add(c);
			h.put(links[i][0], n);
		}
		for(Integer k:h.keySet()) {
			boolean isThere =  false;
			for(Integer i:start) {
				for(Integer j:end) {
					if(k != i && k!= j) {
						isThere =  DFS(h, i, j,k,false);
						System.out.println(k +"  "+isThere);
					}	
					if(isThere) found.put(k, (found.get(k) + 1));
				}
			}	
			
			System.out.println(k +" "+ found.get(k) );
		}
		List<Integer> l = new ArrayList<Integer>();
		for(Integer i : found.keySet()) {
			if(found.get(i)<start.size()*end.size() && !start.contains(i) && !end.contains(i)) {
				l.add(i);
			}
		}
		
		return l;
	}
	
	public boolean DFS(HashMap<Integer,Node> h, int start,int end, int remove,boolean b) {
		
		if(b) return b;
		if(start == end) return true;
		if(start == remove) return false;		
		Node n = h.get(start);
		if(n==null) return false;
		h.put(n.router, n);
		for(Node c: n.children) {
			//System.out.println("CHILD "+ c.router);
			b =	DFS(h, c.router, end, remove,b);
		}
		return b;
	}

	public class Node{
		int router;
		boolean visited;
		ArrayList<Node> children;
		public Node(int r) {
			router = r;
			children = new ArrayList<Node>();
		}
		
	}
}
