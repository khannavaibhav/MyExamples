package finalLeapP1;

import java.util.*;

public class CellStateInDays {

	public static void main(String[] args) {
		CellStateInDays s = new CellStateInDays();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] cell = new int[] {1, 1, 1, 0, 1, 1, 1, 1};
		int days = 2;
		for(int i=0;i<days;i++) {
			int curr = 0;
			int pr = 0;
			while(curr<8) {
				int nx = curr == 7?0:cell[curr+1];
				if(pr==nx) {
					pr=cell[curr];
					cell[curr] = 0;
				}				
				else {
					pr=cell[curr];
					cell[curr] = 1;
				}
				curr++;
			}
			System.out.println("DAY "+i+1);
			for(int x:cell) {
				System.out.println(x);
			}
		}
		return "END";
    }
	
}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 