package com.benworld.algorithm;

public class Edge implements Comparable<Edge>{
	public int distance;
	public String vertex;
	
	public Edge(int distance, String vertex) {
		this.distance = distance;
		this.vertex = vertex;
	}
	
	public String toString() {
		return "{Vertex : " + this.vertex + ", Distance : " + this.distance+"}";
	}
	@Override
	public int compareTo(Edge o) {
		return this.distance - o.distance;
	}
	
}
