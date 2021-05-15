package com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class test1 {

	public static void main(String[] args) throws ParseException {
		//getCharCount("combination");
		//binarySearch(new int[] {1,2,3,4,5,6,7,8},1);
		//dateFormat();
		
		//stringSplit();
		String d1 = "06-Oct-2020 23:00";
		String d2 = "14-Oct-2020 08:00";
		
		String latitude1 =  "61.2180556";
		String  longitude1 =  "-149.9002778";
		String latitude2 =  "47.2528768";
		String longitude2 = "-122.4442906";
		
		SimpleDateFormat dateddMonFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		Date currDate = new Date(); 
		Date sailDt = dateddMonFormatter.parse(d1);
		Date arrivalDt = dateddMonFormatter.parse(d2);
		if(currDate.after(sailDt) && currDate.before(arrivalDt)) {
			int totalVoyageDays = arrivalDt.getDate() - sailDt.getDate();
			System.out.println("totalVoyageDays " + totalVoyageDays);
			int completedDays = currDate.getDate() - sailDt.getDate();
			System.out.println("completedDays " + completedDays);
			double percentCompleted = 100*completedDays/totalVoyageDays;
			System.out.println("percentCompleted " + percentCompleted);
			
			Double lat1 = Double.valueOf(latitude1);
			Double lon1 = Double.valueOf(longitude1);
			Double lat2 = Double.valueOf(latitude2);
			Double lon2 = Double.valueOf(longitude2);
			
			System.out.println("lat1 " + lat1);
			System.out.println("lon1 " + lon1);
			System.out.println("lat2 " + lat2);
			System.out.println("lon2 " + lon2);
			
			Double lat = (lat2-lat1)*percentCompleted/100 + lat1;
			Double lon = (lon2-lon1)*percentCompleted/100 + lon1;
			
			System.out.println("lat " + lat);
			System.out.println("lon " + lon);
		}
		
	}


	private static void stringSplit() {
		String vvd = "RJP 442 E";
		String vs = vvd.substring(0,3);
		String vy = vvd.substring(4,7);
		String d =vvd.substring(8);
		System.out.println(vs+vy+d+"AAA");
	}


	private static void dateFormat() {
		DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		DateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date effectiveDate = formatter.parse("2020-02-05 13:46:43");
			Date effectiveDate2 = formatter2.parse("12/01/0001");
			Date a = new Date();
			String as = formatter.format(a);
			effectiveDate  = a;
			effectiveDate2 = a;
			System.out.println(a);
			System.out.println(as);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
