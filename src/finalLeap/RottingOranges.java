package finalLeap;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	
//	In a given grid, each cell can have one of three values:
//
//		the value 0 representing an empty cell;
//		the value 1 representing a fresh orange;
//		the value 2 representing a rotten orange.
//		Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
//
//		Return the minimum number of minutes that must elapse until no cell has a fresh orange.  
//		If this is impossible, return -1 instead.
	
	public int orangesRotting(int[][] grid) {
        
        int rotten = 2;
        int empty = 0;
        int fresh = 1;
        
        boolean isDone = false;
        boolean freshExists = true;
        int countMin = 0;
        
        while(!isDone){
            isDone = true;
            freshExists = false;
            for(int i = 0;i<grid.length;i++){
                for(int j = 0;j<grid[0].length;j++){
                    Queue<int[]> q = new LinkedList<int[]>();
                    
                    if(grid[i][j] == rotten){
                        q.add(new int[]{i,j});
                    }
                    while(!q.isEmpty()){
                        int[] id = q.poll();
                        grid[id[0]][id[1]] = rotten*-1;
                        if(id[0] > 0 && grid[id[0]-1][id[1]] == rotten) q.add(new int[]{id[0]-1,id[1]});
                        if(id[0] > 0 && grid[id[0]-1][id[1]] == fresh) {
                            grid[id[0]-1][id[1]] = rotten*-1;
                            isDone = false;
                        }
                        
                        if(id[0] < grid.length-1 && grid[id[0]+1][id[1]] == rotten) q.add(new int[]{id[0]+1,id[1]});
                        if(id[0] < grid.length-1 && grid[id[0]+1][id[1]] == fresh) {
                            grid[id[0]+1][id[1]] = rotten*-1;
                            isDone = false;
                        }
                        
                        if(id[1] > 0 && grid[id[0]][id[1]-1] == rotten) q.add(new int[]{id[0],id[1]-1});
                        if(id[1] > 0 && grid[id[0]][id[1]-1] == fresh) {
                            grid[id[0]][id[1]-1] = rotten*-1;
                            isDone = false;
                        }
                        
                        if(id[1] < grid[0].length-1 && grid[id[0]][id[1]+1] == rotten) q.add(new int[]{id[0],id[1]+1});
                        if(id[1] < grid[0].length-1 && grid[id[0]][id[1]+1] == fresh) {
                            grid[id[0]][id[1]+1] = rotten*-1;
                            isDone = false;
                        }
                    }
                    if(grid[i][j] == fresh) freshExists = true;
                }
            }
            if(!isDone) countMin++;
            rotten = rotten*-1;
        }
     
        return freshExists?-1:countMin;
        
    }
}
