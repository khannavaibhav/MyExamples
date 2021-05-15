package finalLeap;

public class Search2DMatrix {

	public static void main(String[] args) {
		Search2DMatrix sm = new Search2DMatrix();
		int[][] b = {{4,  5,10,15,19,20,20},
					 {4,  9,12,15,22,23,26},
					 {7, 11,12,20,22,27,27},
					 {10,14,17,23,27,30,32},
					 {11,18,19,25,28,34,39}};
		
		System.out.println(sm.searchMatrix(b, 25));

	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
	
		int rowLength = matrix.length;
	    if(rowLength==0) return false;
	    int colLength = matrix[0].length;
	    
	    int row = 0;
	    int col = colLength -1;
	    
	    while (row < rowLength  && col >= 0){
	        if(matrix[row][col] == target) return true;
	        if(matrix[row][col] > target) col--;
	        else row++;    
	    }
	    return false;
        
        //if(matrix.length == 0 || matrix[0].length == 0 ) return false;
        //return findRC(matrix,target);
    }
    
    public boolean findRC(int[][] rc, int target){
        int rowSt = 0;
        int colSt= 0;
        int rowEnd = rc.length-1;
        int colEnd = rc[0].length-1;
        
        int r = 0, c = 0;
        while(rowSt <= rowEnd && colSt <= colEnd ){
            int midR = (rowSt+rowEnd)/2;
            int midC = (colSt+colEnd)/2;
            
            if(rc[midR][midC] == target) return true;
            else if(rc[midR][midC] > target){
                rowEnd = midR-1;
                colEnd = midC-1;
            }
            else if(rc[midR][midC] < target){
                rowSt = midR+1;
                colSt = midC+1;
            }
            r = midR;
            c = midC;
        }
        int s =0, e =0;
        
        System.out.println(r + " " +c + " "+ rc[r][c]);
        
        if(rc[r][c] > target) {
        	for(int i = r;i>=0;i--) {
        		for(int j = c;j>=0;j--) {
        			if(rc[i][j] == target) return true;
        		}
        	}
        }
        else 
        {
        	for(int i = r;i<rc.length;i++) {
        		for(int j = 0;j<rc[0].length;j++) {
        			if(rc[i][j] == target) return true;
        		}
        	}
        	for(int i = 0;i<r;i++) {
        		for(int j = c; j<rc[0].length;j++) {
        			if(rc[i][j] == target) return true;
        		}
        	}
        }
        
        
        return false;   
    }

}
