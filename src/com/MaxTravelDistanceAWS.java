package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxTravelDistanceAWS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxTravelDist = 20;
		List<List<Integer>> forwardRouteList = new ArrayList<List<Integer>>();
		List<Integer> fwdSet = new ArrayList<Integer>();
		fwdSet.add(1);
		fwdSet.add(8);
		forwardRouteList.add(fwdSet);
		fwdSet = new ArrayList<Integer>();
		fwdSet.add(2);
		fwdSet.add(15);
		forwardRouteList.add(fwdSet);
		fwdSet = new ArrayList<Integer>();
		fwdSet.add(3);
		fwdSet.add(9);
		forwardRouteList.add(fwdSet);
		
		
		List<List<Integer>> returnRouteList = new ArrayList<List<Integer>>();
		List<Integer> rtnSet = new ArrayList<Integer>();
		rtnSet.add(1);
		rtnSet.add(8);
		returnRouteList.add(rtnSet);
		rtnSet = new ArrayList<Integer>();
		rtnSet.add(2);
		rtnSet.add(11);
		returnRouteList.add(rtnSet);
		rtnSet = new ArrayList<Integer>();
		rtnSet.add(3);
		rtnSet.add(12);
		returnRouteList.add(rtnSet);
		
		List<List<Integer>>  res = optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList);
		
		//List<List<Integer>>  res = findOptimalMemory(20, forwardRouteList, returnRouteList);
		for(List<Integer> r:res){
			System.out.println(r.get(0)+ " " + r.get(1));
		}
	}
	
	static public List<List<Integer>> findOptimalMemory(final int capacity,  List<List<Integer>> foreground,
	          List<List<Integer>> background)
	   {
	      int i = 0;
	      int j = background.size() - 1;
	      final List<List<Integer>> result = new ArrayList<List<Integer>>();
	      final List<List<Integer>>[] store = new ArrayList[capacity + 1];
	      Collections.sort(foreground, new Comparator<List<Integer>>()
	      {
	         public int compare(final List<Integer> f, final List<Integer> s)
	         {

	            return Integer.compare(f.get(1), s.get(1));
	         }
	      });

	      Collections.sort(background, new Comparator<List<Integer>>()
	      {
	         public int compare(final List<Integer> f, final List<Integer> s)
	         {

	            return Integer.compare(f.get(1), s.get(1));
	         }
	      });

	      while (i < foreground.size() && j > -1)
	      {
	         final int current = foreground.get(i).get(1) + background.get(j).get(1);
	         if (current <= capacity)
	         {
	            if (store[current] == null)
	               store[current] = new ArrayList<List<Integer>>();
	            store[current].add(Arrays.asList(new Integer[] { foreground.get(i).get(0), background.get(j).get(0) }));
	         }

	         if (current <= capacity)
	         {
	            ++i;
	         }
	         else if (current > capacity)
	         {
	            --j;
	         }
	      }

	      while (i < foreground.size())
	      {
	         final int current = foreground.get(i).get(1) + background.get(0).get(1);
	         if (current < capacity)
	         {
	            if (store[current] == null)
	               store[current] = new ArrayList<List<Integer>>();
	            store[current].add(Arrays.asList(new Integer[] { foreground.get(i).get(0), background.get(0).get(0) }));
	         }
	         ++i;
	      }

	      while (j > -1)
	      {

	         final int current = foreground.get(foreground.size() - 1).get(1) + background.get(j).get(1);
	         if (current < capacity)
	         {
	            if (store[current] == null)
	               store[current] = new ArrayList<List<Integer>>();
	            store[current]
	                  .add(Arrays.asList(new Integer[] { foreground.get(foreground.size() - 1).get(0), background.get(j).get(0) }));
	         }

	         --j;
	      }

	      for (int k = capacity; k > -1; --k)
	      {
	         if (store[k] != null)
	         {
	            result.addAll(store[k]);
	            break;
	         }
	      }
	      return result;
	   }
	
	static List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList,List<List<Integer>> returnRouteList ){
		
		int max = 0;
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Collections.sort(forwardRouteList, new Comparator<List<Integer>>()
	      {
	         public int compare(final List<Integer> f1, final List<Integer> f2)
	         {
	            return Integer.compare(f1.get(1).intValue(), f2.get(1).intValue());
	         }
	      });
		Collections.sort(returnRouteList, new Comparator<List<Integer>>()
	      {
	         public int compare(final List<Integer> r1, final List<Integer> r2)
	         {
	            return Integer.compare(r1.get(1).intValue(), r2.get(1).intValue());
	         }
	      });
		//java 8
		//forwardList = forwardList.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1))).collect(Collectors.toList());
		int maxBck = returnRouteList.size();
		boolean done = false;
		for(List<Integer> fdR: forwardRouteList){
			System.out.println("max "+maxBck);
			if(fdR.get(1)<= maxTravelDist){
				for(int j =0;j<maxBck;j++){
				//for(List<Integer> rnR: returnRouteList){
					List<Integer> rnR = returnRouteList.get(j);
					int sum = fdR.get(1) + rnR.get(1);
					if(sum > maxTravelDist){
						maxBck = j;
						if(j==0) done = true;
						break;
					}
					else if( sum >= max){
						if(sum > max){
							max = sum;
							results.clear();
						}
						List<Integer> resultSet = new ArrayList<Integer>();
						resultSet.add(fdR.get(0));
						resultSet.add(rnR.get(0));
						results.add(resultSet);
					}
					
				}
				if(done) break;
			}
			else{
				break;
			}
		}
		
		return results;
	}
	
	/**
	 
	 
Method takes 3 inputs,1st is maxTravelDistance= 20,  a plane can travel.
1 is forward route list [[1,8],[2,15],[3,9]], whereas 1st element is indexNumber of the route, 2nd element is distance for the route index
2nd is return route list [[1,8],[2,11],[3,12]] whereas 1st element is indexNumber of the route, 2nd element is distance for the route index
Find out optimal distance (forward+return) combinations. Find all combinations with that distance, and return all those index combinations.

Expected output is 1,3 & 3,2 .
	 
	 */

}
