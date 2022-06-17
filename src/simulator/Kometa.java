package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Kometa extends NebeskoTelo{
	Polygon pol;
	
	private void setPolygon() {
		int x1, x2, x3, x4, x5;
		int y1, y2, y3, y4, y5;
		double p, q;
		p=Math.random()*r;
		q=Math.random()*r;
		x1=(int) (15+p); y1=(int) q;
		x2=(int) (15* Math.cos(2*Math.PI/5)+p); y2=(int) (15* Math.sin(2*Math.PI/5)+q);
		x3=(int) (15* Math.cos(4*Math.PI/5)+p); y3=(int) (15* Math.sin(4*Math.PI/5)+q);
		x4=(int) (15* Math.cos(6*Math.PI/5)+p); y4=(int) (15* Math.sin(6*Math.PI/5)+q);
		x5=(int) (15* Math.cos(8*Math.PI/5)+p); y5=(int) (15* Math.sin(8*Math.PI/5)+q);
		
		int xp[]= {x1, x2, x3, x4, x5};
		int yp[]= {y1, y2, y3, y4, y5};
		
		pol = new Polygon(xp, yp, 5);

	}

	public Kometa(int x, int y, int r) {
		super(x, y, Color.GRAY, r);

	}

	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		setPolygon();
		g.fillPolygon(pol);
	}


	
}
