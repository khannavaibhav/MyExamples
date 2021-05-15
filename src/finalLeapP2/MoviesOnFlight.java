package finalLeapP2;

import java.util.*;

public class MoviesOnFlight {

	public static void main(String[] args) {
		MoviesOnFlight s = new MoviesOnFlight();
		System.out.println(s.solution().toString());
	}

	public String solution() {
		
		int[] duration = new int[] {90, 85, 75, 60, 120, 150, 125};
		int d = 250;
		
		int k = d-30;
		
		Arrays.sort(duration);
		
		int maxL = 0;int maxR = 0;
		int left = 0,right=duration.length-1;
		while(left<right) {
			int m = duration[left] + duration[right];
			if(m>k) right--;
			else {
				if(m>maxL+maxR) {
					maxL = duration[left];
					maxR = duration[right];
				}
				left++;
			}
		}
		
		return "END" +maxL + maxR;
    }
	
}
/*
You are on a flight and wanna watch two movies during this flight.
You are given int[] movie_duration which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

e.g.
Input
movie_duration: [90, 85, 75, 60, 120, 150, 125]
d: 250

Output from aonecode.com
[90, 125]
90min + 125min = 215 is the maximum number within 220 (250min - 30min)
 * */
 