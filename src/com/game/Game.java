package com.game;





import javax.swing.*;

import com.game.configuration.Configuration;
import com.game.menu.Menu;
import com.game.menu.MenuActionListener;
import com.game.round.IRoundActionListener;
import com.game.round.Round;

public class Game extends JFrame implements MenuActionListener, IRoundActionListener{
	private Menu _menu = null; 
	private Round _round = null;
	public Game()
	{
		super();
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
	
		setTitle("Jogo da Memória");
		Restart();
		
	}
	

	//Inicia um novo jogo
	public void Restart() {
		//Remove instancias anteriores
		if (_menu != null)
			remove(_menu);
		if (_round != null)
			remove(_round);
		
		
		_menu = new Menu(this);
		_round = null;
		add(_menu);
		
		_menu.setVisible(true);
	}
	
	public void Hide() {
		setVisible(false);
	}
	
	
	//Ação quando a configuração no menu foi completada
	public void ConfigurationFinished(Configuration finalConfig) {
		_menu.setVisible(false);		
		_round = new Round(finalConfig, this);
		add(_round);
		_round.setVisible(true);
	}


	@Override
	public void GameEnded() {
		Restart();
	}
	
}
