package com.generate.coordinate.cords;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PointsGrid.class)
public class PointsGridTest {

	@Before
	public void setUp() {
		mockStatic(PointsGrid.class);
	}

	@Test
	public void testGenerateCoordinates() {
		int radius = 2;

		ArrayList<Poins> points = new ArrayList<Poins>();
		points.add(new Poins(0, 0, 1));
		points.add(new Poins(0, 1, 2));

		when(PointsGrid.generateCoordinates(radius)).thenReturn(points);
		ArrayList<Poins> actual = PointsGrid.generateCoordinates(radius);

		verifyStatic();

		assertThat(points, is( actual));
	}

	@Test
	public void testGenerateCoordinates_False() {
		int radius = 2;

		ArrayList<Poins> expected = new ArrayList<Poins>();
		ArrayList<Poins> points = new ArrayList<Poins>();
		points.add(new Poins(0, 0, 1));
		points.add(new Poins(0, 1, 2));

		when(PointsGrid.generateCoordinates(radius)).thenReturn(points);
		ArrayList<Poins> actual = PointsGrid.generateCoordinates(radius);

		verifyStatic();

		assertThat(expected, not(actual));
	}

	@Test
	public void testSearch() {
		Poins cord1 = new Poins(0, 0, 1);

		ArrayList<Poins> points = new ArrayList<Poins>();
		points.add(new Poins(0, 0, 1));
		points.add(new Poins(0, 1, 2));

		when(PointsGrid.Search(points, cord1)).thenReturn(points);
		ArrayList<Poins> actual = PointsGrid.Search(points, cord1);

		verifyStatic();

		assertThat(points,is (actual));
	}
	
	@Test
	public void testSearch_False() {
		Poins cord1 = new Poins(0, 0, 1);

		ArrayList<Poins> expected = new ArrayList<Poins>();
		ArrayList<Poins> points = new ArrayList<Poins>();
		points.add(new Poins(0, 0, 1));
		points.add(new Poins(0, 1, 2));

		when(PointsGrid.Search(points, cord1)).thenReturn(points);
		ArrayList<Poins> actual = PointsGrid.Search(points, cord1);

		verifyStatic();

		assertThat(expected, not(actual));
	}

	@Test
	public void testHexMap() {
		Map<Integer, ArrayList<Poins>> map = new HashMap<Integer, ArrayList<Poins>>();
		
		ArrayList<Poins> points = new ArrayList<Poins>();
		points.add(new Poins(0, 0, 1));
		points.add(new Poins(0, 1, 2));
		
		map.put(1, points);
		
		when(PointsGrid.HexMap(points)).thenReturn(map);
		Map<Integer, ArrayList<Poins>> actual = PointsGrid.HexMap(points);

		verifyStatic();

		assertThat(map, is(actual));
	}
	
	@Test
	public void testHexMap_False() {
		Map<Integer, ArrayList<Poins>> map = new HashMap<Integer, ArrayList<Poins>>();
		Map<Integer, ArrayList<Poins>> expected = new HashMap<Integer, ArrayList<Poins>>();
		
		ArrayList<Poins> points = new ArrayList<Poins>();
		points.add(new Poins(0, 0, 1));
		points.add(new Poins(0, 1, 2));
		
		map.put(1, points);
		
		when(PointsGrid.HexMap(points)).thenReturn(map);
		Map<Integer, ArrayList<Poins>> actual = PointsGrid.HexMap(points);

		verifyStatic();

		assertThat(expected, not(actual));
	}

	@Test
	public void testAssignEdge() {
		Graph graph = new Graph();
		Map<Integer, ArrayList<Poins>> map = new HashMap<Integer, ArrayList<Poins>>();
		
		ArrayList<Poins> points = new ArrayList<Poins>();
		points.add(new Poins(0, 0, 1));
		points.add(new Poins(0, 1, 2));
		
		map.put(1, points);
		
		graph.addEdge("1","2");
		graph.addEdge("1","3");
		graph.addEdge("1","4");
		
		when(PointsGrid.AssignEdge(map)).thenReturn(graph);
		Graph actual = PointsGrid.AssignEdge(map);

		verifyStatic();

		assertThat(graph, is(actual));
	}
	
	@Test
	public void testAssignEdge_False() {
		Graph graph = new Graph();
		Graph expected = new Graph();
		
		Map<Integer, ArrayList<Poins>> map = new HashMap<Integer, ArrayList<Poins>>();
		
		ArrayList<Poins> points = new ArrayList<Poins>();
		points.add(new Poins(0, 0, 1));
		points.add(new Poins(0, 1, 2));
		
		map.put(1, points);
		
		graph.addEdge("1","2");
		graph.addEdge("1","3");
		graph.addEdge("1","4");
		
		when(PointsGrid.AssignEdge(map)).thenReturn(graph);
		Graph actual = PointsGrid.AssignEdge(map);

		verifyStatic();

		assertThat(expected, not(actual));
	}

}
