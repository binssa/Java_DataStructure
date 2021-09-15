package com.benworld.search;

import java.util.ArrayList;
import java.util.HashMap;

public class BFS {
	public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String start){
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> need = new ArrayList<String>();
		
		need.add(start);
		
		while(need.size() > 0) {
			String node = need.remove(0);
			if(!visited.contains(node)) {
				visited.add(node);
				need.addAll(graph.get(node));
			}
		}
		return visited;
	}
}
