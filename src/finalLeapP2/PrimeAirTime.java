package finalLeapP2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrimeAirTime {

	public static void main(String[] args) {
		PrimeAirTime s = new PrimeAirTime();
		
		List<List<Integer>> forwardRouteList =  new ArrayList<>();
		List<Integer> f = new ArrayList<>();
		f.add(1);
		f.add(3000);
		forwardRouteList.add(f);
		f = new ArrayList<>();
		f.add(2);
		f.add(5000);
		forwardRouteList.add(f);
		f = new ArrayList<>();
		f.add(3);
		f.add(7000);
		forwardRouteList.add(f);
		f = new ArrayList<>();
		f.add(4);
		f.add(10000);
		forwardRouteList.add(f);
		
		List<List<Integer>> returnRouteList =  new ArrayList<>();
		f = new ArrayList<>();
		f.add(1);
		f.add(2000);
		returnRouteList.add(f);
		f = new ArrayList<>();
		f.add(2);
		f.add(3000);
		returnRouteList.add(f);
		f = new ArrayList<>();
		f.add(3);
		f.add(4000);
		returnRouteList.add(f);
		f = new ArrayList<>();
		f.add(4);
		f.add(5000);
		returnRouteList.add(f);
		
		int target = 10000;
		System.out.println(s.solution(forwardRouteList, returnRouteList,target).toString());
	}

	/**
	 * @return
	 */
	public String solution(List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList,int target) {
		
		Collections.sort(forwardRouteList, new Comparator<List<Integer>>() {
			public int compare(List<Integer> l1, List<Integer> l2) {
				return l1.get(1) - l2.get(1);
			}
		});
		Collections.sort(returnRouteList, new Comparator<List<Integer>>() {
			public int compare(List<Integer> l1, List<Integer> l2) {
				return l2.get(1) - l1.get(1);
			}
		});
		
		System.out.println(forwardRouteList);
		System.out.println(returnRouteList);
		
		int max = Integer.MIN_VALUE;
		int fId = 0;
		int rId = 0;
		List<List<Integer>> res = new ArrayList<>();
		while (fId<forwardRouteList.size() &&  rId < returnRouteList.size()) {
			if(forwardRouteList.get(fId).get(1) + returnRouteList.get(rId).get(1) <= target) {
				if(forwardRouteList.get(fId).get(1) + returnRouteList.get(rId).get(1) >= max) {
					
					if(forwardRouteList.get(fId).get(1) + returnRouteList.get(rId).get(1) > max) {
						res.clear();
					}
					max = forwardRouteList.get(fId).get(1) + returnRouteList.get(rId).get(1);
					List<Integer> r = new ArrayList<>();
					r.add(forwardRouteList.get(fId).get(0));
					r.add(returnRouteList.get(rId).get(0));
					res.add(r);
				}
				fId++;
			}
			else {
				rId++;
			}
			
		}
		
		
		return "END" + res;
    }
	
	public String solution2(List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList,int target) {
		
		
		return "END";
    }
	
}


/*
Second questions was given a list of forward routes and reverse routes and the maxTravelAllowed: return the most optimal pairs
example: maxTravelDist = 10000
forwardRouteList[] = [1,3000],[2,5000],[3,7000],[4,10000]
returnRouteList[] = [1,2000],[2,3000],[3,4000],[4,5000]
O/p: [[2,4],[3,2]]

This problem is a variant of closest pair sum. You'll be given two arrays
arr1 = { {1, 2000}, {2, 3000}, {3, 4000} }
arr2 = { { 1, 5000 }, {2, 3000} }
the first element of every pair represents id and the second value represents the value.
and a target x = 5000
Find the pairs from both the arrays whose vaue add upto a sum which is less than given target and should be close to the target.


[1000, 1000, 2000, 3000, 6000, 9000]
[2000, 3000, 5000, 6000, 6000, 7000, 8000]

 * */
 