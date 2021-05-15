package finalLeapP1;

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
		
		String[] blocks = new String[] {"10", "20", "Z", "30","+"};
		
		int[] scores = new int[blocks.length];
		for(int i =0;i<blocks.length;i++) {
			scores[i] = convertToNo(blocks[i]);
		}
		
		
		int[] totals = new int[blocks.length];
		int index = 0;
		while(scores[index] ==-1) {
			index++;
		}
		totals[index] = scores[index];
		for(int i = ++index;i<scores.length;i++) {
			if(scores[i] == -1) {
				if(blocks[i].equals("X")) {
					scores[i] = scores[i-1]*2;
					totals[i] = totals[i-1]+scores[i];
					
				}
				else if(blocks[i].equals("+") && i>1) {
					scores[i] = scores[i-1]+scores[i-2];
					totals[i] = totals[i-1]+scores[i];
				}
				else if(blocks[i].equals("Z") && i>1) {
					scores[i] = scores[i-2];
					totals[i] = totals[i-2];
				}
				
			}
			else totals[i] = totals[i-1]+scores[i];
			System.out.println(i + " " + totals[i]);
		}
		
		System.out.println(totals[totals.length-1]);
		return "END";
    }
	
	public int convertToNo(String s) {
		if(s.equals("X") || s.equals("Z") || s.equals("+")) {
			return -1;
		}
		int mul = 1;
		int total = 0;
		for(char c:s.toCharArray()) {
			if(c >= '0' && c<= '9' ) {
				total = total*mul + (c - '0');
				mul*=10;
			}
		}
		return total;
	}
    

}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 