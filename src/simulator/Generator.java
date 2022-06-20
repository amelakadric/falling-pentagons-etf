package simulator;

public class Generator implements Runnable {
	Svemir svemir;
	Thread thread;
	
	int x, y, r;
	
	public void pokreni() {
		thread=new Thread(this);
		thread.start();
	}
	
	public Generator(Svemir svemir) {
		this.svemir=svemir;
	}

	@Override
	public void run() {
		try {
			while(!thread.isInterrupted()) {
				x=(int)(Math.random()*200);
				y=0;
				r=(int)(Math.random()*(30-10))+10;
				NebeskoTelo nt = new Kometa(x, y, r);
				svemir.addNebeskoTelo(nt);
				thread.sleep(900);
			}
			
		} catch (InterruptedException e) {}
		
	}

}
