package finalLeapP2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) {
		PatternMatcher s = new PatternMatcher();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		String text = "AAA BBBB AAA AAAAAA AAA!";
		Pattern pattern = Pattern.compile("AAA");
		Matcher matcher = pattern.matcher(text);
		int count = 0;
		while (matcher.find()) {
		    count++;
		}

		System.out.println(count);
//		text = matcher.replaceAll(" ");
		return "END";
    }
	
}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 