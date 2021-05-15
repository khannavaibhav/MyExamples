package finalLeapP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SecretFruitList {

	public static void main(String[] args) {
		SecretFruitList s = new SecretFruitList();
		System.out.println(s.score().toString());
	}

	public String score() {
		
		String[][] secretList = new String[][] {{"orange", "mango"},{"melon", "mango"},{"anything","kivi"}};
		String[] customerList = new String[] {"orange", "mango","mango","melon","mango", "apple","mango","kivi"};
		boolean isWinner = false;

		int start = 0;
		int maxIndex = customerList.length; 
		for(int i = 0;i<secretList.length;i++) {
			isWinner = false;
			while(!isWinner && start<=maxIndex-secretList[i].length) {
				isWinner = containsAll(secretList[i], customerList, start);
				start++;
			}
			if(!isWinner) return "NOT IN " +i; 
			else start+=secretList[i].length-1;
		}
			
		
		return "WINNER";
    }
	
	public boolean containsAll(String[] secrets,String[] selected,int start) {
		int id = start;
		for(int i= 0;i<secrets.length;i++) {
			
			if(secrets[i].equals("anything")) {
				start++;
				continue;
			}
			if(!secrets[i].equals(selected[start])) return false;
			start++;
		}
		return true;
	}
   

}
/*
Amazon is running a promotion in which customers receive prizes for purchasing a secret combination of fruits...

https://aonecode.com/amazon-online-assessment-secret-fruits

 * */
 