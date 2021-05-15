package finalLeapP1;

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
		
		List<String> relatedProducts = new ArrayList<>();
		Map<String,List<String>> map = new HashMap<>();
		
		HashSet<String> nodes = new HashSet<>();
		for(List<String> p:productsList) {
			for(int i =1;i<p.size();i++) {
				nodes.add(p.get(i-1));
				nodes.add(p.get(i));
				List<String> lt = map.getOrDefault(p.get(i-1), new ArrayList<>());
				lt.add(p.get(i));
				map.put(p.get(i-1), lt);
				lt = map.getOrDefault(p.get(i), new ArrayList<>());
				lt.add(p.get(i-1));
				map.put(p.get(i), lt);
			}
		}
		System.out.println("NODES "+ nodes);
		System.out.println("MAP "+ map);
		Set<String> visited = new HashSet<>();
		List<String> res = null;
		int maxSize = 0;
		for(String s:nodes) {
			if(!visited.contains(s)) {
				Set<String> visitedInLeg = new HashSet<>();
				DFS(s, map, visitedInLeg);
				if(maxSize<visitedInLeg.size()) {
					maxSize = visitedInLeg.size();
					res = new ArrayList<>();
					res.addAll(visitedInLeg);
				}
				visited.addAll(visitedInLeg);
			}
		}
		System.out.println("RESULT "+ res);
		return "END";
    }
	
	public void DFS(String node,Map<String,List<String>> map,Set<String> visited) {
		
		visited.add(node);
		List<String> l = map.get(node);
		if(l!=null) {
			for(String s:l) {
				if(!visited.contains(s)) DFS(s, map, visited);
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
 