package simulator;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	private int x, y;
	protected Color color;
	
	
	public Objekat(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
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
	
	public abstract void paint(Graphics g);
	

	
	
}