package finalLeapP3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FiveStarSellers2 {

	public static void main(String[] args) {
		FiveStarSellers2 s = new FiveStarSellers2();
		int[][] productRatings = new int[][] {{4, 4},{1, 2},{3, 6}};
		int ratingsThreshold = 77;
		
		System.out.println(s.fiveStarReviews(productRatings, ratingsThreshold));
	}
	
	class Rating{
		
		int stars;
		int totalStars;
		double rating;
		double increase;
		
		public Rating(int i,int j) {
			stars = i;
			totalStars = j;
			rating = (double)i/(double)j;
			increase = (double)(i+1)/(double)(j+1) - rating;
		}
	}
	
	public int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
		
		Queue<Rating> pq = new PriorityQueue<>((a,b) -> Double.compare(b.increase, a.increase));
		
		double currentPercentage = 0;
		for(int[] p:productRatings) {
			Rating r = new Rating(p[0], p[1]);
			pq.offer(r);
			currentPercentage+=r.rating;
		}
		currentPercentage/=productRatings.length;
		
		int result = 0;
		
		while(currentPercentage*100 < ratingsThreshold) {
			Rating r = pq.poll();
			currentPercentage+=r.increase/productRatings.length;
			pq.offer(new Rating(r.stars+1,r.totalStars+1));
			result++;
		}
		
		return result;
	}



}
