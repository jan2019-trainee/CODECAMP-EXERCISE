package com.generate.coordinate.cords;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

@RunWith(PowerMockRunner.class)
public class GraphTest {

	private Graph graphspy;

	@Test
	public void testAddEdge() {
		Graph graph = mock(Graph.class);

		graph.addEdge("1", "2");
		graph.addEdge("1", "3");
		graph.addEdge("1", "4");
		graph.addEdge("1", "5");

		Mockito.verify(graph).addEdge("1", "2");
	}

	@Test
	public void testAddEdge_False() {
		Graph graph = mock(Graph.class);

		graph.addEdge("1", "2");
		graph.addEdge("1", "3");
		graph.addEdge("1", "4");
		graph.addEdge("1", "5");

		Mockito.verify(graph, never()).addEdge("1", "6");
	}

	@Before
	public void setUp() {
		graphspy = PowerMockito.spy(new Graph());
	}
	
	@Test
	public void testShortestPath() throws Exception {
		Map<String, String> mapString = new HashMap<String, String>();
		
		mapString.put("1","1");
		mapString.put("1","2");
		mapString.put("1","3");
		mapString.put("1","4");
		mapString.put("2","1");
	
		List<String> actualMockPoint1 = new ArrayList<String>();
		actualMockPoint1.add("1");
		
		PowerMockito.doReturn(actualMockPoint1).when(graphspy, "getPath", mapString, "1");

		List<String> actualMockPoint = graphspy.shortestPath("1", "2");
		assertThat(actualMockPoint, equalTo (null));
		PowerMockito.verifyPrivate(graphspy,Mockito.times(1)).invoke("getPath",mapString,"1");
}

}