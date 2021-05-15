package finalLeap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreasureIsland {
	
//	You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. 
//	Other areas are safe to sail in. There are other explorers trying to find the treasure. 
//	So you must figure out a shortest route to the treasure island.
//
//	Assume the map area is a two dimensional grid, represented by a matrix of characters. 
//	You must start from the top-left corner of the map and can move one block up, down, left or right at a time. 
//	The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks
//	or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. 
//	The top-left corner is always safe. Output the minimum number of steps to get to the treasure.
//
//	Example:
//
//	Input:
//	[['O', 'O', 'O', 'O'],
//	 ['D', 'O', 'D', 'O'],
//	 ['O', 'O', 'O', 'O'],
//	 ['X', 'D', 'D', 'O']]
//
//	Output: 5
//	Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
	
	public static void main(String[] args) {
		TreasureIsland g = new TreasureIsland();

		char[][] a = {{'O', 'O', 'O', 'O'},
					  {'D', 'O', 'D', 'O'}, 
					  {'O', 'O', 'O', 'O'}, 
					  {'X', 'D', 'D', 'O'}};
		System.out.println(g.getOptimalPath(a));
	}
	
	public static int getOptimalPath(char[][] a) {
	//4:15
		int count = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		
		if(a[0][0] == 'O') q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int c = q.size();
			for(int i = 0;i<c;i++) {
				int[] ids = q.poll();
				int x = ids[0];
				int y = ids[1];
				if(a[x][y] == 'X') return count;
				else {
					a[x][y] = 'V';
					if(x>0 && a[x-1][y] != 'V' && (a[x-1][y] == 'O' || a[x-1][y] == 'X'))  q.add(new int[] {x-1,y});
					if(x<a.length-1 && a[x+1][y] != 'V' && (a[x+1][y] == 'O' || a[x+1][y] == 'X')) q.add(new int[] {x+1,y});
					if(y>0 && a[x][y-1] != 'V' && (a[x][y-1] == 'O' || a[x][y-1] == 'X')) q.add(new int[] {x,y-1});
					if(y<a[0].length-1 && a[x][y+1] != 'V' && (a[x][y+1] == 'O' || a[x][y+1] == 'X')) q.add(new int[] {x,y+1});
				}
			}
			count++;
		}
		return 0;
	}
	
	public static int getOptimalPath2(char[][] a) {
		
		int count = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[]{0,0});
		while(!q.isEmpty()) {
			int s = q.size();
			System.out.println(s +" ||| "+count);
			
			for(int i = 0;i<s;i++) {
				int[] id = q.poll();
				int x = id[0], y = id[1];
				System.out.println("--- "+x +  "  " + y);
				if(a[x][y] == 'O') {
					a[x][y] = 'V';
				}
				if(x>0 && a[x-1][y] == 'O') q.add(new int[]{x-1,y});
				if(x>0 && a[x-1][y] == 'X') {
					return count;
				}
				if(x<a.length-1 && a[x+1][y] == 'O') q.add(new int[]{x+1,y});
				if(x<a.length-1 && a[x+1][y] == 'X') {
					return count;
				}
				
				if(y>0 && a[x][y-1] == 'O') q.add(new int[]{x,y-1});
				if(y>0 && a[x][y-1] == 'X') {
					return count;
				}
				if(y<a[0].length-1 && a[x][y+1] == 'O') q.add(new int[]{x,y+1});
				if(y<a[0].length-1 && a[x][y+1] == 'X') {
					return count;
				}
			}
			count++;
			
		}
		return -1;
	}
	
}
