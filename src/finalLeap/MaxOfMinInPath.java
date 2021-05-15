package finalLeap;

public class MaxOfMinInPath {
	
//	Given 2 lists a and b. Each element is a pair of integers where the first integer
//	represents the unique id and the second integer represents a value. Your task is to 
//	find an element from a and an element form b such that the sum of their values is less 
//	or equal to target and as close to target as possible. Return a list of ids of selected elements. 
//	If no pair is possible, return an empty list.
	
	public static void main(String[] args) {
		MaxOfMinInPath g = new MaxOfMinInPath();

		int[][] a = { {1, 2, 3},
					  {8, 6, 7}, 
					  {9, 10, 1}};
		int[][] b = {{1, 8, 9},
					 {4, 5, 1}};
		System.out.println(g.getOptimalPath(a));
	}
	
	public  int getOptimalPath(int[][] a) {
		
		if(a.length == 0 || a[0].length == 0) return -1;
		//int startX = 0, startY = 0;
		//int endX = a.length-1, endY = a[0].length-1;
		int[][] g = new int[a.length][a[0].length];
		for(int i=0;i<a.length;i++) {
			for(int j = 0;j<a[0].length;j++) {
				g[i][j] = (a[i][j]);
			}
		}
		int m = g.length;
		int n = g[0].length;
		for(int i = 2;i<m;i++) {
			g[i][0] = Math.min(a[i][0], g[i-1][0]);
			g[i-1][0] = g[i][0];
		}
		for(int i = 2;i<m;i++) {
			g[0][i] = Math.min(a[0][i], g[0][i-1]);
			g[0][i-1] = g[0][i];
		}
		for(int i =1;i<m; i++) {
			for(int j = 1;j<n;j++) {
				g[i][j] = Math.max(Math.min(a[i][j], g[i-1][j]), Math.min(a[i][j], g[i][j-1]));
			}
		}
		return Math.max(g[m-2][n-1], g[m-1][n-2]);
		
	}
	
	
}
