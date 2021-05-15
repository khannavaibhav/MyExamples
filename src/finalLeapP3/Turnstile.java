package finalLeapP3;

import java.util.LinkedList;
import java.util.Queue;

public class Turnstile {

	public static void main(String[] args) {
		Turnstile s = new Turnstile();
		System.out.println(s.turnstile().toString());
	}

	public int[] turnstile() {
		int n = 16;
		int[] arrTime = new int[] {0,0,1,2,6,6,7,7,7,10,11,12,12,12,12,14};
		int[] direction  = new int[] {0,0,1,1,0,1,1,1,1,1,1,0,1,0,0,0};
		//0,1,2,3,13,6,7,8,9,10,11,14,12,15,16,17
		
//		int n = 4;
//		int[] arrTime = new int[] {1, 1, 2, 6};
//		int[] direction = new int[] {0, 1, 1, 0};
		
		Queue<Integer> enter = new LinkedList<>();
		Queue<Integer> exit = new LinkedList<>();
		for(int i = 0;i<n;i++) {
			if(direction[i]==0)   enter.offer(i);
			else exit.offer(i);
		}
		int prevTime = -2;
		int prevDir = -1;
		int[] res = new int[n];
		while(!enter.isEmpty() ||!exit.isEmpty()) {
			if(!enter.isEmpty() && arrTime[enter.peek()] <= prevTime) arrTime[enter.peek()] = prevTime+1;
			if(!exit.isEmpty() && arrTime[exit.peek()] <= prevTime) arrTime[exit.peek()] = prevTime+1;
			int x = 0;
			if(!enter.isEmpty() && !exit.isEmpty()) {
				if(arrTime[enter.peek()] == arrTime[exit.peek()]) {
					if(arrTime[enter.peek()] - prevTime > 1) {
						x = exit.poll();
					}
					else if(prevDir == 1) x = exit.poll();
					else x = enter.poll();
				}
				else if(arrTime[enter.peek()] < arrTime[exit.peek()]) {
					x = enter.poll();
				}
				else x = exit.poll();
			}
			else if(!enter.isEmpty()) {
				x = enter.poll();
			}
			else x = exit.poll();
			res[x] = arrTime[x];
			prevTime = arrTime[x];
			prevDir = direction[x];
		}
		for(int c : res) {
			System.out.println(c);
		}
		return res;
    }
    

}
/*
A university has exactly one turnstile. It can be used either as an exit or an entrance. 
Unfortunately, sometimes many people want to pass through the turnstile and their directions can be different. 
The ith person comes to the turnstile at time[i] and wants to either
 exit the university if direction[i] = 1 or 
 enter the university if direction[i] = 0. 
People form 2 queues, one to exit and one to enter. They are ordered by the time when they came to the turnstile and, 
if the times are equal, by their indices.

If some person wants to enter the university and another person wants to leave the university at the same moment, 
there are three cases:
If in the previous second the turnstile was not used (maybe it was used before, but not at the previous second),
then the person who wants to leave goes first.
If in the previous second the turnstile was used as an exit, then the person who wants to leave goes first.
If in the previous second the turnstile was used as an entrance, then the person who wants to enter goes first.
Passing through the turnstile takes 1 second.

For each person, find the time when they will pass through the turnstile.

Input
arrTime, an array of n integers where the value at index i is the time in seconds when the ith person will come
direction, a list of integers where the value at indexi is the direction of the ith person.

Output
an array of integers where the value at index i is the time when the ith person will pass the turnstile.

Constraints
1 <= n <= 10^5
0 <= arrTime[i] <= 10^9 for 0<= i <=n-1
arrTime[i] <= arrTime[i+1] for 0 <= i <= n - 2
0 <= direction[i] <= 1 for 0 <= o <=  n - 1

Example1
Input:
n = 4
arrTime = [1, 1, 2, 6]
direction = [0, 1, 1, 0]

Output:
[3,1,2,6]
 * */
 