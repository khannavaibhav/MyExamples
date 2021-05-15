package finalLeapP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ItemsInContainers {

	public static void main(String[] args) {
		ItemsInContainers s = new ItemsInContainers();
		System.out.println(s.containerCounts().toString());
	}

	public String containerCounts() {
		
		String s = "|**|*|*";
		int[] startIndices = new int[] {1, 1};
		int[] endIndices = new int[] {5, 6};

		int[] res = new int[startIndices.length];
		for(int i=0; i<startIndices.length; i++) {
			res[i] = getCount(s, startIndices[i]-1, endIndices[i]);
		}
		for(int i:res) {
			System.out.println(i);
		}
		return "END";
	}
	
	public int getCount(String s, int startIx,int endIx) {
		int pipeCount=0;
		int curr = 0;
		int total = 0;
		for(int i = startIx;i<endIx;i++) {
			if(s.charAt(i) == '|') {
				total +=curr;
				curr=0;
			}
			else {
				curr++;
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
 