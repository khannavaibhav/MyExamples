package com;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.DateFormatter;


public class TestGeneral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "false");
    	props.put("mail.debug", "false");
    	props.put("mail.smtp.from", "abc@xyz.com");

    	Properties properties = new Properties();
    	properties = System.getProperties();
    	
    	for(Object p:properties.keySet()){
    		System.out.print("KEY "+p);
    		System.out.println("  -  VAL "+properties.getProperty((String)p));
    	}*/
		
		Set a = new HashSet();
		a.add("1234");
		a.add("1234");
		a.add("1234");
		a.add("1234");
		a.add("1234");
		System.out.println("SIZE "+a.size());
		
		DateFormatter df = new DateFormatter();
		
		LocalDate dt = LocalDate.of(2015, 8, 5);
		System.out.print(dt.getDayOfWeek().name());
    	
	}

}
