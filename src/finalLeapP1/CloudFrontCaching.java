package finalLeapP1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloudFrontCaching {

	public static void main(String[] args) {
		CloudFrontCaching g = new CloudFrontCaching();
		int numNodes = 10;
		int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {7, 8}};
		System.out.println(g.getEfficiency(numNodes,edges));
//		System.out.println(g.findRoot(2));
	}
	
	public int getEfficiency(int numNodes,int[][] edges) {
		int eff=0;
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		for(int[] e:edges) {
			List<Integer> l = map.getOrDefault(e[0], new ArrayList<>());
			l.add(e[1]);
			map.put(e[0], l);
			l = map.getOrDefault(e[1], new ArrayList<>());
			l.add(e[0]);
			map.put(e[1], l);
		}
		boolean[] visited = new boolean[numNodes+1];
		int flag = 1;
		int[] count = new int[1];
		int result = 0;
		for(int i = 1;i<visited.length;i++) {
			if(!visited[i]) {
				count[0] = 0;
				BFS(map, visited, i, count);
				if(count[0] > 1) {
					result+=findRoot(count[0]);
				}
				else result+=1;
				//flag++;
			}
		}
//		int[] counts = new int[flag];
//		for(int i = 1;i<visited.length;i++) {
//			counts[visited[i]]++;
//		}
//		int result = 0;
//		for(int i= 1;i<counts.length;i++) {
//			if(counts[i] >1)
//				result+=findRoot(counts[i]);
//			else {
//				result+=1;
//			}
//		}
		
		return result;
	}
	int findRoot(int x) {
		if(x<=2) return x;
		int r = (int)Math.sqrt(x);
		if(x%r==0) return r;
		return r+1;
	
//		if(x<2) return x;
//        int left = 2,right = x,mid=0;
//        while(left<=right){
//            mid = left + (right-left)/2;
//            if(mid==x/mid && x%mid==0) return mid;
//            if(mid==x/mid) return mid+1;
//            else if(mid > x/mid) right = mid -1;
//            else left = mid+1;
//        }
//        return mid;
	}
	
	public void BFS(HashMap<Integer,List<Integer>> map,boolean[] visited, int node,int[] count ) {
		if(visited[node]) return;
		
		Queue<Integer> pq = new LinkedList<>();
		pq.add(node);
		while(!pq.isEmpty()) {
			int n = pq.poll();
			visited[n] = true;
			count[0]++;
			ArrayList<Integer> l = (ArrayList)map.get(n);
			if(l!=null) {
				for(int x:l) {
					if(!visited[x])pq.add(x);
				}
			}
		}
	}
}



/*
 AWS CloudFront wants to build an algo to measure the efficiency of its caching network. The network is represented as 
 a number of nodes and a list of connected pairs. The efficiency of this network can be estimated by first summing the 
 cost of each isolated set of nodes where each individual node has a cost of 1. To account for the increase in efficiency 
 as more nodes are connected, update the cost of each isolated set to be the ceiling of the square root of the original 
 cost and return the final sum of all costs.

Example:
n = 10 nodes
edges = [[1 2] , [1 3] , [2 4] , [3 5] , [7 8]] 

There are 2 isloated sets with more than one node {1,2,3,4,5} and {7,8}. The ceilings of their square roots are:
5^1/2 = 2.236 and ceil(2.236) = 3
2^1/2 = 1.414 and ceil(1.414) = 2
 
The other three isolated nodes are separate and the square root of their weights is 1^1/2 = 1 respectively.
The sum is 3+2+(3*1) = 8


Sample Input 0
n = 4
edges[] = ["1 2", "1 4"]

Sample Output 0
3

Explanation
The values to sum are:
Set {1,2,4}: c =ceil(sqrt(3)) = 2
Set {3}: c = ceil(sqrt(1)) = 1
Return 2+1=3

Sample Input 1
n = 8
edges[] = ["8 1",  "5 8", "7 3", "8 6"]

Sample Output 1
6

Explanation
The values to sum for each group are:
Set {2}: c =ceil(sqrt(1)) = 1
Set {4}: c = ceil(sqrt(1)) = 1
Set {1,5,6,8}: c = ceil(sqrt(4)) = 2
Set {3,7}: c = ceil(sqrt(2)) = 2
return 1+1+2+2 = 6

 * */
 