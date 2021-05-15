package finalLeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CriticalConnections {

	public static void main(String[] args) {
		CriticalConnections g = new CriticalConnections();
		int numRouters1 = 6;
		List<List<Integer>> c =  new ArrayList<List<Integer>>();
		//[[0,1],[1,2],[2,0],[1,3]]
		//[[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);l.add(1);c.add(l);
		l = new ArrayList<Integer>();
		l.add(1);l.add(2);c.add(l);
		l = new ArrayList<Integer>();
		l.add(2);l.add(0);c.add(l);
		l = new ArrayList<Integer>();
		l.add(1);l.add(3);c.add(l);
		l = new ArrayList<Integer>();
		l.add(3);l.add(4);c.add(l);
		l = new ArrayList<Integer>();
		l.add(4);l.add(5);c.add(l);
		l = new ArrayList<Integer>();
		l.add(5);l.add(3);c.add(l);
			
		//int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
		System.out.println(g.criticalConnections(numRouters1, c));
	}
	
public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        //1 Initialize
        HashMap<Integer,ArrayList<Integer>> h = new HashMap<Integer,ArrayList<Integer>>(n);
        HashSet<Integer> cs = new HashSet<Integer>();
        boolean[] v = new boolean[n];
        
        //2 Create Graph
        for(int i = 0;i<connections.size();i++){
            List<Integer> node = connections.get(i);
            ArrayList<Integer> c = h.getOrDefault(node.get(0),new ArrayList<Integer>());
            c.add(node.get(1));
            h.put(node.get(0),c);
      // Bidirectional      
            c = h.getOrDefault(node.get(1),new ArrayList<Integer>());
            c.add(node.get(0));
            h.put(node.get(1),c);
        }
      //Rempve each node and try BFS  
        for(int remove = 0;remove<n;remove++){
            v = new boolean[n];
            int start = remove==0?1:0;
            Queue<Integer> q = new LinkedList<Integer>();
            if(start != remove) q.add(start);
            
            while(!q.isEmpty()){
                int s = q.poll();
                v[s] = true;
                ArrayList<Integer> c = h.get(s);
                for(int j = 0;j<c.size();j++){
                    if(c.get(j) != remove && !v[c.get(j)]) {
                        q.add(c.get(j));
                    }
                }  

                
            }
            for(int i = 0;i<n;i++){
                if(i!=remove && !v[i]){
                    cs.add(remove);
                }
            }  
        }
        System.out.println(cs);
        
        return null;
    }
	
    public List<List<Integer>> criticalConnections2(int n, List<List<Integer>> connections) {
        //10:00
         List<List<Integer>> res = new ArrayList<List<Integer>>();
         Set<Integer> critNodes = new HashSet<Integer>();
         HashMap<Integer,ArrayList<Integer>> adjNodes = new HashMap<Integer,ArrayList<Integer>> ();
// 1. INITIALIZE NODES OF GRAPH (HASHMAP)
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>> (n);
        for(int i = 0;i<n;i++){
            graph.put(i,new ArrayList<Integer>());
        }
// 2. CREATE GRAPH FROM INPUT CONNECTIONS
        for(List<Integer> l:connections){
            ArrayList<Integer> child = graph.get(l.get(0));
            child.add(l.get(1));
            graph.put(l.get(0),child);

      //UNDIRECTED GRAPH
            child = graph.get(l.get(1));
            child.add(l.get(0));
            graph.put(l.get(1),child);

        }


// 3. LOOP FOR EACH NODE TO BE REMOVED 
        for(int i = 0;i<n;i++){
            boolean[] visited = new boolean[n];
            int removeNode = i;
            int start = i==0?1:0;
      // 4. BFS SOLUTION TO MARK ALL VISITED CHILDREN
            Queue<Integer> q = new LinkedList<Integer>();
            if(start != removeNode){
                q.add(start);
            }
            while(!q.isEmpty()){
                int p = q.poll();
                visited[p] = true;
                ArrayList<Integer> ch = graph.get(p);
                for(int c:ch){
                    if(c!=removeNode && !visited[c]){
                        q.add(c);
                    }
                }
            }
// 5. ADD CRITICAL NODES
            ArrayList<Integer> a = new ArrayList<Integer>();
            boolean wasSet = false;
            for(int j=0; j<n; j++){
                if(j!= removeNode && !visited[j]){
                    critNodes.add(removeNode);
                     wasSet = true;
                    if(graph.get(removeNode).contains(j))
                    	a.add(j);
                }
            }
            if(wasSet && graph.get(removeNode).contains(start)){
                a.add(start);
            }
            adjNodes.put(removeNode,a);
        }
        
        System.out.println(critNodes);
        System.out.println(adjNodes);

// 6. ADD CRITICAL EDGES
        HashSet<Integer> v = new HashSet<Integer>();
         for(int i : critNodes) {
             ArrayList<Integer> c = adjNodes.get(i);
             if(c.size() == 1){
                 c.add(i);
                 res.add(c);
             }
             else {
            	 for(int ch:c) {
            		 ArrayList<Integer> g = graph.get(ch);
            		 for(int a:g) {
            			 v.add(a);
            		 }
            	 }
            	 for(int ch:c) {
            		 if(!v.contains(ch)) {
            			 ArrayList<Integer> r = new ArrayList<Integer>();
            			 r.add(i);
            			 r.add(ch);
            			 res.add(r);
            		 }
            	 }
             }
             
         }
        
//         ArrayList<Integer> v = new ArrayList<Integer>();
//         ArrayList<Integer> o = new ArrayList<Integer>();
//         for(int i : critNodes) {
//             ArrayList<Integer> c =graph.get(i);
//             for(int ch:c) {
//                 if(critNodes.contains(ch) && !v.contains(ch)) {
//                     List<Integer> l = new ArrayList<Integer>();
//                     l.add(i);
//                     l.add(ch);
//                     res.add(l);
//                     v.add(i);
//                 }
//                 else if(!v.contains(ch)){
//                     o.add(ch);
//                 }                
//             }
//             for(int ch: o){
//                 ArrayList<Integer> c =graph.get(ch);
                
//             }
//         }
//         System.out.println(o);  
        
        
        
        return res;
    }
}
