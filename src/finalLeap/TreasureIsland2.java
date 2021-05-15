package finalLeap;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland2 {

//	You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks 
//	and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. 
//	So you must figure out a shortest route to one of the treasure islands.
//
//	Assume the map area is a two dimensional grid, represented by a matrix of characters. 
//	You must start from one of the starting point (marked as S) of the map and can move one block up, down, 
//	left or right at a time. The treasure island is marked as X. Any block with dangerous rocks or reefs 
//	will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O 
//	are safe to sail in. Output the minimum number of steps to get to any of the treasure islands.
//
//	Example:
//
//	Input:
//	[['S', 'O', 'O', 'S', 'S'],
//	 ['D', 'O', 'D', 'O', 'D'],
//	 ['O', 'O', 'O', 'O', 'X'],
//	 ['X', 'D', 'D', 'O', 'O'],
//	 ['X', 'D', 'D', 'D', 'O']]
//
//	Output: 3
//	Explanation:
//	You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
	
	public static void main(String[] args) {
		TreasureIsland2 g = new TreasureIsland2();

		char[][] a= {{'S', 'O', 'O', 'S', 'S'},
					 {'D', 'O', 'D', 'O', 'D'},
					 {'O', 'O', 'O', 'O', 'X'},
					 {'X', 'D', 'D', 'O', 'O'},
					 {'X', 'D', 'D', 'D', 'O'}};
		System.out.println(g.getOptimalPath(a));
	}
	
	public  int getOptimalPath(char[][] a) {
		int minCount = Integer.MAX_VALUE;
		for(int i = 0; i<a.length; i++) {
			for(int j = 0;j<a[0].length;j++) {
				if(a[i][j] == 'S') {
					int count = BFS(a, i, j);
					System.out.println("COUNT "+count);
					if(count!=-1 && count < minCount) {
						minCount = count;
					}
				}
			}
		}
		return minCount;
	}

	private int BFS(char[][] a, int i, int j) {
		boolean[][] b= new boolean[a.length][a[0].length];
		int count = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		a[i][j] = 'O';
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int siz = q.size();
			for(int k  = 0;k<siz;k++) {
				int[] id = q.poll();
				int m = id[0];
				int n = id[1];
				if(a[m][n] == 'X') return count;
				b[m][n] = true;
				
				if(m>0 && (a[m-1][n] == 'O' || a[m-1][n] == 'X') && !b[m-1][n]) {
					q.add(new int[] {m-1,n});
				}
				if(n>0 && (a[m][n-1] == 'O' || a[m][n-1] == 'X') && !b[m][n-1]) {
					q.add(new int[] {m,n-1});
				}
				if(m<b.length-1 && (a[m+1][n] == 'O' || a[m+1][n] == 'X') && !b[m+1][n]) {
					q.add(new int[] {m+1,n});
				}
				if(n<b[0].length-1 && (a[m][n+1] == 'O' || a[m][n+1] == 'X') && !b[m][n+1]) {
					q.add(new int[] {m,n+1});
				}
			}
			count++;
		}
		return -1;
	}

}
