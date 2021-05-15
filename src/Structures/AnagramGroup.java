package Structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnagramGroup {

	public static void main(String[] args) {
		
		AnagramGroup a = new AnagramGroup();
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat", "fin","ell"};
		System.out.println(a.groupAnagrams(strs));
	}
	
		 public List<List<String>> groupAnagrams(String[] strs) {
		        List<myHash> l = new ArrayList<myHash>();
		        for(String s:strs){
		            char[] c = s.toCharArray();
		            Arrays.sort(c);
		            l.add(new myHash(s,new String(c)));
		        }
		        List<List<String>> res = new ArrayList<List<String>>();
		        List<String> ls = new ArrayList<String>();
		        String c = "";
		        Collections.sort(l);
		        for(myHash h:l){
		        	System.out.println(h.val+ " "+c);
		            if(h.val.equals(c)){
		                if(ls.size() > 0) res.add(ls);
		                ls = new ArrayList<String>();
		            }
		            ls.add(h.key);
		            c = h.val;
		        }
		        res.add(ls);
		        return res;
		    }
		    class myHash implements Comparable<myHash>{
		        String key;
		        String val;
		        
		        public myHash(String k,String v){
		            key = k;val = v;
		        }
		        
		        public int compareTo(myHash m){
		           return m.val.compareTo(val);
		            
		        }
		    }
}
