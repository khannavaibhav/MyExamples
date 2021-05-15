package finalLeapP2;

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
		
		int[] priceOfJeans = new int[] {4,7};
		int[] priceOfShoes = new int[] {6,6};
		int[] priceOfSkirts = new int[] {1,3,5};
		int[] priceOfTops = new int[] {5,7,12};
		int budgeted = 20;
		
		List<Integer> flip = new ArrayList<>();
		List<Integer> flop = new ArrayList<>();
		
		for(int i:priceOfJeans) {
			if(i<= budgeted)flip.add(i);
		}
		for(int i:priceOfShoes) {
			for(int j:flip) {
				if(i+j<= budgeted)flop.add(i+j);
			}
		}
		flip.clear();
		for(int i:priceOfSkirts) {
			for(int j:flop) {
				if(i+j<= budgeted)flip.add(i+j);
			}
		}
		flop.clear();
		for(int i:priceOfTops) {
			for(int j:flip) {
				if(i+j<= budgeted)flop.add(i+j);
			}
		}
		return flop.size();
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
 