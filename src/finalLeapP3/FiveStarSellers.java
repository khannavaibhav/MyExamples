package finalLeapP3;

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
		
		double rate = 0;
		for(int[] r:productRatings) {
			rate += (double)r[0]*100/(double)r[1];
		}
		rate /=productRatings.length;
		
		int count = 0;
		while(rate<ratingsThreshold) {
			int index = -1;
			double maxIncrease = 0;
			for(int i = 0;i<productRatings.length;i++) {
				double d = (double)productRatings[i][0]*100/(double)productRatings[i][1];
				if(d!=100) {
					double m = (double)(productRatings[i][0]+1)*100/(double)(productRatings[i][1]+1) - d;
					if(m>maxIncrease) {
						maxIncrease = m;
						index = i;
					}
				}
			}
			if(index > -1) {
				count++;
				rate = rate + maxIncrease/productRatings.length;
				productRatings[index][0]++;
				productRatings[index][1]++;
			}
			else {
				return -1;
			}
		}
		
		return count;
	}



}
