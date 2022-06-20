package simulator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame{
	
	private Svemir svemir;
	Panel komande = new Panel();
	Generator generator;
	Button button = new Button("Pokreni!");
	Panel buttonPanel = new Panel();
	
	
	private void populateWindow() {
		add(svemir, BorderLayout.CENTER);
		
		
		button.addActionListener((ae)->{
			generator.pokreni();
			svemir.pokreni();
			button.setEnabled(false);
		});
		
		buttonPanel.add(button);
		buttonPanel.setBackground(Color.WHITE);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	public Simulator() {
		
		setBounds(700, 200, 200, 400);
		
		setResizable(true);
		
		svemir = new Svemir();
		generator = new Generator(svemir);
		
		populateWindow();
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try{
					svemir.thread.interrupt();
					generator.thread.interrupt();
				}catch(Exception e1) {}	
				dispose();
			}
		});
		
		
		setVisible(true);
		
		
		
	}
	
	

	public static void main(String[] args) {
		new Simulator();
		
		
	}

}
