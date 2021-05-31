package finalLeapP2;

import java.util.*;

public class CellStateInDays {

	public static void main(String[] args) {
		CellStateInDays s = new CellStateInDays();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] cell = new int[] {1, 0, 1, 0, 0, 1, 0, 0};
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
If pos-1 = 0 and pos+1 = 0 then pos = 0
if pos-1 = 1 amd pos_1 = 1 then pos = 0
if pos-1 != pos+1 then pos = 1
 * */
 