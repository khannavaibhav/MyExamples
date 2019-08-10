package com;

import java.util.Scanner;

public class CountingValleys {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        
        /*
         * nt n = 1000000;
		String s = "";
		int f = 0;
		for (int i =0; i<n;i++) {
			if(f==0) {
				s= new String(s + "D");
				f=1;
			}
			else {
				s= new String(s + "U");
				f=0;
			}
		}
		System.out.println(s);
         */

        int result = countingValleys(n, s);

        System.out.println(result);

        scanner.close();

	}
	
	static int countingValleys(int n, String s) {
		char[] dst = new char[n];
		int step = 0;
		int valleys = 0;
		boolean isBelowSeaLevel = false;
        s.getChars(0, dst.length, dst, 0);
        for (int i = 0; i < n ; i++) {
        	isBelowSeaLevel = step < 0?true:false;
        	step = dst[i] == 'D'?(step - 1):(step + 1);
        	if(isBelowSeaLevel && step == 0) {
        		valleys++;
        	}
        }
        return valleys;
    }

}
