package com.generate.coordinate.cords;

public class Poins {
	private int x;
	private int y;
	private int z;
	private int num;

	public Poins(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Poins(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Poins(int x, int y, int z, int num) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.num = num;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
