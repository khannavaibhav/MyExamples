

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class ACopy {

	public static void main(String[] args) {
		ACopy s = new ACopy();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		
		String st = "12345I";
		System.out.println(st.substring(st.length()-5));
		
		if(StringUtils.isNotBlank(st) && st.length()>5){
			System.out.println(st.substring(0,5));
		}
		
		return "END";
    }
	
}


/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 