package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Kometa extends NebeskoTelo{
	Polygon pol;
	double randUg;
	double p;
	
	private synchronized void setPolygon() {
		int x1, x2, x3, x4, x5;
		int y1, y2, y3, y4, y5;
		x1=(int) (p*Math.cos(randUg*Math.PI/180)+getX()); y1=(int) (p*Math.sin((randUg)*Math.PI/180)+getY());
		x2=(int) (p*Math.cos((randUg+72)*Math.PI/180)+getX()); y2=(int) (p*Math.sin((randUg+72)*Math.PI/180)+getY());
		x3=(int) (p*Math.cos((randUg+72*2)*Math.PI/180)+getX()); y3=(int) (p*Math.sin((randUg+72*2)*Math.PI/180)+getY());
		x4=(int) (p*Math.cos((randUg+72*3)*Math.PI/180)+getX()); y4=(int) (p*Math.sin((randUg+72*3)*Math.PI/180)+getY());
		x5=(int) (p*Math.cos((randUg+72*4)*Math.PI/180)+getX()); y5=(int) (p*Math.sin((randUg+72*4)*Math.PI/180)+getY());
			
		int xp[]= {x1, x2, x3, x4, x5};
		int yp[]= {y1, y2, y3, y4, y5};
		
		pol = new Polygon(xp, yp, 5);
		
	}

	public Kometa(int x, int y, int r) {
		super(x, y, Color.GRAY, r);
		randUg=Math.random()*360;
		p =Math.random()*30;

	}

	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		setPolygon();
		g.fillPolygon(pol);
	}


	
}
