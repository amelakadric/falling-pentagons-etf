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
	public synchronized void paint(Graphics g) {
		
		for(NebeskoTelo n:nebeskaTela) {
			n.paint(getGraphics());
		}
		super.paint(g);
	}
	
	public void pokreni() {
		thread = new Thread(this);
		thread.start();
		repaint();
	}
	
	public synchronized void addNebeskoTelo(NebeskoTelo n) {
		nebeskaTela.add(n);
	}
	
	
	
	public synchronized void kretanje() {
		for( NebeskoTelo n:nebeskaTela) {
			n.pomeriY();
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
				kretanje();
				repaint();
			}
		}catch(InterruptedException e){}
		
	}
	
	
	
}
