package finalLeapP2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RelatedProducts {

	public static void main(String[] args) {
		RelatedProducts s = new RelatedProducts();
		System.out.println(s.score().toString());
	}

	public String score() {
		
		List<List<String>> productsList = new ArrayList<>();
		List<String> l = new ArrayList<>();
		l.add("p1");l.add("p2");l.add("p3");
		productsList.add(l);
		l = new ArrayList<>();
		l.add("p5");l.add("p2");
		productsList.add(l);
		l = new ArrayList<>();
		l.add("p6");l.add("p7");
		productsList.add(l);
		l = new ArrayList<>();
		l.add("p8");l.add("p7");
		productsList.add(l);
		
		Set<String> n =  new HashSet<>();
		Map<String,List<String>> map = new HashMap<>();
		for(List<String> p:productsList) {
			for(int i = 1;i<p.size();i++) {
				n.add(p.get(i-1));
				n.add(p.get(i));
				List<String> m = map.getOrDefault(p.get(i-1), new ArrayList<>());
				m.add(p.get(i));
				map.put(p.get(i-1),m);
				m = map.getOrDefault(p.get(i), new ArrayList<>());
				m.add(p.get(i-1));
				map.put(p.get(i),m);
			}
		}
		List<String> res = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		List<String> nodes = new ArrayList<>(n);
		int max = 0;
		for(String s:nodes) {
			Set<String> v = new HashSet<>();
			if(!visited.contains(s)) dfs(s,map,v);
			visited.addAll(v);
			if(v.size()>max) {
				max = v.size();
				res = new ArrayList<>(v);
			}
		}
		
		System.out.println(res);
		return "END";
    }
	
	void dfs(String node,Map<String,List<String>> map,Set<String> v) {
		v.add(node);
		List<String> l = map.get(node);
		if(l!=null) {
			for(String s:l) {
				if(!v.contains(s)) dfs(s,map,v);
			}
		}
		
	}

}
/*
Tom plays a game in which he throws a baseball at various blocks marked with a symbol. 
Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’. 
Given a list of strings represent blocks, return the final score...

https://aonecode.com/amazon-online-assessment-baseball-scorekeeping
 * */
 