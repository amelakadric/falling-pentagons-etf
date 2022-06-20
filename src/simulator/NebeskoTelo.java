package simulator;

import java.awt.Color;

public abstract class NebeskoTelo extends Objekat{
	protected int r;
	public NebeskoTelo(int x, int y, Color color, int r) {
		super(x, y, color);
		this.r=r;
	}	
	
	public synchronized void pomeriY() {
		int ny= this.getY()+5;
		this.setY(ny);
	}
	
}
