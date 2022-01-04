package tests;

import java.io.Serializable;

public class Cannon implements Serializable{

	private int size;
	private int x; 
	private int y;
	
	public Cannon(int x, int y, int size) {
		this.size = size;
		this.x = x;
		this.y = y-size;
	}

	public int getSize() {
		return size;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
