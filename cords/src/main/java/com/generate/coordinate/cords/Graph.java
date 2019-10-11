package com.generate.coordinate.cords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<String, Node> nodes = new HashMap<String, Node>();

	public Graph() {
	}

	public void addEdge(String Vertice1, String Vertice2) {
		Node node1 = nodes.get(Vertice1);
		if (node1 == null) {
			node1 = new Node(Vertice1);
		}

		Node node2 = nodes.get(Vertice2);
		if (node2 == null) {
			node2 = new Node(Vertice2);
		}

		node1.addNeighbor(node2);
		node2.addNeighbor(node1);

		nodes.put(Vertice1, node1);
		nodes.put(Vertice2, node2);
	}

	public List<String> shortestPath(String Source, String Destination) {
		// key node, value parent
		Map<String, String> parents = new HashMap<String, String>();
		List<Node> temp = new ArrayList<Node>();
		List<String> result = new ArrayList<String>();

		Node start = nodes.get(Source);
		temp.add(start);
		parents.put(Source, null);

		while (temp.size() > 0) {
			Node currentNode = temp.get(0);
			List<Node> neighbors = currentNode.getNeighbors();

			for (int i = 0; i < neighbors.size(); i++) {
				Node neighbor = neighbors.get(i);
				String nodeName = neighbor.getName();

				// a node can only be visited once if it has more than one parents
				boolean visited = parents.containsKey(nodeName);
				if (visited) {
					continue;
				} else {
					temp.add(neighbor);

					// parents map can be used to get the path
					parents.put(nodeName, currentNode.getName());

					// return the shortest path if end node is reached
					if (nodeName.equals(Destination)) {
						// System.out.println(parents);
						result =  getPath(parents, Destination);
					}
				}
			}

			temp.remove(0);
		}

		return result;
	}

	private List<String> getPath(Map<String, String> parents, String Destination) {
		List<String> path = new ArrayList<String>();
		String node = Destination;
		while (node != null) {
			path.add(0, node);
			String parent = parents.get(node);
			node = parent;
		}
		return path;
	}
}
