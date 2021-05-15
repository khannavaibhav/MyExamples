package Structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class TestSortHashMap {

    public static boolean ASC = true;
    public static boolean DESC = false;
    
	public static void main(String[] args) {
		TestSortHashMap tshm = new TestSortHashMap();
		Map<String, Integer> unsortMap = new HashMap<String, Integer>();
        unsortMap.put("B", 55);
        unsortMap.put("A", 80);
        unsortMap.put("D", 55);
        unsortMap.put("C", 70);
        unsortMap.put("E", 51);

        System.out.println("Before sorting......");
        printMap(unsortMap);
        
        Map<String, Integer> unsortMap2 = new TreeMap<String, Integer>(new Comparator<String>() {
        	public int compare(String s1,String s2) {
        		return unsortMap.get(s1)>unsortMap.get(s2)?1:-1;
        	}
        });
        unsortMap2.putAll(unsortMap);
        System.out.println("Tree sorting......");
        printMap(unsortMap2);

        System.out.println("After sorting ascending order......");
        Map<String, Integer> sortedMapAsc = tshm.sortHashMap(unsortMap, ASC);
        printMap(sortedMapAsc);


        System.out.println("After sorting descindeng order......");
        Map<String, Integer> sortedMapDesc = tshm.sortHashMap(unsortMap, DESC);
        printMap(sortedMapDesc);
	}
	
	private HashMap<String, Integer> sortHashMap(Map<String, Integer> unsortedMap,final boolean isASC){
		
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(unsortedMap.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,Entry<String, Integer> o2){
                if (isASC) {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else{
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
		
		
        HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
	}

   public static void printMap(Map<String, Integer> map)
    {
        for (Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }
}
