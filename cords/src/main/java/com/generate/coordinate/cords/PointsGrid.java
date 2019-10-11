package com.generate.coordinate.cords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PointsGrid {

	
	private PointsGrid() {}

	public static ArrayList<Poins> generateCoordinates(int radius) {
		ArrayList<Poins> coordinate = new ArrayList<Poins>();

		int number = 2;

		int x = 0, y = 0;
		Poins offse = new Poins(x, y, 1);
		coordinate.add(offse); // add the first cell

		for (int N = 1; N <= radius; ++N) {
			for (int i = 0; i < N; ++i)
				coordinate.add(new Poins(++x, y, number++)); // move right
			for (int i = 0; i < N - 1; ++i)
				coordinate.add(new Poins(x, ++y, number++)); // move down right. Note N-1
			for (int i = 0; i < N; ++i)
				coordinate.add(new Poins(--x, ++y, number++)); // move down left
			for (int i = 0; i < N; ++i)
				coordinate.add(new Poins(--x, y, number++)); // move left
			for (int i = 0; i < N; ++i)
				coordinate.add(new Poins(x, --y, number++)); // move up left
			for (int i = 0; i < N; ++i)
				coordinate.add(new Poins(++x, --y, number++)); // move up right
		}

		return coordinate;

	}

	public static ArrayList<Poins> Search(ArrayList<Poins> list, Poins e) {
		ArrayList<Poins> a = new ArrayList<Poins>();

		Poins p1 = new Poins(e.getX() + 1, e.getY() + 0);
		Poins p2 = new Poins(e.getX() + 1, e.getY() - 1);
		Poins p3 = new Poins(e.getX() + 0, e.getY() - 1);
		Poins p4 = new Poins(e.getX() - 1, e.getY() + 0);
		Poins p5 = new Poins(e.getX() - 1, e.getY() + 1);
		Poins p6 = new Poins(e.getX() + 0, e.getY() + 1);

		for (Poins poins : list) {
			Poins temp = poins;

			if (p1.getX() == (temp.getX()) && p1.getY() == (temp.getY())) {
				a.add(temp);
			}
			if (p2.getX() == (temp.getX()) && p2.getY() == (temp.getY())) {
				a.add(temp);
			}
			if (p3.getX() == (temp.getX()) && p3.getY() == (temp.getY())) {
				a.add(temp);
			}
			if (p4.getX() == (temp.getX()) && p4.getY() == (temp.getY())) {
				a.add(temp);
			}
			if (p5.getX() == (temp.getX()) && p5.getY() == (temp.getY())) {
				a.add(temp);
			}
			if (p6.getX() == (temp.getX()) && p6.getY() == (temp.getY())) {
				a.add(temp);
			}

		}

		return a;
	}

	public static Map<Integer, ArrayList<Poins>> HexMap(ArrayList<Poins> coordinate) {
		Map<Integer, ArrayList<Poins>> map = new HashMap<Integer, ArrayList<Poins>>();

		ArrayList<Poins> poinsNeighbor = new ArrayList<Poins>();
		ArrayList<Poins> listofNeighbor = new ArrayList<Poins>();

		for (Poins p : coordinate) {
			poinsNeighbor = PointsGrid.Search(coordinate, p);
			// System.out.println("");

			for (Poins poins : poinsNeighbor) {
				// System.out.println("x: " + poins.getX() + " y: "+ poins.getY() + " n:" +
				// poins.getZ());
				listofNeighbor.add(poins);
			}

			map.put(p.getZ(), new ArrayList<Poins>(listofNeighbor));
			listofNeighbor.clear();
		}

		return map;
	}

	public static Graph AssignEdge(Map<Integer, ArrayList<Poins>> map) {
		Graph graph = new Graph();

		for (Entry<Integer, ArrayList<Poins>> hexmap : map.entrySet()) {
			for (Poins points : hexmap.getValue()) {
				graph.addEdge(hexmap.getKey().toString(), Integer.toString(points.getZ()));
			}
		}
		return graph;
	}
	
}
