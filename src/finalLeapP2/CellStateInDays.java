package finalLeapP2;

import java.util.*;

public class CellStateInDays {

	public static void main(String[] args) {
		CellStateInDays s = new CellStateInDays();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] cell = new int[] {1, 0, 0, 0, 0, 1, 0, 0};
		int days = 1;
		
		for(int j=0;j<days;j++) {
			int pre = 0;
			for(int i = 0;i<cell.length;i++) {
				int nxt = i==cell.length-1?0:cell[i+1];
				if(pre==nxt) {
					pre = cell[i];
					cell[i] = 0;
				}
				else {
					pre = cell[i];
					cell[i] = 1;
				}
			}
			for(int i:cell) {
				System.out.print(" " + i);
			}
			System.out.println("");
		}
		return " END";
    }
	
}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 