package finalLeapP2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class FiveStarSellers {

	public static void main(String[] args) {
		FiveStarSellers s = new FiveStarSellers();
		int[][] productRatings = new int[][] {{4, 4},{1, 2},{3, 6}};
		int ratingsThreshold = 77;
		
		System.out.println(s.fiveStarReviews(productRatings, ratingsThreshold));
	}
	
	public int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
		double rate = findRating(productRatings);
		System.out.println(rate);
		int count = 0;
		while(rate<ratingsThreshold) {
			double max = 0; int index = -1;
			for(int i = 0;i<productRatings.length;i++) {
				double d = (double)productRatings[i][0]*100/(double)productRatings[i][1];
				if(d!=100) {
					double m = (rate*productRatings.length+
							((double)(productRatings[i][0]+1)*100/(double)(productRatings[i][1]+1))-d)/productRatings.length;
					if(m>max) {
						max = m;
						index = i;
					}
				}
			}
			
			if(index>=0) {
				rate = max;
				productRatings[index][0]++;
				productRatings[index][1]++;
				count++;
			}
		}
		return count;
	}
	public double findRating(int[][] productRatings) {
		double rate = 0;
		for(int[] p:productRatings) {
			double r = (double)p[0]/(double)p[1];
			rate += r*100;
		}
		return rate/productRatings.length;
	}


}
