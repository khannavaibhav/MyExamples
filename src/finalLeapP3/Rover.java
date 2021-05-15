package finalLeapP3;

public class Rover {

	public static void main(String[] args) {
		Rover sm = new Rover();
//		int[][] b = {{4,  5,10,15,19,20,20},
//					 {4,  9,12,15,22,23,26},
//					 {7, 11,12,20,22,27,27},
//					 {10,14,17,23,27,30,32},
//					 {11,18,19,25,28,34,39}};
		
		int n = 4;
		String[] commands = new String[]{"RIGHT","UP", "DOWN", "LEFT", "DOWN", "DOWN"};
		
		System.out.println(sm.roverPosition(n,commands));

	}
	
	public int roverPosition(int n,String[] commands) {
	
		int row = 0;
		int col = 0;
		
		for(String s:commands) {
			switch(s){
			case "RIGHT":
				if(col<n-1) col++;
				break;
			case "LEFT":
				if(col>0) col--;
				break;
			
			case "UP":
				if(row>0) row--;
				break;
			case "DOWN":
				if(row<n-1) row++;
				break;
			}
		}
	    
	    return row*n + col ;
    }
    

}
