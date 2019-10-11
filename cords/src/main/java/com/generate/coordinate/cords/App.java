package com.generate.coordinate.cords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		int radius = 10;
		ArrayList<Poins> coordinate = new ArrayList<Poins>();
		Map<Integer, ArrayList<Poins>> map = new HashMap<Integer, ArrayList<Poins>>();
		Graph graph = new Graph();

		// Generating coordinate pattern
		coordinate = PointsGrid.generateCoordinates(radius);

		// Assigning a neighbors of every vertices
		map = PointsGrid.HexMap(coordinate);

		// Assigning a edge of every vertices
		graph = PointsGrid.AssignEdge(map);

		System.out.print("Enter source: ");
		int source = in.nextInt();
		System.out.print("Enter destination: ");
		int destination = in.nextInt();
		List<String> result = graph.shortestPath(Integer.toString(source), Integer.toString(destination));
		System.out.println(result);
	}
}
