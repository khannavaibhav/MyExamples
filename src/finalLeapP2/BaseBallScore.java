package finalLeapP2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class BaseBallScore {

	public static void main(String[] args) {
		BaseBallScore s = new BaseBallScore();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		String[] blocks = new String[] {"10", "20", "Z","+"};
		int[] current = new int[blocks.length];
		int total=0;
		for(int i = 0;i<blocks.length;i++) {
			if(blocks[i] == "X" && i> 0) {
				current[i] = current[i-1]*2;
				total+=current[i];
			}
			else if(blocks[i] == "Z" && i>0) {
				if(i>1)current[i] = current[i-2];
				else current[i] = 0;
				total-=current[i-1];
			}
			else if(blocks[i] == "+" && i>0) {
				current[i] = current[i-1] ;
				if(i>1) current[i]+= current[i-2];
				total+=current[i];
			}
			else {
				current[i] = getIntegerValue(blocks[i]);
				total+=current[i];
			}
		}
		return ""+total;
	}
	
	int getIntegerValue(String s) {
		int mul = 10;
		int total = 0;
		for(int i = 0;i<s.length();i++) {
			int x = s.charAt(i) - '0';
			total = total*10 +x;
		}
		return total;
	}
		

}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, X, + or Z. 
Given a list of strings represent blocks, return the final score...
X - double from last throw


https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 