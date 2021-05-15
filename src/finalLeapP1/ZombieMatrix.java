package finalLeapP1;

import java.util.*;

public class ZombieMatrix {

	public static void main(String[] args) {
		ZombieMatrix s = new ZombieMatrix();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[][] world = new int[][] {{0, 1, 1, 0, 1},
                                    { 0, 1, 0, 1, 0},
                                    { 0, 0, 0, 0, 1},
                                    { 0, 1, 0, 0, 0}};

       int[] day = new int[1];
       day[0] = 1;
       System.out.println(begin(world, day));
		
		return "END";
    }
	boolean worldChanged = false;
	public int begin(int[][] world,int[] day) {
		
       for(int n=0;n<world.length;n++) {
    	   for(int m = 0;m<world[n].length;m++) {
    		   if(world[n][m] == day[0]) {
    			   attack(world,day,n,m);
    		   }
    	   }
       }
       
       if(humanExists(world)) {
	       if(worldChanged) {
	    	   day[0]++;
	    	   worldChanged=false;
	    	   return begin(world,day);
	       }
       }
       else if(!worldChanged) return 0;
       else return day[0];
       return -1;
	}
	
	public boolean humanExists(int[][] world) {
		for(int n=0;n<world.length;n++) {
    	   for(int m = 0;m<world[n].length;m++) {
    		   if(world[n][m] == 0) {
    			   return true;
    		   }
    	   }
       }
		return false;
	}
	
	public void attack(int[][] world, int[] day, int n,int m) {
		world[n][m] = -1;
		if(n>0) {
			if(world[n-1][m] == 0) {
				world[n-1][m] = day[0]+1;
				worldChanged = true;
			}
			if(world[n-1][m] == day[0]) attack(world, day, n-1, m);
		}
		if(n<world.length-1) {
			if(world[n+1][m] == 0) {
				world[n+1][m] = day[0]+1;
				worldChanged = true;
			}
			if(world[n+1][m] == day[0]) attack(world, day, n+1, m);
		}
		if(m>0) {
			if(world[n][m-1] == 0) {
				world[n][m-1] = day[0]+1;
				worldChanged = true;
			}
			if(world[n][m-1] == day[0]) attack(world, day, n, m-1);
		}
		if(m<world[n].length-1) {
			if(world[n][m+1] == 0) {
				world[n][m+1] = day[0]+1;
				worldChanged = true;
			}
			if(world[n][m+1] == day[0]) attack(world, day, n, m+1);
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
 