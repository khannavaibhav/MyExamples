package finalLeapP3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class NumberGame {

	public static void main(String[] args) {
		NumberGame s = new NumberGame();
		
		System.out.println(s.solution());
	}
	Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

	/**
	 * @return
	 */
	public int solution() {
		
		int[] nums = new int[] {8, 5, 6, 25, 6, 16};
		return dfs(nums, 1);

    }
	
	int dfs(int[] nums, int t) {
        int max = 0;

        for(int i = 0;i<nums.length-1;i++) {
        	if(nums[i] == 0) continue;
        	
        	for(int j = i+1;j<nums.length;j++) {
        		if(nums[j]==0) continue;
        		int n1 = nums[i];
        		int n2 = nums[j];
        		nums[i] = nums[j] = 0;
        		int score = t*gcd(n1,n2) +  dfs(nums,t+1);
        		max = Math.max(max, score);
        		nums[i] = n1;
        		nums[j] = n2;
        	}
        }
        
        return max;
    }
    
	int gcd(int x,int y) {
		if(y==0)return x;
		return gcd(y,x%y);
	}

}


/*
 You're given an Array of 2N +ve integers and N operations. 
 In each operation, you can select any two +ve integers from the array

Your score in each round will be gcd(num1, num2) * operation number, 
where num1 and num2 are the selected numbers and operation number is the current operation.
 
Your total score will be the sum of all the scores.
Your goal is to maximize the above total score and return the maximum total score

N (No of operations) -> 1 <= N <= 10

1 <= num <= 10^9

Example:
N = 2, Arr = [3,4,9,5]
Max score is 1 * gcd(4,5) + 2 * gcd(3, 9) = 7 
 */
 