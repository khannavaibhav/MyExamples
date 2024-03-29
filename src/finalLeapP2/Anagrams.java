package finalLeapP2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

public class Anagrams {

	public static void main(String[] args) {
		Anagrams s = new Anagrams();
		List<String> l = new ArrayList<>();
		Set<String> set = new HashSet<>();
		s.solution("aabc","",l,set);
		System.out.println(l);
		System.out.println(set);
		
	}

	/**
	 * @return
	 */
	public void solution(String s, String r, List<String> l,Set<String> set) {
		
		if(r.length() >0) set.add(r);
		if(s.length() == 0) {
			l.add(r);
			return;
		}
		for(int i = 0;i<s.length();i++) {
			String x = s.substring(0,i) + s.substring(i+1);
			solution(x,r+s.charAt(i),l,set);
		}
    }
	
}
/*

 * */
 