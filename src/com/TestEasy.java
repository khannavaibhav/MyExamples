package com;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//plusMinus(new int[] {-4, 3, -9, 0, 4, 1 });
		//miniMaxSum(new int[] {256741038, 623958417, 467905213, 714532089, 938071625 });
		//int a = 5%3;
		//System.out.println(a);
		
		//arrays();
		
		finalInstances(1, new int[] {30,15,18,18,19,89,15,18,18,19,89,15,18,18,19,89,15,18,18,19,89,15,18,18,19,89});
		
	}
	

    /**
     * @param instances
     * @param averageUtil
     * @return
     */
    public static int finalInstances(int instances, int[] averageUtil) {
        int i = 0;
        while(i<averageUtil.length){
            if(averageUtil[i] <25 && instances>1){
            	System.out.println("less "+i);
                if(instances%2==1) instances++;
                instances /=2;
                i+=10;
                
            }
            else if(averageUtil[i] >60 && instances<10E8){
            	System.out.println("more "+i);
                instances *=2;
                i+=10;
                
            }
            i++;
        }
        return instances;
    }

	
	static void arrays() {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		
		a.add(1);
		a.add(3);
		
		//b = new ArrayList<Integer>(a); 
		//b = a;
		b.addAll(a);
		
		a.set(0, 6);
		
		for(int i :a){
			System.out.println("A " +i);
		}
		for(int i :b){
			System.out.println("B " +i);
		}
	}
	
	static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long min = (long)arr[0]+ (long)arr[1]+  (long)arr[2] +  (long)arr[3];
        long max =  (long)arr[4]+ (long)arr[1]+  (long)arr[2] +  (long)arr[3];
        System.out.print(min + " " + max);

    }

	static void plusMinus(int[] arr) {
		int l = arr.length;
		float p=0,n=0,z=0;
		for (int i =0; i<l;i++) {
			if(arr[i] > 0) p++;
			else if(arr[i] < 0) n++;
			else z++;
		}

		float pf = p/l;
		float nf = n/l;
		float zf = z/l;
		
		BigDecimal bd = new BigDecimal(Double.toString(pf));
	    bd = bd.setScale(6, RoundingMode.HALF_UP);
	    
	    System.out.println(bd);
	    bd = new BigDecimal(Double.toString(nf));
	    bd = bd.setScale(6, RoundingMode.HALF_UP);
	    
	    System.out.println(bd);
	    bd = new BigDecimal(Double.toString(zf));
	    bd = bd.setScale(6, RoundingMode.HALF_UP);
	    
	    System.out.println(bd);
		
		/*DecimalFormat df = new DecimalFormat("#.######");
		
		System.out.println(df.format(pf));
		System.out.println(df.format(nf));
		System.out.println(df.format(zf));*/
    }
}
