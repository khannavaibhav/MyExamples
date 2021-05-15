package finalLeap;

import java.util.HashMap;

public class MoveRobotDP {
	
//	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//	Now consider if some obstacles are added to the grids. How many unique paths would there be?
//	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//	Note: m and n will be at most 100.
	
	public static void main(String[] args) {
		MoveRobotDP g = new MoveRobotDP();

		int[][] a = { {0, 0, 0},
					  {0, 1, 0}, 
					  {0, 0, 0}};
		
		int[][] b = {{0, 0, 0},
					 {0, 0, 0}};
		System.out.println(g.getOptimalPath(a));
	}
	

	public  int getOptimalPath(int[][] a) {
		
		if(a.length == 0 || a[0].length == 0) return 0;
		if(a[0][0] == 1) return 0; // No path available
		
		int lx = a.length;
		int ly = a[0].length;

		a[0][0] = 1;
		//Transpose all rows
		for(int i=1;i<lx;i++) {
			if(a[i][0] == 1) a[i][0] = 0;
			else a[i][0] = a[i-1][0];
		}
		//Transpose all columns
		for(int i=1;i<ly;i++) {
			if(a[0][i] == 1) a[0][i] = 0;
			else a[0][i] = a[0][i-1];
		}
		
		for(int i = 1;i< lx;i++) {
			for(int j = 1;j<ly;j++) {
				if(a[i][j] == 1) a[i][j] = 0;
				else {
					a[i][j] = a[i-1][j] + a[i][j-1];
				}
			}
		}
		return a[lx-1][ly-1];
	}
	


}
