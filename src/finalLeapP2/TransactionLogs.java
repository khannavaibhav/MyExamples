package finalLeapP2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] logs = new String[] {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
		int threshold = 2;
		thresholdTypeIdCount(logs, threshold);
	}

	private static void thresholdTypeIdCount(String[] logs, int threshold) {
		Map<String,Integer> map = new HashMap<>();
        for(String log:logs){
            String[] l = log.split(" ");
            map.put(l[0], map.getOrDefault(l[0],0) +1);
            if(!l[0].equals(l[1]))
                map.put(l[1], map.getOrDefault(l[1],0) +1);
        }
        List<String> res = new ArrayList<>();
        for(String k:map.keySet()){
            if(map.get(k) >= threshold) res.add(k); 
        }
        int index = 0;
        String[] r = new String[res.size()];
        for(String x:res){
            r[index++] = x;
        }
        //return r;
        System.out.println(res);
	}

}
