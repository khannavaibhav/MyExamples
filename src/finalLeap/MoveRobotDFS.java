package finalLeap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MoveRobotDFS {
	
//	Given 2 lists a and b. Each element is a pair of integers where the first integer
//	represents the unique id and the second integer represents a value. Your task is to 
//	find an element from a and an element form b such that the sum of their values is less 
//	or equal to target and as close to target as possible. Return a list of ids of selected elements. 
//	If no pair is possible, return an empty list.
	
	public static void main(String[] args) {
		MoveRobotDFS g = new MoveRobotDFS();

		int[][] a = { {1, 2, 3},
					  {5, 6, 7}, 
					  {9, 10, 1}};
		int[][] b = {{1, 8, 9},
					 {4, 5, 1}};
		System.out.println(g.getOptimalPath(b));
	}
	
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	
	class Res{
		HashMap<Integer,String> h = new HashMap<Integer,String>() ;
		int sum = 0;
		int count;
	}
	public  int getOptimalPath(int[][] a) {
		
		if(a.length == 0 || a[0].length == 0) return -1;
		//int startX = 0, startY = 0;
		//int endX = a.length-1, endY = a[0].length-1;
		Res r = new Res();
		DFS(a,0,0, r);
		
		return max;
	}
	

	
	public void DFS(int[][] a, int startX,int startY,Res r) {
		int endX = a.length-1, endY = a[0].length-1;
		if(startX == endX && startY == endY) {
			r.h.put(r.count, r.h.get(r.count)==null?"-"+a[startX][startY]:r.h.get(r.count)+"-"+a[startX][startY]);
			System.out.println(r.count + "<- Count SUM -> " + r.h.get(r.count));
			
			r.sum = r.sum + a[startX][startY];
			//System.out.println(" -----> "+ r.sum);
			r.count++;
			r.sum = 0;
			if(max < min) max = min;
			System.out.println("MAX => "+ max);
			min = max;
			return;
		}
		if(startX < endX) {
			r.h.put(r.count, r.h.get(r.count)==null?"-"+a[startX][startY]:r.h.get(r.count)+"-"+a[startX][startY]);
			r.sum = r.sum + a[startX][startY];
			if(!(startX+1==endX && startY==endY) && a[startX+1][startY] < min ) min = a[startX+1][startY];
			System.out.println(a[startX+1][startY] + " min----> "+ min);
			DFS(a,startX+1,startY,r);
		}
		if(startY < endY) {
			r.h.put(r.count, r.h.get(r.count)==null?"-"+a[startX][startY]:r.h.get(r.count)+"-"+a[startX][startY]);
			r.sum = r.sum + a[startX][startY];
			if(!(startX==endX && startY+1==endY) && a[startX][startY+1] < min ) min = a[startX][startY+1];
			System.out.println(a[startX][startY+1]+" min----> "+ min);
			DFS(a,startX,startY+1,r);
		}

	}
	
}
