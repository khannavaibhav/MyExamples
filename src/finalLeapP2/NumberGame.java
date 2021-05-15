package finalLeapP2;

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
        int h = Arrays.hashCode(nums);
        Pair<Integer, Integer> p = new ImmutablePair<>(h, t);
        if (map.containsKey(p)) return map.get(p);
        for (int i = 0; i+1 < nums.length; i++) {
            if (nums[i] == 0) continue;
             
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == 0) continue;
                int t1 = nums[i];
                int t2 = nums[j];
                nums[i] = nums[j] = 0;
                max = Math.max(max, t*gcd(t1,t2) + dfs(nums, t+1));
                nums[i] = t1;
                nums[j] = t2;
            }
        }  
        map.put(p, max);
        return max;
    }
    
    int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x%y);
    }
}