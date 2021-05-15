package facebook;

public class SpiralArray {

	public static void main(String[] args) {
		
		SpiralArray a = new SpiralArray();
		int input = 5;
		
		int startRow = 0, startCol = 0;
		int endRow = input -1, endCol = input -1;
		
		int[][] spiral = new int[input][input];
		int counter = 1;
		while(startRow <= endRow && startCol <= endCol) {
			
			for(int i = startCol; i<=endCol;i++) {
				spiral[startRow][i] =counter++;
			}
			startRow++;
			for(int i = startRow; i<= endRow;i++) {
				spiral[i][endCol] = counter++;
			}
			endCol--;
			for(int i = endCol; i>=startCol;i--) {
				spiral[endRow][i] =counter++;
			}
			endRow--;
			for(int i = endRow; i>=startRow;i--) {
				spiral[i][startCol] =counter++;
			}
			startCol++;
		}
		
		for(int i = 0;i<input;i++) {
			System.out.println(" ");
			for(int j = 0;j<input;j++) {
				System.out.print(" " + spiral[i][j]);
			}
		}
		
	}

}
