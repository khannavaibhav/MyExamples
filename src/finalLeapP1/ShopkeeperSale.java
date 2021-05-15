package finalLeapP1;

import java.util.regex.*;
import java.util.*;

public class ShopkeeperSale {

	public static void main(String[] args) {
		ShopkeeperSale s = new ShopkeeperSale();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] cell = new int[] {1, 3, 3, 2, 5};
		int pointer = 0;int anchor = 0;
		int sum = 0;
		List<Integer> res = new ArrayList<>();
		while(pointer<cell.length-1) {
			if(pointer == anchor) {
				anchor++;
				while(anchor < cell.length && cell[pointer] < cell[anchor]) {
					anchor++;
				}
				if(anchor==cell.length ) {
					sum+=cell[pointer];
					res.add(pointer);
					pointer++;
					anchor=pointer;
				}
			}
			else {
				if(cell[pointer] >= cell[anchor]) {
					sum+=cell[pointer]-cell[anchor];
					pointer++;
				}
			}
		}
		sum+=cell[pointer];
		res.add(pointer);
		System.out.println(sum + " -> "+res);
		return "END";
    }
	
}
/*
A shopkeeper has a sale to complete and has arranged the items being sold in a list.
Starting from the left, the shop keeper rings up each item at its full price less the price of the first lower or equally priced item to its right.
If there is no item to the right that costs less than or equal to the current item's price the current item is sold at full price.

Assumptions
The first and second items would each be discounted by 1 unit, the first equal or lower price to the right.
The item priced 1 unit would sell at a full price.
The next item, at 2 units, would be discounted 2 units as would the 4 unit item.
The sixth and final item must be purchased at full price.

Input
The input consists of one arguments:

items_prices : a list of integers representing the price of items

Output
return total cost of all items on the first line and on the second line print a space separated list of integers representing the indexes of the non- discounted items in ascending index order.

Constraints
1 <= size(prices) <= 100000
1 <= prices <= 1000000

Examples
Example 1:
Input:
items_prices = [2, 3, 1, 2, 4, 2]

Output:
18
2 5

Explanation:
The total cost is 1+2+1+0+2+2 = 8 units. And 2 and 5 indexes has no discount.

Examples
Example 2:
Input:
items_prices = [5, 1, 3, 4, 6, 2]

Output:
14
1 5

Examples
Example 3:
Input:
items_prices = [1, 3, 3, 2, 5]

Output:
9
0 3 4
 * */
 