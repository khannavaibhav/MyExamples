package Structures;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class TestTreeMap {

    public static boolean ASC = true;
    public static boolean DESC = false;
    
	public static void main(String[] args) {
		TestTreeMap tshm = new TestTreeMap();
		Map<String, Integer> unsortMap = new TreeMap<String, Integer>();
        unsortMap.put("B", 55);
        unsortMap.put("A", 80);
        unsortMap.put("D", 20);
        unsortMap.put("C", 70);
        unsortMap.put("E", 55);

        System.out.println("Before sorting......");
        printMap(unsortMap);
        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(Collections.reverseOrder());
        for (Map.Entry entry : unsortMap.entrySet()) {
        	sortedMap.put((Integer) entry.getValue(), (String)entry.getKey());
        }
		
//		  System.out.println("After sorting ascending order......"); Map<String,
//		  Integer> sortedMapAsc = tshm.sortHashMap(unsortMap, ASC);
//		  printMap(sortedMapAsc);
		  
		  
		 System.out.println("After sorting descindeng order......");
		  printMap(sortedMap);
		 
	}
	

   public static void printMap(Map map)
    {
        for (Entry entry : (Set<Entry>)map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }
}
