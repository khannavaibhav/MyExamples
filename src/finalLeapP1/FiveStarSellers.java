package finalLeapP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class FiveStarSellers {

	public static void main(String[] args) {
		int[][] productRatings = new int[][] {{1,2}};
		int ratingsThreshold = 50;
		
		System.out.println(fiveStarReviews(productRatings, ratingsThreshold));
	}

	public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
        
        int count = 0;boolean isDone = false;
        while(!isDone){
            isDone = findMaxIncrease(productRatings, ratingsThreshold);
            count++;
        }
        return count-1;
        
    }
    
    public static boolean findMaxIncrease(int[][]  productRatings,int ratingsThreshold){
        int max = 0;int id = -1;
        int totalRating = 0;
        for(int i = 0;i<productRatings.length;i++){
            totalRating +=(productRatings[i][0])*100/(productRatings[i][1]);
//            System.out.println(productRatings[i][0] +"  "+productRatings[i][1]);
//            System.out.println(1 +"----------------- "+totalRating);
        }
        for(int i = 0;i<productRatings.length;i++){
        	
            if(productRatings[i][0] != productRatings[i][1]){
                int s = totalRating + (productRatings[i][0]+1)*100/(productRatings[i][1]+1) - (productRatings[i][0])*100/(productRatings[i][1]);
//                System.out.println(i +" %%% "+s);
                if(s > max){
                    max = s;
                    id = i;
                }
            }
        }
        productRatings[id][0]++;
        productRatings[id][1]++;
        totalRating =totalRating*100/productRatings.length;
//        System.out.println(id +"---- "+totalRating);
        return totalRating>=ratingsThreshold*100;
    }
}
