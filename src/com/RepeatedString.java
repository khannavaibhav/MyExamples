package com;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

	static long repeatedString(String s, long n) {
		
		int len = s.length();
		//StringBuilder sample = new StringBuilder();
		long count = 0;
		char[] sample = new char[len];
		if(n<=len) {
			s.getChars(0, (int)n, sample, 0);
			count = getCount(sample);
		}
		else {
			s.getChars(0, len, sample, 0);
			long countInSample = getCount(sample);
			System.out.println("sample " + sample.toString());
			System.out.println("countInSample " + countInSample);
			long repeat = n/len;
			long mod = n%len;
			sample = new char[(int)mod];
			s.getChars(0, (int)mod, sample, 0);
			System.out.println("sample " + sample.toString());
			long countInMod = getCount(sample);
			
			
			System.out.println("repeat " + repeat);
			System.out.println("mod " + mod);
			System.out.println("countInMod " + countInMod);
			
			count = countInSample*repeat + countInMod;
		}

		return count;
    }
	static long getCount(char[] sample) {
		long count = 0;
		for(int i =0;i<sample.length;i++) {
			if(sample[i] == 'a' ) {
				count++;
			}
		}
		return count;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);
        scanner.close();
    }
}