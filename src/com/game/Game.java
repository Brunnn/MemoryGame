package com.game;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.game.menu.Menu;
public class Game extends JFrame implements ActionListener{
	private Menu _menu = new Menu(this);
	
	public Game()
	{
		super();
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
	
		setTitle("Jogo da Memória");
	
		add(_menu);
		_menu.setVisible(true);
	}
	
	public void Play()
	{
		setVisible(true);
	}
	
	public void Hide() {
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		
	}

}
