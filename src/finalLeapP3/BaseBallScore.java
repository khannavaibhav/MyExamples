package finalLeapP3;

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
		
		String[] blocks = new String[] {"10", "20", "X","+"};
		
		int[] prev = new int[blocks.length];
		int sum = 0;
		for(int i = 0;i<blocks.length;i++) {
			if(i>1 && blocks[i] == "+") {
				prev[i] = prev[i-2] + prev[i-1];
				sum+=prev[i]; 
			}
			else if(i>0 && blocks[i] == "X") {
				prev[i] = prev[i-1]*2;
				sum+=prev[i]; 
			}
			else if(i>0 && blocks[i] == "Z") {
				prev[i] = prev[i-2];
				sum-=prev[i-1]; 
			}
			else {
				//prev[i] = convertToInt(blocks[i]);
				prev[i] = Integer.parseInt(blocks[i]);
				sum+=prev[i] ;
			}
			
			
		}
		
		return ""+ sum;
	}
	
	int convertToInt(String x) {
		
		int res = 0;
		int mul = 10;
		for(char c:x.toCharArray()) {
			res = res*mul + (c - '0');
		}
		return res;
	}


}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, X, + or Z. 
Given a list of strings represent blocks, return the final score...
X - double from last throw


https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 