package finalLeap;

import java.util.Arrays;

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
	
	public class Cost{
		int sum = 0;
	}
	
	public  int ropes(int[] r) {
		if(r == null || r.length < 2 ) return 0;
		Arrays.sort(r);
		Cost c = new Cost();
		tournament(r,c);
		return c.sum;
	}
	
	public void tournament(int[] r,Cost c) {

		int[] rs = new int[r.length-1];
		rs[0] = r[0]+r[1];
		c.sum = c.sum+rs[0];
		if(rs.length == 1) return;
		for(int i=1; i<rs.length; i++) {
			rs[i] = r[i+1];
		}
		Arrays.sort(rs);
		tournament(rs, c);
		
	}

}
