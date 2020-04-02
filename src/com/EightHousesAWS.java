package com;

import java.util.ArrayList;
import java.util.List;

public class EightHousesAWS {
	
	public static void main(String[] args) {
		//getCharCount("combination");
		//int[] st = new int[]{1,0,0,0,0,1,0,0};
		//int d = 1;
		
		int[] st = new int[]{1,1,1,0,1,1,1,1};
		int d = 2;
		
		List<Integer> res = cellComete(st, d);
		for(int i:res){
			System.out.println(i);
		}
	}
	
	public static List<Integer> cellComete(int[] states, int days){
		
		int[] previousState = new int[states.length];
		int[] currentState = new int[states.length];

		previousState = states;
		// 11101111
		// 10101001
		// 00000110
		
		for (int day = 0; day<days;day++){
			System.out.println( "DAY "+ day );
			for(int i = 0;i<previousState.length;i++){
				if(i == 0 ){
					if(previousState[1] == 0){
						currentState[0] = 0;
					}else{
						currentState[0] = 1;
					}
				}
				else if(i==previousState.length-1){
					currentState[i] = previousState[i-1] == 0?0:1;
				}
				else{
					if(previousState[i-1] == previousState[i+1]){
						currentState[i] = 0;
					}
					else currentState[i] = 1;
				}
				
			}
			previousState = currentState.clone();
			
		}
		
		
		List<Integer> res = new ArrayList<Integer>(); 
		for(int i:currentState){
			res.add(i);
		}
		return res;
	}

	/*
	 
	  8 houses as cells arranged in straight line. 0 -  inactive cell, 1 - active cell.
	  if the neighbors on both sides of a cell are active or inactive, cell becomes inactive otherwise active.
	  no cell at boundary means inactive.
	  
	  write algo to get state after n days
	  
	 */
}
