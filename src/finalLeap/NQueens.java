package finalLeap;

import java.util.LinkedList;
import java.util.Queue;

public class NQueens {
	

	public static void main(String[] args) {
		NQueens g = new NQueens();

		int[][] a = { {0, 0, 0, 0},
					  {0, 0, 0, 0}, 
					  {0, 0, 0, 0},
					  {0, 0, 0, 0}};

		System.out.println(g.placeQueens(4,4));
	}
	public int[][] placeQueens(int size, int qSize) {
		
		if(size < qSize) return null;
		int[][] grid = new int[size][size];
		return placeAllQueens(grid,size, qSize,0,0, 1);
        
    }
	int queenCount = 0;
	public int[][] placeAllQueens(int[][] grid, int size, int qSize,int row, int col, int qn) {

		if(row == 0) init(grid);
		while (col < size) {
			boolean isSetForRow = false;
			for(int i = col;i<qSize;i++) {
				if(isSafe(grid,qn,row,i)) {
					grid[row][i] = 1;
					row++;
					isSetForRow = true;
					break;
				}
			}
			if(isSetForRow) {
				queenCount++;
				if(queenCount == qSize) return grid;
			}
			else break;
		}
		if(col == size) return null;
		return placeAllQueens(grid, size, qSize,--row, ++col,++qn);
	}
	public void init(int[][] grid) {
		grid = new int[][]{{0, 0, 0, 0},
						  {0, 0, 0, 0}, 
						  {0, 0, 0, 0},
						  {0, 0, 0, 0}};
						  
		queenCount = 0;
	}
	
	public boolean isSafe(int[][] grid,int qn, int r,int c) {
		System.out.println(r +" "+c);
		for(int i = 0;i<grid.length;i++) {
			if(i != c &&  grid[r][i] == qn) return false;
			if(i != r &&  grid[i][c] == qn) return false;
		}
		int ro = r, co = c;
		while(ro < grid.length-1 && co < grid.length-1) {
			if(grid[++ro][++co] == qn ) return false;
		}
		ro = r; co = c;
		while(ro < grid.length-1 && co > 0) {
			if(grid[++ro][--co] == qn ) return false;
		}
		ro = r; co = c;
		while(ro > 0 && co < grid.length-1) {
			if(grid[--ro][++co] == qn ) return false;
		}
		ro = r; co = c;
		while(ro > 0 && co > 0) {
			if(grid[--ro][--co] == qn ) return false;
		}
		return true;
	}
}
