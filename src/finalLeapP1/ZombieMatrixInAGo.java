package finalLeapP1;

import java.util.*;

public class ZombieMatrixInAGo {

	public static void main(String[] args) {
		ZombieMatrixInAGo s = new ZombieMatrixInAGo();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[][] world = new int[][] {{1, 1, 1, 0, 1, 0},// [1, 1, 1, 2, 1, 2]
									 {1, 1, 0, 1, 0, 1},// [1, 1, 2, 1, 2, 1]
									 {0, 1, 0, 1, 0, 0},// [2, 1, 2, 1, 2, 2]
									 {0, 1, 0, 1, 0, 0},// [2, 1, 2, 1, 2, 3]
									 {1, 0, 0, 0, 1, 0},// [1, 2, 3, 2, 1, 2]
									 {0, 0, 0, 1, 0, 0},// [2, 2, 2, 1, 2, 3]
									 {0, 1, 0, 0, 0, 0},// [2, 1, 2, 2, 3, 4]
									 {0, 1, 0, 0, 0, 0},// [2, 1, 2, 3, 4, 5]
									 {0, 0, 0, 0, 0, 0},// [3, 2, 5, 4, 5, 6]
									 {0, 0, 0, 0, 0, 0},// [4, 3, 6, 5, 5, 6]
									 {0, 0, 0, 0, 0, 0},// [5, 4, 6, 6, 4, 4]
									 {0, 0, 0, 0, 0, 0},// [6, 5, 7, 5, 3, 2]
									 {0, 0, 0, 0, 0, 1}};//[7, 6, 6, 4, 2, 1]

       System.out.println(begin(world));
		
		return "END";
    }
	int human = 0;
	public int begin(int[][] world) {
	
	 boolean[][] visited = new boolean[world.length][world[0].length];
	 for(int n=0;n<world.length;n++) {
    	   for(int m = 0;m<world[n].length;m++) {
    		   if(world[n][m] == human) {
    			   attack(world,n,m,visited);
    			   break;
    		   }
    	   }
    	   if(visited[0][0]) break;
       }
	 	refresh(world);
	 	return findMax(world) -1;
	}
	
	//backtrack
	public void refresh(int[][] world) {
		for(int n=world.length-1;n>=0;n--) {
    	   for(int m = world[n].length-1;m>=0;m--) {
    		   int min = getMin(world, n, m) ;
    		   if(min < world[n][m]) world[n][m] = min;
    	   }
       }
	}
	
	//get no of days
	public int findMax(int[][] world) {
		int max=0;
		for(int n=0;n<world.length;n++) {
    	   for(int m = 0;m<world[n].length;m++) {
    		   int min = getMin(world, n, m) ;
    		   if(min < world[n][m]) world[n][m] = min+1;
    		   if(world[n][m] > max) {
    			   max = world[n][m];
    		   }
    	   }
       }
		return max;
	}
	
	public int getMin(int[][] world,int n,int m) {
		int min = Integer.MAX_VALUE;
		if(n>0 && world[n-1][m] > 0 && world[n-1][m]  < min) min = world[n-1][m];
		if(n<world.length-1 && world[n+1][m] > 0 && world[n+1][m]  < min) min = world[n+1][m];
		if(m>0 && world[n][m-1] > 0 && world[n][m-1]  < min) min = world[n][m-1] ;
		if(m<world[n].length-1 && world[n][m+1] > 0 && world[n][m+1]  < min) min = world[n][m+1];
		return min==Integer.MAX_VALUE?0:min+1;
	}
	
	public void attack(int[][] world, int n,int m,boolean[][] visited) {
		visited[n][m] = true;
		if(n>0) {
			if(world[n-1][m] == 0) {
				world[n-1][m] = getMin(world,n-1,m);
			}
			if(!visited[n-1][m] && world[n-1][m] >human) attack(world,  n-1, m,visited);
		}
		if(n<world.length-1) {
			if(world[n+1][m] == 0) {
				world[n+1][m] = getMin(world,n+1,m);
			}
			if(!visited[n+1][m] && world[n+1][m] >human) attack(world,  n+1, m,visited);
		}
		if(m>0) {
			if(world[n][m-1] == 0) {
				world[n][m-1] = getMin(world,n,m-1);
			}
			if(!visited[n][m-1] && world[n][m-1] >human) attack(world,  n, m-1,visited);
		}
		if(m<world[n].length-1) {
			if(world[n][m+1] == 0) {
				world[n][m+1] = getMin(world,n,m+1);
			}
			if(!visited[n][m+1] && world[n][m+1] >human) attack(world,  n, m+1,visited);
		}
	}
	
}
/*
Given a 2D grid, each cell is either a zombie or a human. Zombies can turn adjacent (up/down/left/right) human beings into zombies every day. Find out how many days does it take to infect all humans?

Input:
matrix, a 2D integer array where a[i][j] = 1 represents a zombie on the cell and a[i][j] = 0 represents a human on the cell.

Output:
Return an integer represent how many days does it take to infect all humans.
Return -1 if no zombie exists.

Example :
Input:
[[0, 1, 1, 0, 1],
[0, 1, 0, 1, 0],
[0, 0, 0, 0, 1],
[0, 1, 0, 0, 0]]

Output:
2

Explanation:
At the end of the day 1, the status of the grid:
[[1, 1, 1, 1, 1],
[1, 1, 1, 1, 1],
[0, 1, 0, 1, 1],
[1, 1, 1, 0, 1]]

At the end of the day 2, the status of the grid:
[[1, 1, 1, 1, 1],
[1, 1, 1, 1, 1],
[1, 1, 1, 1, 1],
[1, 1, 1, 1, 1]]
 * */
 