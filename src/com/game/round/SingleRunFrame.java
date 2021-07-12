package com.game.round;


import javax.swing.JFrame;

public class SingleRunFrame extends JFrame{
	
	public SingleRunFrame() {
		super();
		
	}
	public void ShowOnce() {
		
		setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
		setVisible(true);
		
		toFront();
		requestFocus();
	}
}
