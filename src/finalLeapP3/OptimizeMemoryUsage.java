package finalLeapP3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimizeMemoryUsage {

	public static void main(String[] args) {
		OptimizeMemoryUsage s = new OptimizeMemoryUsage();
		System.out.println(s.score().toString());
	}

	public String score() {
		
		int k = 10;
		int[] fore = new int[] {1, 7, 2, 4, 5, 6};
		int[] back = new int[] {1, 1, 2, 9};
		//1. Find Max
		int max = 0;
		for(int x:fore) {
			if(x<=k && x>max) max = x; 
		}
		int maxB = 0;
		if(max < k) {
			
			for(int x:back) {
				if(max+x <= k) max = max+x;
				if(x<=k) maxB = Math.max(maxB, x);
			}
		}
		if(max<k) {
			if(maxB==k) max = maxB;
			else {
				for(int x:fore) {
					if(maxB+x <= k) max = Math.max(maxB+x, max);
				}
			}
		}
		System.out.println("- "+max);
		List<List<Integer>> res = new ArrayList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		for(int i = 0;i<fore.length;i++) {
			if(fore[i] == max) {
				List<Integer> l = new ArrayList<>();
				l.add(i);
				l.add(map.get(max-fore[i]));
				res.add(l);
			}
			else if(fore[i]<max){
				map.put(fore[i],i);
			}
		}
		for(int i = 0;i<back.length;i++) {
			if(map.containsKey(max-back[i])) {
				List<Integer> l = new ArrayList<>();
				l.add(map.get(max-back[i]));
				l.add(i);
				res.add(l);
			}
		}
		
		
		return "WINNER " + res;
    }

}
/*
Give a computer with total K memory space, and an array of foreground tasks and background tasks the computer needs to do. 
Write an algorithm to find a pair of tasks from each array to maximize the memory usage. 
Notice the tasks could be done without origin order.

Input
The input to the function/method consists of three arguments :
foregroundTask, an array representing the memory usage of the foreground tasks,
backgroundTask, an array representing the memory usage of the background tasks,
K, the total memory space of the computer.

Output
Return a list of pairs of the task ids.

Examples 1
Input:
foregroundTasks = [1, 7, 2, 4, 5, 6]
backgroundTasks = [3, 1, 2]
K = 6

Output:
[(3, 2), (4, 1), (5,-1)]

Explaination:
Here we have 5 foreground tasks: task 0 uses 1 memeory. task 1 uses 7 memeory. task 2 uses 2 memeory..
And 5 background tasks: task 0 uses 3 memeory. task 1 uses 1 memeory. task 2 uses 2 memeory..
We need to find two tasks with total memory usage sum <= K.
Here we can return the foreground task 3 and background task 2, which total use 6 units of memory.
Or we can return the foreground task 4 and background task 1. Also use total 6 units of memory.
Or we can return the foreground task 5 only without any background task. Also use total 6 units of memory.

Examples 2
Input:
foregroundTasks = [1, 7, 2, 4, 5, 6]
backgroundTasks = [1, 1, 2]
K = 10

Output:
[(1, 2)]

Explaination:
Here we can return the foreground task 1 and background task 2. Total memory usage is 7 + 2 = 9,
 which is smaller than 10. Given there is no larger better memory usage combination than 9 , this is the optimal solution.
 * */
 