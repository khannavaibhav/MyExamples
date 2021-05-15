package finalLeapP1;

public class Rover {

	public static void main(String[] args) {
		Rover sm = new Rover();
//		int[][] b = {{4,  5,10,15,19,20,20},
//					 {4,  9,12,15,22,23,26},
//					 {7, 11,12,20,22,27,27},
//					 {10,14,17,23,27,30,32},
//					 {11,18,19,25,28,34,39}};
		
		int n = 4;
		String[] commands = new String[]{"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
		
		System.out.println(sm.roverPosition(n,commands));

	}
	
	public int roverPosition(int n,String[] commands) {
	
		int rowPos = 0;
		int colPos = 0;
		
		for(String command:commands) {
			switch(command){
				case "RIGHT":
					if(colPos<n-1) colPos+=1;
					break;
				case "LEFT":
					if(colPos>0) colPos-=1;
					break;
				case "UP":
					if(rowPos>0) rowPos-=1;
					break;
				case "DOWN":
					if(rowPos<n-1) rowPos+=1;
					break;
				
			}
		}
	    
	    return rowPos*n+colPos;
    }
    

}
