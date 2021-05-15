package finalLeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

//	Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
//
//			Return list of lists of the suggested products after each character of searchWord is typed. 
//
//			 
//
//			Example 1:
//
//			Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
//			Output: [
//			["mobile","moneypot","monitor"],
//			["mobile","moneypot","monitor"],
//			["mouse","mousepad"],
//			["mouse","mousepad"],
//			["mouse","mousepad"]
//			]
//			Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
//			After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
//			After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
	
	public static void main(String[] args) {
		List<List<String>> r = suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
		for(int i =0;i<r.size();i++) {
			System.out.println(r.get(i));
		}
		
	}


	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //2:15
        Arrays.sort(products);
        String s = "";
        List<String> l = new ArrayList<String>(3);
       List<List<String>> res = new ArrayList<List<String>>(searchWord.length());
        for(int i = 0;i<searchWord.length();i++){
            int count = 0; 
            l = new ArrayList<String>(3);
            s = s+searchWord.charAt(i);
            int index = 0;
            while (count<3 && index<products.length){
                String w = products[index++];
                if(w.startsWith(s)){
                    l.add(w);
                    count++;
                }
            }
            res.add(l);
            
        }
        return res;
    }
}
