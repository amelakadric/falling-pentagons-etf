package simulator;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable{
	
	Thread thread;
	ArrayList<NebeskoTelo>nebeskaTela = new ArrayList<>();	
	
	
	@Override
	public void paint(Graphics g) {
		thread = new Thread(this);
		thread.start();
		for(NebeskoTelo n:nebeskaTela) {
			n.paint(getGraphics());
		}
		super.paint(g);
	}
	
	
	public synchronized void addNebeskoTelo(NebeskoTelo n) {
		nebeskaTela.add(n);
	}
	
	public synchronized void kretanje() {
		for( NebeskoTelo n:nebeskaTela) {
			int ny= n.getY()+5;
			n.setY(ny);
		}
	}
	
	public Svemir() {
		this.setBackground(Color.BLACK);
		NebeskoTelo neb = new Kometa(25, 80, 90);
		this.addNebeskoTelo(neb);
	}

	@Override
	public void run() {
		try {	
			while(!thread.isInterrupted()) {
			thread.sleep(100);
			repaint();
//			kretanje();
			}
		}catch(InterruptedException e){}
		
		
		
	}
	
	
	
}
