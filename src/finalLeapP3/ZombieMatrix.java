package finalLeapP3;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieMatrix {

	public static void main(String[] args) {
		ZombieMatrix s = new ZombieMatrix();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
//		int[][] world = new int[][] {{0, 1, 1, 0, 1},
//                                    { 0, 1, 0, 1, 0},
//                                    { 0, 0, 0, 0, 1},
//                                    { 0, 1, 0, 0, 0}};
//		
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
			 

       //System.out.println(begin(world));
       
       System.out.println(begin2(world));
		
		return "END";
    }
	
	public int begin2(int[][] world) {
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0;i<world.length;i++) {
			for(int j = 0;j<world[0].length;j++) {
				if(world[i][j] == 1) {
					q.offer(new int[] {i,j});
				}
			}
		}
		while(!q.isEmpty()) {
			int[] w = q.poll();
			int x=w[0], y = w[1];
			
			if(x>0 && (world[x-1][y]==0 || world[x-1][y]-world[x][y]>1)) {
				world[x-1][y] = world[x][y]+1;
				q.offer(new int[] {x-1,y});
			}
			if(x<world.length-1 && (world[x+1][y]==0 || world[x+1][y]-world[x][y]>1)) {
				world[x+1][y] = world[x][y]+1;
				q.offer(new int[] {x+1,y});
			}
			if(y>0 && (world[x][y-1]==0 || world[x][y-1]-world[x][y]>1)) {
				world[x][y-1] = world[x][y]+1;
				q.offer(new int[] {x,y-1});
			}
			if(y<world[0].length-1 && (world[x][y+1]==0 || world[x][y+1]-world[x][y]>1)) {
				world[x][y+1] = world[x][y]+1;
				q.offer(new int[] {x,y+1});
			}
//			for(int i = 0;i<world.length;i++) {
//				for(int j = 0;j<world[0].length;j++) {
//					System.out.print(world[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("----------------------");
		}
		int max = 0;
		for(int i = 0;i<world.length;i++) {
			for(int j = 0;j<world[0].length;j++) {
				max=Math.max(max, world[i][j]);
			}
		}
		
		return max-1;
		
	}
	
	public int begin(int[][] world) {
		int day = 1; boolean changed = true;
		while(changed) {
			changed = false;
			for(int i=0;i<world.length;i++) {
				for(int j = 0;j<world[0].length;j++) {
					if(world[i][j]==day) {
						if(i>0 && world[i-1][j]==0){
							world[i-1][j]=day+1;
							changed = true;
						}
						if(i<world.length-1 && world[i+1][j]==0) {
							world[i+1][j]=day+1;
							changed = true;
						}
						if(j>0 && world[i][j-1]==0) {
							changed = true;
							world[i][j-1]=day+1;
						}
						if(j<world[0].length-1 && world[i][j+1]==0) {
							changed = true;
							world[i][j+1]=day+1;
						}
					}
				}
			}
			if(changed) day++;
		}
		for(int i=0;i<world.length;i++) {
			for(int j = 0;j<world[0].length;j++) {
				if(world[i][j]==0) {
					return -1;
				}
			}
		}
		return day -1;
	}
		
}
/*
Given a 2D grid, each cell is either a zombie or a human. Zombies can turn adjacent (up/down/left/right) 
human beings into zombies every day. Find out how many days does it take to infect all humans?

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
 