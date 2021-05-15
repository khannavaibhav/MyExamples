package facebook;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class timezone {

	public static void main(String[] args) {
		timezone s = new timezone();
		
		System.out.println(s.convertPstToPortTimeZone());
	}

	/**
	 * @return
	 */
	public Date convertPstToPortTimeZone(){
		Date date = new Date();
		String timeZoneName = "Asia/Shanghai";
		Date convertedDate = date;
		
		if(date != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String dateStr = dateFormat.format(date);
			try {
				SimpleDateFormat lv_parser = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				lv_parser.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
				Date lv_Date = lv_parser.parse("08-04-2021 10:12");
				System.out.println("LV DATE "+lv_Date);
				
				SimpleDateFormat lv_formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				lv_formatter.setTimeZone(TimeZone.getTimeZone(timeZoneName));
				String convertedDateStr = lv_formatter.format(lv_Date);
				convertedDate = dateFormat.parse(convertedDateStr);
				System.out.println("convertedDate "+convertedDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return convertedDate;
	}
	
}


/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 