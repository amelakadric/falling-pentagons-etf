package simulator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame{
	
	private Svemir svemir = new Svemir();
	Panel komande = new Panel();
	Generator generator = new Generator(svemir);
	Button button = new Button("Pokreni!");
	Panel buttonPanel = new Panel();
	
	
	private void populateWindow() {
		add(svemir, BorderLayout.CENTER);
		
		
		button.addActionListener((ae)->{
			generator.pokreni();
//			svemir.repaint();
			button.disable();
		});
		
		buttonPanel.add(button);
		buttonPanel.setBackground(Color.WHITE);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	public Simulator() {
		
		setBounds(700, 200, 200, 400);
		
		setResizable(true);
		
		populateWindow();
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				svemir.thread.interrupt();
				generator.thread.interrupt();
				dispose();
			}
		});
		
		
		setVisible(true);
		
		
		
	}
	
	

	public static void main(String[] args) {
		new Simulator();
		
		
	}

}
