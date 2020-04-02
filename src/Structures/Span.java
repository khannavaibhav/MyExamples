package Structures;

public class Span {

	public static void main(String[] args) {

		int[] a = new int[]{6,3,4,5,2,7,8,9,11,17,3};
		
		int max = Integer.MIN_VALUE;
		int span = 1;
		for(int i = 0;i < a.length-1; i++) {
			System.out.println(a[i] +" "+ a[i+1] + " "+ (a[i]<a[i+1]));
			
			if(a[i]<a[i+1]) span++;
			else {
				if (span > max) max = span;
				span = 1;
			}
		}
		System.out.println("SPAN "+max);
		
	}

}
