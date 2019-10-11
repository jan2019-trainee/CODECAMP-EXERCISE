package com.practice.honeycomb.honeycomb;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class Graph 
{
	private int[][] adjacentList;
	
	public Graph(int[][] adjancentList) {
		this.adjacentList = adjancentList;
	}
	
	public int ShortestPath(int Start, int End) {
		boolean isPathFound = false;
		boolean[] visited = new boolean[adjacentList.length];
		int[] distance = new int[adjacentList.length];
		int[] previous = new int[adjacentList.length];
		
		 for (int i = 0; i < distance.length; i++) {
	            visited[i] = false;
	            distance[i] = -1;
	            previous[i] = -1;
	        }

	        Queue<Integer> queue = new LinkedList<Integer>();
	        queue.add(Start);
	        distance[End] = 0;
	        visited[Start] = true;
	        
	        while (!queue.isEmpty() && !isPathFound) {
	            int polledNode = queue.poll();

	            for (int i = 0; i < adjacentList[polledNode].length; i++) {
	                int adjacentNode = adjacentList[polledNode][i];

	                if (!visited[adjacentNode]) {

	                    distance[adjacentNode] = distance[polledNode] + 1;
	                    previous[adjacentNode] = polledNode;

	                    if (adjacentNode == End) {
	                        isPathFound = true;
	                        break;
	                    }

	                    visited[adjacentNode] = true;
	                    queue.add(adjacentNode);
	                }
	            }
	        }

	        List<Integer> path = new LinkedList<Integer>();
	        int prevNode = End;
	        path.add(prevNode);
	        while (previous[prevNode] != -1) {
	            prevNode = previous[prevNode];
	            path.add(prevNode);
	        }

	        Collections.reverse(path);
	        System.out.println(Start + " -> " + End + " path: " + path);
	        System.out.println();

	        return distance[End];
	}
}
