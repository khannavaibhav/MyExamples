package com;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Socks {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant2(n, ar);

        System.out.println("RESULT "+result);
        
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }

	
	static int sockMerchant(int n, int[] ar) {
		
		String done = "";
		int count = 0;
		int pairs =0;
		for (int i =0; i<n;i++) {
			count = 1;
			if(!done.contains("~"+ar[i]+"~")) {
				for(int j = i+1;j<n;j++) {
					if(ar[i] == ar[j]) count++;
				}
				done = done + "~"+ar[i]+"~";
				pairs = pairs + (count/2);
				System.out.println("for "+ar[i] + " COUNT " + count + " PAIRS " + (count/2) + " TOTAL " + pairs);
			}
		}
		
		return  pairs;
	}
	static int sockMerchant2(int n, int[] ar) {
		
		Set factory = new HashSet(); 
		int pairs = 0;
		for (int i=0;i<n; i++) {
			if(factory.contains(Integer.valueOf(ar[i]))) {
				pairs ++;
				factory.remove(Integer.valueOf(ar[i]));
			}
			else {
				factory.add(Integer.valueOf(ar[i]));
			}
			
		}
		
		
		return  pairs;
	}

}
