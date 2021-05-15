package finalLeapP1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class ACopy {

	public static void main(String[] args) {
		ACopy s = new ACopy();
		//substr1(s);
		
		//substr2();
		
		//marks();
		//dateFormat1(sbm);
		
		String cmdty = "NEW Paper Roll.";
		
		String[] cdl = cmdty.split("\r\n");
		StringBuilder sbcd  = new StringBuilder();
		for(String l:cdl) {
			if(l.length()>30) {
				String[] ms = l.split(" ");
				String t = "";
				for(String m:ms) {
					if(StringUtils.isNotBlank(m)) {
						if((t.length() + m.length()) <30) {
							t=t.length()>0?(t+" " +m):m;
							continue;
						}
						else {
							sbcd.append(t);
							sbcd.append("\r\n");
							t="";
						}
						while(m.length() > 30) {
							sbcd.append(m.substring(0,30));
							sbcd.append("\r\n");
							m= m.substring(30);
						}
						sbcd.append(m);
						sbcd.append("\r\n");
					}
				}
				sbcd = new StringBuilder(sbcd.substring(0, sbcd.length() -2));
			}
			else sbcd.append(l);
			sbcd.append("\r\n");
		}
		
		System.out.println(sbcd.substring(0, sbcd.length() -2));
		
	}

	private static void marks() {
		String mrk = "1234567890 1234567890\r\n1234567890 12345678901234567890";
		String[] lines = mrk.split("\r\n");
		StringBuilder sbm  = new StringBuilder();
		for(String l:lines) {
			String[] ms = l.split(" ");{
				for(String m:ms) {
					if(StringUtils.isNotBlank(m)) {

						while(m.length() > 20) {
							sbm.append(m.substring(0,20));
							sbm.append("\r\n");
							m= m.substring(20);
						}
						sbm.append(m);
						sbm.append("\r\n");
					}
				}	
				sbm  = new StringBuilder(sbm.substring(0, sbm.length() -2));
			}
			sbm.append("\r\n");
		}
		System.out.println(sbm.substring(0, sbm.length() -2));
	}

	private static void dateFormat1(StringBuilder sbm) {
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Calendar  sailDate = Calendar.getInstance();
		System.out.println(sailDate.getTime());
		
		String dtStr = f.format(sailDate.getTime());
		String dttime = dtStr.substring(0,11) + "12:00";;
		try {
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(f.parse(dttime));
	        System.out.println(calendar.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void substr2() {
		String[] custStr = "NATIONAL OCEANIC-NATO66".split("-");
		int index = 0;
		String custName = custStr[index++];
		while(index < custStr.length -1){
			custName = custName + "-" + custStr[index++];
		}
		if(custStr[index].length()>6 && custName.length()+custStr[index].length() <=50){
			custName = custName + "-" + custStr[index];
		}
		
		System.out.println(custName);
	}

	private static void substr1(ACopy s) {
		String c = "C1223I";
		
		c = c.substring(0,c.indexOf("I"));
		System.out.println(c);
		System.out.println(s.solution().toString());
	}

	/**j
	 * @return
	 */
	public String solution() {
		
//		double d = (double)5/(double )2;
//		System.out.println(Math.floor(d));
		return "END";
    }
	
}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, â€˜Xâ€™, â€˜+â€™, or â€˜Zâ€™. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */