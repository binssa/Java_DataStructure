package com.benworld.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {
	public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start){
		// 초기화 작업
		Edge edge, adjNode;
		ArrayList<Edge> nodeList;
		int curDist, weight, dist;
		String curVertex = null, adj;
		
		HashMap<String, Integer> distances = new HashMap<String,Integer>();
		for(String key : graph.keySet()) {
			distances.put(key, Integer.MAX_VALUE);
		}
		distances.put(start, 0);
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(distances.get(start), start));
		
		// 알고리즘 작성
		while(pq.size()>0) {
			// 우선순위 큐에 있는 내용을 꺼낸다.
			edge = pq.poll();
			curDist = edge.distance;
			curVertex = edge.vertex;
			
			if(distances.get(curVertex) < curDist) {
				continue;
			}
			nodeList = graph.get(curVertex);
			for(int i=0;i<nodeList.size();i++) {
				adjNode = nodeList.get(i);
				adj = adjNode.vertex;
				weight = adjNode.distance;
				dist = curDist + weight;
				if(dist < distances.get(adj)) {
					distances.put(adj, dist);
					pq.add(new Edge(dist, adj));
				}
			}
		}
		
		nodeList = graph.get(curVertex);
		
		return distances;
	}
}
