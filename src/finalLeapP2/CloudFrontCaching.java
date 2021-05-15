package finalLeapP2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloudFrontCaching {

	public static void main(String[] args) {
		CloudFrontCaching g = new CloudFrontCaching();
		int numNodes = 4;
		int[][] edges = {{0,1}, {0,3}};
		System.out.println(g.getEfficiency(numNodes,edges));
//		System.out.println(g.findRoot(2));
	}
	
	public int getEfficiency(int n,int[][] connections) {
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			List<Integer> ch =  new ArrayList<>();
			graph.add(ch);
		}
		for(int[] e:connections) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}
		int isolated = 0;
		int total = 0;
		boolean[] visited = new boolean[n];
		for(int i = 0;i<n;i++) {
			boolean[] v = new boolean[n];
			if(!visited[i]) dfs(i,graph,v);
			int count = 0;
			for(int j =0;j<n;j++) {
				if(!visited[j]) visited[j] = v[j];
				if(v[j])  count++;
			}
			if(count==1)isolated++;
			else {
				double d =  Math.sqrt((double)count);
				double d1 = d*10;
				if(d1%10 == 0) total +=d;
				else total +=d+1;
			}
		}

		return total+isolated;
		
	}
	
	void dfs(int u,List<List<Integer>> graph,boolean[] visited) {
		if(visited[u]) return;
		visited[u] = true;
		for(int v:graph.get(u)) {
			if(!visited[v]) dfs(v,graph,visited);
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
edges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {7, 8}};

There are 2 isloated sets with more than one node {1,2,3,4,5} and {7,8}. The ceilings of their square roots are:
5^1/2 = 2.236 and ceil(2.236) = 3
2^1/2 = 1.414 and ceil(1.414) = 2
 
The other three isolated nodes are separate and the square root of their weights is 1^1/2 = 1 respectively.
The sum is 3+2+(3*1) = 8


Sample Input 0
n = 4
edges[] = {{1,2}, {1,4}}

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
 