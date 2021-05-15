package finalLeapP3;

import java.util.*;

public class CellStateInDays {

	public static void main(String[] args) {
		CellStateInDays s = new CellStateInDays();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] cell = new int[] {1, 0, 0, 0, 0, 1, 0, 0};
		int days = 1;
		
		for(int d=0;d<days;d++) {
			int prev = 0;
			for(int i = 0;i<cell.length;i++) {
				int next = i==cell.length-1?0:cell[i+1];
				if(prev==next) {
					prev = cell[i];
					cell[i] = 0;
				}
				else {
					prev = cell[i];
					cell[i] = 1;
				}
			}
			// 0 1 0 0 1 0 1 0
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
 