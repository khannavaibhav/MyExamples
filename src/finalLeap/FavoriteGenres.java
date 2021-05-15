package finalLeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FavoriteGenres {
	
//	Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.
//
//	Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.
//
//	The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). 
//			Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.

	public static void main(String[] args) {
		FavoriteGenres g = new FavoriteGenres();

		Map<String, List<String>> userSongs = new HashMap<String, List<String>>();
		Map<String, List<String>> songGenres = new HashMap<String, List<String>>();
		
		List<String> d = Arrays.asList(new String[] {"song1", "song2", "song3", "song4", "song8"});
		userSongs.put("David", d);
		d = Arrays.asList(new String[] {"song5", "song6", "song7"});
		userSongs.put("Emma", d);
		
		d = Arrays.asList(new String[] {"song1", "song3"});
		songGenres.put("Rock", d);
		d = Arrays.asList(new String[] {"song7"});
		songGenres.put("Dubstep", d);
		d = Arrays.asList(new String[] {"song2", "song4"});
		songGenres.put("Techno", d);
		d = Arrays.asList(new String[] {"song5", "song6"});
		songGenres.put("Pop", d);
		d = Arrays.asList(new String[] {"song8", "song9"});
		songGenres.put("Jazz", d);
			
		System.out.println(g.criticalConnections(userSongs, songGenres));
	}
	
	public Map<String, List<String>> criticalConnections(Map<String, List<String>> users,Map<String, List<String>> genres) {
	        //6:40 - 7:24
		Map<String, List<String>> res = new HashMap<String, List<String>>();
		
		Map<String, String> songs =  new HashMap<String, String>();
		for(String k:genres.keySet() ) {
			for(String s:genres.get(k) ) {
				songs.put(s, k);
			}
		}
		for(String k:users.keySet()) {
			HashMap<String,Integer> h = new HashMap<String,Integer>();
			PriorityQueue<String> pq =  new PriorityQueue<String>(new Comparator<String>(){
				public int compare(String s1,String s2) {
					return h.get(s2) - h.get(s1);
				}		
			});
			
			for(String su:users.get(k)) {
				String g = songs.get(su);
				h.put(g, h.getOrDefault(g, 0) +1);
				
			}
			List<String> resL = new ArrayList<String>();
			for(String c:h.keySet()) {
				pq.add(c);
			}
			String add = pq.poll();
			resL.add(add);
			int count = h.get(add);
			int id = count;
			while (id == count) {
				add = pq.poll();
				id = h.get(add);
				if(id == count) {
					resL.add(add);
				}
			}
			res.put(k, resL);
			
		}
		
	    return res;
	
	}
}
