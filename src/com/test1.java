package com;

public class test1 {

	public static void main(String[] args) {
		//getCharCount("combination");
		binarySearch(new int[] {1,2,3,4,5,6,7,8},1);
	}
	
	
	public static void binarySearch(int[] input, int searchIt) {
		int start = 0;
		int end = input.length-1 ;
		
		search(start, end, input, searchIt);
		
	}
	
	public static void search(int start, int end, int[] input, int searchIt) {
		int length = (start + end)/2;
		if(searchIt == input[length]) {
			System.out.println("Found at position " + (length+1));
			System.out.println("END ");
		}
		else {
			if (searchIt > input[length] ) {
				start = length+1;
			}
			else {
				end = length;
			}
			System.out.println("start "+(start+1) + " end "+(end+1));
			if(start < input.length)
			{
				search(start, end, input, searchIt);
			}
		}
	}
	
	public static void getCharCount(String input) {
		
		char[] chars = new char[input.length()];
		input.getChars(0, input.length(), chars, 0);
		String done = "";
		String charStr = "";
		for(int i = input.length() -1; i >= 0 ; i--) {
			charStr = ""+chars[i] ;
			if(!done.contains(charStr)) {
				System.out.println("CHAR " + charStr);
				int count = (input.split(charStr,(input.length()-1))).length;
				System.out.println("CHAR count " + (count-1));
				done = done + charStr;
			}
			
		}
	}

}
