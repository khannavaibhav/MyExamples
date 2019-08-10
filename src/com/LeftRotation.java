package com;

import java.io.IOException;
import java.util.Scanner;

public class LeftRotation {

	static int[] rotLeft(int[] a, int d) {
		
		int[] res = new int[a.length];
		for(int i =0;i<a.length;i++) {
			int n = i+1+d;
			int pos = n-1;
			if(n >a.length) {
				 pos = getValInLimit(a.length,n)-1 ;
				System.out.println("i = " + i);
				System.out.println("n = " + n);
				System.out.println("pos = " + pos);
			}
			
			res[i] =a[pos]; 
		}
		return res;
    }
	
	private static int getValInLimit(int length, int val) {
		int res = val - length;
		if (res == 0) return val;
		if(val > length) getValInLimit(length, res);
		return res;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
            	System.out.println(" ");
            }
        }


        scanner.close();
    }

}
