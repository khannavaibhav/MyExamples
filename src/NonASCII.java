

import java.util.HashMap;
import java.util.Map;

public class NonASCII{
	
	Map<Integer,Character> asciiDictionary = new HashMap<>();
	
	public static void main(String[] args) {
		NonASCII s = new NonASCII();
		//String message = "‘~ ~，~（~）~| |‚| | | |‘|’|“|”|–| | |";
		
		String message = " ";
	    System.out.println(s.solution(message));
		
		
		//Pair<String,String> p = s.solution(message);
		//System.out.println(p.toString());
		
		//System.out.println(p.getRight());
	}
	
	public String solution(String messages) {
		
		asciiDictionary.put(160, ' ');
		asciiDictionary.put(8216, '\'');
		asciiDictionary.put(65292, ',');
		asciiDictionary.put(65288, '(');
		asciiDictionary.put(65289, ')');
		
		asciiDictionary.put(129, ' ');
		asciiDictionary.put(130, ',');
		asciiDictionary.put(141, ' ');
		asciiDictionary.put(143, ' ');
		asciiDictionary.put(144, ' ');
		asciiDictionary.put(145, '\'');
		asciiDictionary.put(146, '\'');
		asciiDictionary.put(147, '"');
		asciiDictionary.put(148, '"');
		
		asciiDictionary.put(150, '-');
		asciiDictionary.put(157, ' ');
		asciiDictionary.put(160, ' ');
		asciiDictionary.put(180, '\'');
		asciiDictionary.put(8242, '\'');
		asciiDictionary.put(8243, '"');
		asciiDictionary.put(8260, '/');
		asciiDictionary.put(8722, '-');
		asciiDictionary.put(8194, ' ');
		asciiDictionary.put(8195, ' ');
		asciiDictionary.put(8201, ' ');
		asciiDictionary.put(8204, ' ');
		asciiDictionary.put(8205, ' ');
		asciiDictionary.put(8206, ' ');
		asciiDictionary.put(8207, ' ');
		asciiDictionary.put(8211, '-');
		asciiDictionary.put(8216, '\'');
		asciiDictionary.put(8217, '\'');
		asciiDictionary.put(8218, ',');
		asciiDictionary.put(8220, '"');
		asciiDictionary.put(8221, '"');
		
//		asciiDictionary.put('‘', ' ');
//		asciiDictionary.put(' ', '\'');
//		asciiDictionary.put('，', ',');
//		asciiDictionary.put('（', '(');
//		asciiDictionary.put('）', ')');
		
		
		//String message = "SUITE6201A,MAIN BUILDING ,SHUNHING SQUARE,5002";
		
//		for(int x:asciiDictionary.keySet()) {
//			System.out.println("INSERT INTO `cbpr_ref_data_mz` (`ref_data_subject_area`, `ref_data_code`, `description`, `is_active`, `create_user`, `create_date`, `last_update_user`, `last_update_date`) VALUES ('ASCIIDIR', '"+x+"', '"+asciiDictionary.get(x)+"', 'Y', 'ADMIN', NOW(), 'ADMIN', NOW());");
//		}
		String s = messages;
		for(int i=0;i<s.length();i++) {
			System.out.println("char: "+ s.charAt(i));
//			if(asciiDictionary.containsKey((int)s.charAt(i))) {
//				s=s.replace(s.charAt(i), asciiDictionary.get((int)s.charAt(i)));
//			}
			if(s.charAt(i) > 127) {
				System.out.println(" ASCII "+(int)s.charAt(i) );
				System.out.println(" UNICODE "+"\\u" + Integer.toHexString(s.charAt(i) | 0x10000).substring(1) );
				StringBuilder result = new StringBuilder();
				while(i<s.length() && s.charAt(i) > 127) {
					result.append(s.charAt(i));
					i++;
				}
				return result.toString();//Pair.of(result.toString(), null);
			}
		}
		messages = s;
		return messages+" change";
    }
}

	