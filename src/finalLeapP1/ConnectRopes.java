package finalLeapP1;

import java.util.PriorityQueue;

public class ConnectRopes {

//	Given n ropes of different lengths, we need to connect these ropes into one rope. 
//	We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal
//	to sum of their lengths. The length of this connected rope is also equal to the 
//	sum of their lengths. This process is repeated until n ropes are connected into a
//	single rope. Find the min possible cost required to connect all ropes.
	
	public static void main(String[] args) {
		ConnectRopes cr = new ConnectRopes();
		int[] r = new int[] {1, 2, 5, 10, 35, 89};
		System.out.println(cr.ropes(r));
	}
	
	public  int ropes(int[] ropes) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		if(ropes.length<2) return 0;
		for(int i:ropes) {
			pq.offer(i);
		}
		int cost = 0;
		while(!pq.isEmpty()) {
			int sum = pq.poll()+pq.poll();
			if(!pq.isEmpty()) pq.offer(sum);
			cost+=sum; 
		}
		return cost;
	}
}
