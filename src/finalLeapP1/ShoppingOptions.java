package finalLeapP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ShoppingOptions {

	public static void main(String[] args) {
		ShoppingOptions s = new ShoppingOptions();
		System.out.println(s.options());
	}

	public int options() {
		
		int[] priceOfJeans = new int[] {2, 3};
		int[] priceOfShoes = new int[] {4};
		int[] priceOfSkirts = new int[] {2, 3};
		int[] priceOfTops = new int[] {1, 2};
		int budgeted = 10;
		
        List<Integer> options = new ArrayList<>();
        List<Integer> options2 = new ArrayList<>();
        for(int j:priceOfJeans) {
        	if(j<=budgeted) options.add(j);
        }
        
        for(int s:priceOfShoes) {
        	for(int o :options) {
        		if(o+s <=budgeted) options2.add(o+s);
        	}
        }
        options.clear();
        options.addAll(options2);
        options2.clear();
		
        for(int s:priceOfSkirts) {
        	for(int o :options) {
        		if(o+s <=budgeted) options2.add(o+s);
        	}
        }
        options.clear();
        options.addAll(options2);
        options2.clear();
        
        for(int s:priceOfTops) {
        	for(int o :options) {
        		if(o+s <=budgeted) options2.add(o+s);
        	}
        }
		
        return options2.size();
        
    }
    

}
/*
 A customer wants to buy a pair of jeans, a pair of shoes, a skirt, and a top but has a limited budget in dollars. Given different pricing options for each product, determine how many options our customer has to buy 1 of each product. You cannot spend more money than the budgeted amount.

Function Description:
Complete the getNumberOfOptions function in the editor below. The function must return an integer which represents the number of options present to buy the four items.

getNumberOfOptions has 5 parameters:
int[] priceOfJeans: An integer array, which contains the prices of the pairs of jeans available.
int[] priceOfShoes: An integer array, which contains the prices of the pairs of shoes available.
int[] priceOfSkirts: An integer array, which contains the prices of the skirts available.
int[] priceOfTops: An integer array, which contains the prices of the tops available.
int dollars: the total number of dollars available to shop with.

Constraints
1 <= a, b, c, d ≤ 10^3
1 <= dollars ≤ 10^9
1 <= price of each item ≤ 10^9
Note: a, b, c and d are the sizes of the four price arrays

Example
Input:
priceOfJeans = [2, 3]
priceOfShoes = [4]
priceOfSkirts = [2, 3]
priceOfTops = [1, 2]
budgeted = 10

Output:
4
 * */
 