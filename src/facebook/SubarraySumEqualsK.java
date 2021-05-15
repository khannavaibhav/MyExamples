package facebook;

import java.util.HashSet;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		SubarraySumEqualsK s = new SubarraySumEqualsK();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		
		int[] nums = new int[] {1,2,3,4};
		int k = 3;

        int count = 0;
        HashSet<Integer> rem = new HashSet<>();
        rem.add(0);
        rem.add(nums[0]%k);
        for(int i = 1;i<nums.length;i++) {
        	System.out.println(rem);
        	nums[i] = nums[i-1]+nums[i];
        	int x = nums[i]%k;
        	if(rem.contains(x)) count++;
        	else rem.add(x);
        }
   	
		return "END "+count;
    }
	
}


/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 