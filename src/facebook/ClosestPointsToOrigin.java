package facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestPointsToOrigin {

//	We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
//
//	(Here, the distance between two points on a plane is the Euclidean distance.)
//
//	You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
//
//	 
//
//	Example 1:
//
//	Input: points = [[1,3],[-2,2]], K = 1
//	Output: [[-2,2]]
//	Explanation: 
//	The distance between (1, 3) and the origin is sqrt(10).
//	The distance between (-2, 2) and the origin is sqrt(8).
//	Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//	We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
//	Example 2:
//
//	Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//	Output: [[3,3],[-2,4]]
//	(The answer [[-2,4],[3,3]] would also be accepted.)
//	 
//
//	Note:
//
//	1 <= K <= points.length <= 10000
//	-10000 < points[i][0] < 10000
//	-10000 < points[i][1] < 10000
	
	public static void main(String[] args) {
		
		int[][] r = kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2);
		System.out.println(r);
	}
	
    public static int[][] kClosest(int[][] points, int K) {
        if(points.length == 0 || points[0].length == 0) return null;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return (o2[0]*o2[0] + o2[1]*o2[1]) - (o1[0]*o1[0] + o1[1]*o1[1]);
            }
        });
        for(int i = 0;i<points.length;i++){
            int sq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            System.out.println(sq);
            pq.add(points[i]);
            if(pq.size() > K) {
            	pq.poll();
            }
        }
        
        System.out.println(pq);
        int[][] result = new int[K][2];
        for(int i =0;i<K;i++){
            int[] r = pq.poll();
            System.out.println(r[0] + " "+r[1]);
            result[i] = new int[]{r[0],r[1]};
        }

        return result;
        
    }
}
