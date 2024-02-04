import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String overrideInitialCarriage = " MATSON kamokuikiV033S ";
		//gatesCall(overrideInitialCarriage);
		//cbprCall(overrideInitialCarriage);
		
		//checkEmails();
		//checkAddressAbbr();
//		Long a = -1922L + 45000L;
//		System.out.println(a.toString());
		//commDesc();
		
		Date javaDate= DateUtil.getJavaDate((double) 44560);
        String s = new SimpleDateFormat("yyyy-MM-dd").format(javaDate);
        System.out.println(s);
	}
	
	private static void commDesc() {
		
//		String commdesc = "01234567890123456789012345 6789012345678901234567890123456789012345 678901234567890123456789012345678901234567890123456789";
		String commdesc = "LG-208SC BACK BAR SHOWCASES\r\n"
				+ "LG-330HC BACK BAR SHOWCASES\r\n"
				+ "LG-330SC BACK BAR SHOWCASES";
		if(StringUtils.isNotBlank(commdesc)) {
			String cmdty = commdesc;
			int index = 0;
			String[] cdl = cmdty.split("\r\n");
			StringBuilder sbcd  = new StringBuilder();
			
			System.out.println("OOO - "+cdl[0]);
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
			System.out.println("AAA - "+sbcd.toString());
			System.out.println("BBB - "+cdl[0]);
			
			for(int i=index;i<cdl.length;i++) {
				String s = cdl[i];
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
				System.out.println("\n\n -------------------------------");	
				
				System.out.println(sbcd.substring(0, sbcd.length() -2));
			}
			System.out.println("-------------------------------");	
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
	}
	
	
	private static void checkEmails() {
		
		String urls ="";
		String arg0 = "mkaliaperumal@matson.com, vkallepalli@matson.com, PANPAN@PUDONGTRANSUSA.COM";

		if(StringUtils.isNotBlank(arg0)){
			if( arg0.indexOf(",") > 0) {
				String e1 = arg0.substring(0, arg0.indexOf(","));
				String e2 = arg0.substring(arg0.indexOf(",")+2);
				System.out.println(e1);
				System.out.println(e2);
				urls = "<a class='resultlink' rel='tooltip' title='"+e2+"'>"+e1+"</a>";
			}
			else {
				urls = "<a class='resultlink' rel='tooltip'>"+arg0+"</a>";
			}
			
		}
		System.out.println(urls);
		
	}
	
	
	
	
	private static void checkAddressAbbr() {
		String address = "WELL-TRANS LOGISTICS (CHINA) CO.,LTD- 123456";
		if( StringUtils.isNotBlank(address) 
				&& address.indexOf("-")!=-1) {
			String abbriviation = address.substring(address.lastIndexOf("-")+1);
			abbriviation = abbriviation.trim();
			System.out.println("---> "+abbriviation);
			if(abbriviation.length() <7) {
				
				System.out.println("---> "+address.substring(0,address.lastIndexOf("-")));
			}
		}
	}

	private static void cbprCall(String overrideInitialCarriage) {
		
		String vessel = "", voyage="";
		overrideInitialCarriage = overrideInitialCarriage.toUpperCase();
		
		if(StringUtils.isNotBlank(overrideInitialCarriage)) {
			String vesselVoyage = StringUtils.trim(overrideInitialCarriage);
			String delimiter = " "; 
			if(vesselVoyage.indexOf("/")>0) delimiter = "/";
			else if(vesselVoyage.indexOf("V.")>0) delimiter = "V.";
			else if(vesselVoyage.indexOf("V")>0) delimiter = "V";
			
			String[] vvd =  vesselVoyage.split(delimiter);
			
			vessel = vvd[0].trim();
			if(vvd.length>1) {
				voyage = vvd[vvd.length-1].trim();
				for(int idx = 1;idx<vvd.length-1;idx++) {
					vessel = vessel + " " + vvd[idx].trim();
				}
			}
			vessel = StringUtils.trim(vessel);
		}
		
		
		System.out.println("CBPR VESSEL: "+vessel);
		System.out.println("CBPR VOYAGE: "+voyage);
	}
	
	private static void gatesCall(String overrideInitialCarriage) {
		String vessel = "", voyage="",dir = "";
		
		if(overrideInitialCarriage.contains("V.") || overrideInitialCarriage.contains("V ")) {
			List<String> initialCarriageList ;
			if(overrideInitialCarriage.contains("V."))
				initialCarriageList = Arrays.asList(trimToEmptyObj(overrideInitialCarriage).split("V."));
			else{
				initialCarriageList = Arrays.asList(trimToEmptyObj(overrideInitialCarriage).split("V "));
			}
			if(initialCarriageList != null && !initialCarriageList.isEmpty()) {
				int i = 0;
				for(String initCarriage : initialCarriageList) {
					if(i == 0) {
						vessel = initCarriage.trim();
					} else {
						//String reverseVoyage = getReverseVoyage(initCarriage);
						String reverseVoyage = "";
						String reverse = new StringBuffer(initCarriage).reverse().toString();
						Character c = reverse.charAt(0);
						if(c.equals('E') || c.equals('W') || c.equals('S') || c.equals('N')) {
							System.out.println("Override Initial carriage direction is : " + c);
							reverseVoyage = reverse;
						} else {
							System.out.println("Last carriage of Override Initial carriage is : " + c);
							reverseVoyage = reverse.substring(1, reverse.length());
						}

						
						if(reverseVoyage != null && reverseVoyage.length() >0) {
							String voy = new StringBuffer(reverseVoyage).reverse().toString();
							voyage = voy.trim().substring(0, voy.length()-1);
						} else {
							voyage = "";
						}
					}
					i++;
					
				}
			}
		} else {
			
			String initialCarriage = new StringBuffer(overrideInitialCarriage).reverse().toString();
			
			List<String> reverseInitialCarrgList = Arrays.asList(trimToEmptyObj(initialCarriage).split(" "));
			
			if(reverseInitialCarrgList != null && !reverseInitialCarrgList.isEmpty()) {
				int temp = 0;
				for(String reverseInitCarriage : reverseInitialCarrgList) {
					if(temp == 0) {
						String reverseVoyage = reverseInitCarriage.substring(1, reverseInitCarriage.length());
						voyage = new StringBuffer(reverseVoyage.trim()).reverse().toString();
														
					} else {
						vessel = vessel + reverseInitCarriage.trim() +" ";
					}
					temp++;
				}
				
				if(vessel != null) {
					String reverseFeederVesselName = vessel;
					vessel = new StringBuffer(vessel.trim()).reverse().toString();
				}
			}
		}
		System.out.println("VESSEL: "+vessel);
		System.out.println("VOYAGE: "+voyage);
		System.out.println("DIRECTION: "+dir);
	}
	
	public static String trimToEmptyObj(Object str) {
        if(str==null) return "";
        String str1 = str.toString();
        return StringUtils.trimToEmpty(str1);
    }

}
