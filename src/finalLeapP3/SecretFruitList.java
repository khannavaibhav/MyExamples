package finalLeapP3;

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
		//10:26 - 11:00
		String[][] secretList = new String[][] {{"anything", "mango"},{"mango", "apple"},{"mango","anything"}};
		String[] customerList = new String[] {"grapes","orange", "mango","melon","melon","mango", "apple","mango","kiwi"};

		int start = 0;
			
		for(String[] sl:secretList) {
			int k = 0;
			while(start<customerList.length && k<sl.length) {
				if(customerList[start].equals(sl[k]) || "anything".equals(sl[k])) {
					k++;
					
				}
				else {
					start = start -k;
					k=0;
				}
				start++;
			}
			if(k<sl.length && start==customerList.length) {
				return "LOSER";
			}
		}
		
		return "WINNER " ;
    }
   

}
/*
Amazon is running a promotion in which customers receive prizes for purchasing a secret combination of fruits...

https://aonecode.com/amazon-online-assessment-secret-fruits

 * */
 