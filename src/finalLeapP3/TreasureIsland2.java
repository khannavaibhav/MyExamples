package finalLeapP3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
//	You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). 
//	Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
	
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
		
		List<String> path = new ArrayList<>();
		for(int i = 0;i<a.length;i++) {
			for(int j = 0;j<a[0].length;j++) {
				boolean[][] visited = new boolean[a.length][a[0].length];
				if(a[i][j] == 'S') {
					System.out.println("START at S");
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i,j});
					a[i][j] = 'D';
					List<String> p = new ArrayList<>();
					int count = 0;
					while(!q.isEmpty()) {
						int size = q.size();
						count++;
						
						for(int x=0;x<size;x++) {
							int[] u = q.poll();
							int r = u[0];
							int c = u[1];
							p.add(r + " " +c +" # ");
							visited[r][c] = true;
							System.out.println(r + " "+c);
							if(a[r][c] == 'X') {
								if(count+1<minCount) {
									minCount = count;
									path = new ArrayList<>(p);
								}
								break;
							}
							if(r>0 && a[r-1][c] != 'D' && !visited[r-1][c]) q.offer(new int[] {r-1,c});
							if(r<a.length-1 && a[r+1][c] != 'D' && !visited[r+1][c]) q.offer(new int[] {r+1,c});
							if(c>0 && a[r][c-1] != 'D'  && !visited[r][c-1]) q.offer(new int[] {r,c-1});
							if(c<a[0].length-1 && a[r][c+1] != 'D' && !visited[r][c+1]) q.offer(new int[] {r,c+1});
						}
					}
				}
			}
		}
		System.out.println(path);
		return minCount;
	}


}
