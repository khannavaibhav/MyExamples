package finalLeapP3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class UtilizationChecks {

	public static void main(String[] args) {
		UtilizationChecks s = new UtilizationChecks();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		
		int instances = 5;
		int[] avgUtils = new int[] {30,5,4,8,19,89};
		
		int i = 0;
		while(i<avgUtils.length) {
			if(avgUtils[i] < 25 && instances>1) {
				instances= (int)Math.ceil((double)instances/2);
				i+=10;
			}
			else if(avgUtils[i] > 60 && instances*2<=2E8) {
				instances*=2;
				i+=10;
			}
			else i++;
		}
		int x = 2;
		x+=2E8;
		System.out.println(x);
		return "END " + instances;
    }
	
}


/*
Avg util of computing system - add or decrease instances as per current load
Once action is performed, system stops checking for 10 seconds

if utilization < 25% = reduce by half (min 1) ceil
if utilization > 60% = double the instances [max 2*10^8]

O/P: no of final instances 

https://www.youtube.com/watch?v=c239VAn0nKQ
 * */
 