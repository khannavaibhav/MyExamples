package finalLeapP3;

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
		
		int l = 0;
		int r = duration.length-1;
		int curr = 0;
		int max = 0;
		int[] res = new int[2];
		while(l<r) {
			curr = duration[l] + duration[r];
			if(curr > k) {
				curr = 0;
				r--;
			}
			else if(curr > max) {
				max = curr;
				res = new int[] {duration[l],duration[r]};
			}
			l++;
		}
		System.out.println(res[0] +" "+res[1]);
		return "END";
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
 