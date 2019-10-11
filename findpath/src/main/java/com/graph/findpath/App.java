package com.graph.findpath;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  Graph graph = constructGraph();
          List<String> result = graph.shortestPath("15", "20");
          System.out.println("shortest path between 15 and 20: " + result);
    }
    
    private static Graph constructGraph() {

        Graph graph = new Graph();
        
    	 graph.addEdge("1", "2");
         graph.addEdge("1", "3");
         graph.addEdge("1", "4");
         graph.addEdge("1", "5");
         graph.addEdge("1", "6");
         graph.addEdge("1", "7");
       
         graph.addEdge("2", "7");
         graph.addEdge("2", "8");
         graph.addEdge("2", "9");
         graph.addEdge("2", "10");
         graph.addEdge("2", "3");
         
         graph.addEdge("3", "10");
         graph.addEdge("3", "11");
         graph.addEdge("3", "12");
         graph.addEdge("3", "4");
         
         graph.addEdge("4", "12");
         graph.addEdge("4", "13");
         graph.addEdge("4", "14");
         graph.addEdge("4", "5");
        
         graph.addEdge("5", "14");
         graph.addEdge("5", "15");
         graph.addEdge("5", "16");
         graph.addEdge("5", "6");
        
         graph.addEdge("6", "16");
         graph.addEdge("6", "17");
         graph.addEdge("6", "18");

         graph.addEdge("7", "18");
         graph.addEdge("7", "19");
         graph.addEdge("7", "8");
        
         graph.addEdge("8", "19");
         graph.addEdge("8", "20");
         graph.addEdge("8", "21");

         graph.addEdge("9", "22");
         graph.addEdge("9", "23");
         graph.addEdge("9", "10");
         
         graph.addEdge("10", "23");
         graph.addEdge("10", "24");
         graph.addEdge("10", "11");
         
         graph.addEdge("11", "24");
         graph.addEdge("11", "25");
         graph.addEdge("11", "12");
         
         graph.addEdge("12", "25");
         graph.addEdge("12", "26");
         graph.addEdge("12", "13");
        
         graph.addEdge("13", "27");
         graph.addEdge("13", "28");
         graph.addEdge("13", "29");
         graph.addEdge("13", "14");
         
         graph.addEdge("14", "29");
         graph.addEdge("14", "30");
         graph.addEdge("14", "15");

         graph.addEdge("15", "30");
         graph.addEdge("15", "31");
         graph.addEdge("15", "32");
         graph.addEdge("15", "16");
         
         graph.addEdge("16", "5");
         graph.addEdge("16", "6");
         graph.addEdge("16", "17");
         graph.addEdge("16", "15");
         graph.addEdge("16", "32");
         graph.addEdge("16", "33");
         
         graph.addEdge("17", "6");
         graph.addEdge("17", "18");
         graph.addEdge("17", "16");
         graph.addEdge("17", "33");
         graph.addEdge("17", "34");
         graph.addEdge("17", "35");
         
         graph.addEdge("18", "7");
         graph.addEdge("18", "6");
         graph.addEdge("18", "19");
         graph.addEdge("18", "36");
         graph.addEdge("18", "17");
         graph.addEdge("18", "35");
         
         graph.addEdge("19", "7");
         graph.addEdge("19", "18");
         graph.addEdge("19", "36");
         graph.addEdge("19", "37");
         graph.addEdge("19", "20");
         graph.addEdge("19", "8");
         
         graph.addEdge("20", "8");
         graph.addEdge("20", "19");
         graph.addEdge("20", "37");
         graph.addEdge("20", "38");
         graph.addEdge("20", "39");
         graph.addEdge("20", "21");
         
         graph.addEdge("21", "9");
         graph.addEdge("21", "8");
         graph.addEdge("21", "20");
         graph.addEdge("21", "39");
         graph.addEdge("21", "40");
         graph.addEdge("21", "22");
         
         
       return graph;
      }
}
