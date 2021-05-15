package finalLeapP2;

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
		
		int K = 6;
		int[] fore = new int[] {1, 7, 2, 4, 5, 6};
		int[] back = new int[] {3, 1, 2};
		
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		int max = 0;
		for(int x = 0;x<fore.length;x++) {
			if(fore[x]<=K) {
				if(fore[x]>max) max = fore[x];
				map.put(fore[x], x);
			}
		}
		for(int x=0;x<back.length;x++) {
			if(back[x]+max<=K) {
				max = back[x]+max;
			}
		}
		if(map.containsKey(max)) {
			List<Integer>  l = new ArrayList<>();
			l.add(map.get(max));
			l.add(-1);
			res.add(l);
		}
			
		for(int x=0;x<back.length;x++) {
			if(map.containsKey(max-back[x])) {
				List<Integer>  l = new ArrayList<>();
				l.add(map.get(max-back[x]));
				l.add(x);
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
 