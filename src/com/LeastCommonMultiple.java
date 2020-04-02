package com;

import java.util.Arrays;

public class LeastCommonMultiple {

	public static void main(String[] args) {
		int[] arr = new int[]{4,5,6,3};
		System.out.println(getLCM(arr));
	}
	
	static int getLCM(int[] arr){
		int devisor = 1;
		int lcm = 1;
		
		int counter = 0;
		while (true){
			Arrays.sort(arr);	
			if(arr[counter] == 0) return 0;
			else{
				devisor = arr[counter];
				for(int i = 0;i<arr.length;i++){
					if(arr[i] % devisor == 0){
						arr[i] = arr[i]/devisor;
					}
				}
				lcm=lcm*devisor;
			}
			counter++;
			if(counter == arr.length) return lcm;
		}
	}

}
