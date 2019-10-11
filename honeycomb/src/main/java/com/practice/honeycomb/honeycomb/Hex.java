package com.practice.honeycomb.honeycomb;

import java.util.ArrayList;


public class Hex {
	
	 public final int q;
	 public final int r;
	 public final int s;
	 
	public Hex(int q, int r, int s) {
		this.q = q;
		this.r = r;
		this.s = s;
		
		if (q + r + s != 0) throw new IllegalArgumentException("q + r + s must be 0");
	}
	
	public Hex add(Hex b)
	{
	    return new Hex(q + b.q, r + b.r, s + b.s);
	}

	 public Hex rotateLeft()
	 {
	     return new Hex(-s, -q, -r);
	 }


	 public Hex rotateRight()
	 {
	     return new Hex(-r, -s, -q);
	 }

	 static public ArrayList<Hex> directions = new ArrayList<Hex>(){
		 {
			 add(new Hex(1, 0, -1)); 
			 add(new Hex(1, -1, 0)); 
			 add(new Hex(0, -1, 1)); 
			 add(new Hex(-1, 0, 1)); 
			 add(new Hex(-1, 1, 0)); 
			 add(new Hex(0, 1, -1));
			 }
		 };

	 static public Hex direction(int direction)
	 {
	     return Hex.directions.get(direction);
	 }


	 public Hex neighbor(int direction)
	 {
	     return add(Hex.direction(direction));
	 }


}
