package com.egg.business.Juan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.Iterator;

import models.Clients;
import models.Eggs;
import models.Producer;

/**
 * Hello world!
 *
 */
public class App
{
	
    public static void main( String[] args )
    {
    	List<Clients> list = new LinkedList<Clients>();
    	
    	// Creating a clients
        Clients c1 = new Clients("Client 1",20);
        Clients c2 = new Clients("Client 2",20);
        Clients c3 = new Clients("Client 3",20);
        Clients c4 = new Clients("Client 4",20);
        Clients c5 = new Clients("Client 5",20);
    	
        // adding the clients in List
        list.add(c1);
	    list.add(c2);
	    list.add(c3);
	    list.add(c4);	
	    list.add(c5);
	    
	    // starting the business
   	    Eggs egg = new Eggs();
	    Producer p = new Producer(egg, list);
   	 	p.start();
      
    }
}
