package com.game.round;

import java.awt.BorderLayout;

import java.util.ArrayList;


import javax.swing.JPanel;
import javax.swing.Timer;


import com.game.card.CardItem;
import com.game.configuration.Configuration;

public class Round extends JPanel implements IRoundController{
	
	private Configuration _roundConfiguration;
	private PlayerSection _playerSection;
	private TableSection _roundTable;
	private IRoundActionListener _roundListener;
	private ArrayList<CardItem> _selectedCards = new ArrayList<CardItem>();
	
	public Round(Configuration roundConfiguration, IRoundActionListener roundListener) {
		setLayout( new BorderLayout());
		_roundListener = roundListener;
		_roundConfiguration = roundConfiguration;
		
		
		/* Seção dos jogadores */
		_playerSection = new PlayerSection(_roundConfiguration.getPlayerCount());
		add(_playerSection, BorderLayout.WEST);

		_roundTable = new TableSection(_roundConfiguration.getGameDifficulty(), this);
		add(_roundTable, BorderLayout.CENTER);

	
		
	}
	
	@Override
	public void cardItemClicked(CardItem item) {
		
		//Se ja forame escolhidas duas cartas, esperar o processamento para realizar ação
		if (_selectedCards.size() == 2)
			return;
		
		//Evita o click em uma mesma carta 2 vezes
		if (_selectedCards.size() == 1 && _selectedCards.get(0) == item)
			return;
		
		_selectedCards.add(item);
		item.drawCardImage();

		
		if (_selectedCards.size() == 2) {
			Timer t = new Timer(1500, e -> {
				_playerSection.addTry(_selectedCards.get(0), _selectedCards.get(1));
				_selectedCards.clear();
				
				checkGameState();
			});
    		t.start();
		}
	
	}
	
	private void checkGameState() {
		//Jogo acabou, todas as cartas foram descobertas
		if (_roundTable.allCardsDiscovered()) {
			DisplayRoundStats();
			_roundListener.GameEnded();
		}
	}
	
	private void DisplayRoundStats() {
		new RoundStats(_playerSection.getPlayers());
	}
}
