package finalLeapP2;

import java.util.PriorityQueue;

public class ConnectRopes {

//	Given n ropes of different lengths, we need to connect these ropes into one rope. 
//	We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal
//	to sum of their lengths. The length of this connected rope is also equal to the 
//	sum of their lengths. This process is repeated until n ropes are connected into a
//	single rope. Find the min possible cost required to connect all ropes.
	
	public static void main(String[] args) {
		ConnectRopes cr = new ConnectRopes();
		int[] r = new int[] {2, 2, 3, 3};
		System.out.println(cr.ropes(r));
	}
	
	public  int ropes(int[] ropes) {
		/*
		 Time complexity for the methods offer & poll is O(log(n)) 
		 and for the peek() it is Constant time O(1) of java priority queue. 
		 NOTES: In Java programming, Java Priority Queue is implemented using 
		 Heap Data Structures and Heap has O(log(n)) time complexity to insert and delete element.
		 */
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for(int r:ropes) {
			p.offer(r);
		}
		int x = 0;
		int total =0;
		while(!p.isEmpty()) {
			x = p.poll();
			if(!p.isEmpty()) {
				x+=p.poll();
				total+=x;
				p.offer(x);
			}
		}
		return total;
	}
}
