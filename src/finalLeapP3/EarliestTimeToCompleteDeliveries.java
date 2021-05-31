package finalLeapP3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class EarliestTimeToCompleteDeliveries {

	public static void main(String[] args) {
		EarliestTimeToCompleteDeliveries s = new EarliestTimeToCompleteDeliveries();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		int n= 2;
		int[] openTimes = new int[]{8,10};
		int[] deliveryTimeCosts = new int[]{2,2,3,1,8,7,4,5};
		
		Arrays.sort(openTimes);
		Arrays.sort(deliveryTimeCosts);
		
		int max = 0;
		int indx = deliveryTimeCosts.length-1;
		for(int i = 0;i<openTimes.length;i++) {
			int cost = openTimes[i] + deliveryTimeCosts[indx];
			indx-=4;
			max = Math.max(max, cost);
		}
		
		
		return "END " + max;
    }
	
}


/*
 * 
there are  n restraunts with 4 receiving docs each. Each doc has receiving rate.
Find earliest time all deliveries can be completed

Example : 
n= 2
openTimes = new int[]{8,10};
deliveryTimeCosts = new int[]{2,2,3,1,8,7,4,5};

O/P 16

> for 8> 8,7,5,4 == 16,15,13,12
> for 10> 3,2,2,1 == 13,12,12,11 

MAX - 16
 
https://www.youtube.com/watch?v=u6xSqhekjBg
 * */
 