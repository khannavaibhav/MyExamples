package Structures;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


/**
 * @author vkhanna
 *
 */
public class TestGeneral {

	public static void main(String[] args) {
		
		System.out.println('p'^ 'b'^'a'^'c');
		System.out.println('p' - 'b');
//		System.out.println('z'^'z'^'z');
//		System.out.println('A'^'A'^'A');
//		System.out.println('Z'^'Z'^'Z');
//		System.out.println((int)'?');
//		
//    	StringBuilder sb = new StringBuilder();
//    	sb.append('C');
//    	sb.append('A');
//    	System.out.println(sb.toString());
//    	
//    	String s3 = "\u0041\u00DF\u6771\uD801\uDC00"; 
//    	System.out.println(s3.charAt(4)); 
//    	System.out.println(s3.codePointAt(4));
		int a = 1^ 2 ^ 3 ^ 4 ^ 5;
		int b = 1^ 2 ^ 3 ^ 4 ^ 5 ^ 4;
		System.out.println(a^b);
		
		System.out.println("------------------------");
		System.out.println(2^2^4);
		System.out.println(3^3^4);
	}

}
