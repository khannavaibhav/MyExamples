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
		
		commodityDesc();
		
		//marks();
		//dateFormat1();
		
		//StringBuilder sbcd = paperRoll();
		//System.out.println(sbcd.substring(0, sbcd.length() -2));
		
//		int intC = '，';
// 		System.out.println("ASCII Value of ， is "+intC);
// 		
//		 intC = ',';
// 		System.out.println("ASCII Value of , is "+intC);
		
	}

	private static StringBuilder paperRoll() {
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
		return sbcd;
	}

	
	private static void commodityDesc() {
		
		String cmdty = "Pams Table Knives 4pk		\r\n"
				+ "Pams Table Forks 4pk		\r\n"
				+ "FG SS Dessert Spoon 4pk		\r\n"
				+ "Redberry Clawclip Non Slip Small Asstd 2 Pack		\r\n"
				+ "FG SG Kitchen Scissors		\r\n"
				+ "FG Ramekin 9cm		\r\n"
				+ "FG Ramekin 11cm		\r\n"
				+ "Pams Measuring Jug 1L		\r\n"
				+ "Redberry S/less Elastics Thk Colour 12Pk		\r\n"
				+ "Redberry Seamless Elastics Sm Blk 30 Pk		\r\n"
				+ "Redberry S/less Sml Colour 30Pk		\r\n"
				+ "Redberry Snagless Elastics Med Clr 50 Pk		\r\n"
				+ "Pams Mixing Bowl Set 1.5,2,2.5L		\r\n"
				+ "Number Candle 0		\r\n"
				+ "Candles Spiral with Holders		\r\n"
				+ "7cm Patterned Candles		\r\n"
				+ "Candles Spiral with Holders Large		\r\n"
				+ "Partystar Twist & Twirl Candles 12pk		\r\n"
				+ "BUBBLE FUN 		\r\n"
				+ "Pams Cheese Slicer		\r\n"
				+ "Pams Premium S/S Slotted Turner		\r\n"
				+ "Pams Premium S/S Hand Grater		\r\n"
				+ "FG Tong Silicone Head 23cm with Acacia Handle		\r\n"
				+ "FG Nylon Slotted Turner with Acacia Handle		\r\n"
				+ "FG  Nylon Head Mini Tongs 18cm 2pk with Acacia Handle 		\r\n"
				+ "Delicate Washing Bag 		\r\n"
				+ "Sieve 18cm		\r\n"
				+ "Pams Paring Knife with Cover\r\n"
				+ "HS CODE:340600\r\n"
				+ "Approval number NH091422010324CB for wax candles and bubble water";
		
		if(StringUtils.isNotBlank(cmdty)) {
			int index = 0;
			String[] cdl = cmdty.split("\r\n");
			StringBuilder sbcd  = new StringBuilder();
			
			if(cdl[0].length()>30) {
				String s = cdl[0].substring(0,30);
				int id = s.lastIndexOf(" ");
				if(id >0) {
					sbcd.append(s.substring(0,id));
					sbcd.append("\r\n");
					cdl[0]=cdl[0].substring(id+1);
				}
				else {
					sbcd.append(s);
					sbcd.append("\r\n");
					cdl[0]=cdl[0].substring(30);
				}
			}
			else {
				index = 1;
				sbcd.append(cdl[0]);
				sbcd.append("\r\n");
			}
			for(int i=index;i<cdl.length;i++) {
				String s = cdl[i];
				s=s.trim();
				while(s.length()>60) {
					String p = s.substring(0,60);
					int idx = p.lastIndexOf(" ");
					if(p.length()>30 &&  idx == -1) {
						p = p.substring(0,30)+" "+p.substring(30);
					}
					if(idx >31) {
						String r = p.substring(0,idx);
						sbcd.append(r);
						sbcd.append("\r\n");
						s=s.substring(idx+1);
					}
					else {
						sbcd.append(p);
						sbcd.append("\r\n");
						s=s.substring(60);
					}
				}
				if(s.length()>0) {
					if(s.length()>30 && s.indexOf(" ") == -1) {
						s = s.substring(0,30)+" "+s.substring(30);
					}
					sbcd.append(s);
					sbcd.append("\r\n");
				}
				cmdty = sbcd.substring(0, sbcd.length() -2);
			}
		}
		System.out.println("Commodity::: \n" + cmdty);
		
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

	private static void dateFormat1() {
		
		StringBuilder sbm = new StringBuilder();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date currentDate = Calendar.getInstance(TimeZone.getTimeZone("")).getTime();
		
		
		SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
		System.out.println("AM?PM "+a.format(currentDate));
		
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
		
		System.out.println("AAA "+Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid")).getTime());
		
		Date date = new Date();
		
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
			System.out.println("Date string Madrid: " + df.format(date));
			DateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = dff.parse(df.format(date));
			System.out.println("Date and time in Madrid: " + date);
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
		
		c = "MATS3419218000";
		c = c.substring(4,11);
		System.out.println(c);
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