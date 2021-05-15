package finalLeapP3;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KNearestPostOffices {

	public static void main(String[] args) {
		KNearestPostOffices s = new KNearestPostOffices();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] you = {0, 0};
		int[][] offices = {{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}};
		int k = 3;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a1,int[] a2) {
				return ((a2[0] - you[0])*(a2[0] - you[0]) + (a2[1] - you[1])*(a2[1] - you[1]) ) - 
						((a1[0] - you[0])*(a1[0] - you[0]) + (a1[1] - you[1])*(a1[1] - you[1]) );
			}
		});
		for(int[] p:offices) {
			pq.offer(p);
			if(pq.size()>k) pq.poll();
		}
		while(!pq.isEmpty()) {
			int[] x = pq.poll();
			System.out.println(x[0] + " " + x[1]);
		}
		
		return "END "  ; 
    }
	
}
/*
Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
Euclidean distance is applied to find the distance between you and a post office.
Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
K is a positive integer much smaller than the given number of post offices. from aonecode.com

e.g.
Input
you: [0, 0]
post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
k = 3

Output from aonecode.com
[[-1, 2], [0, 3], [4, 3]]
 * */
 