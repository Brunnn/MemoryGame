package com.game.round;



import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.card.CardItem;
import com.game.configuration.Constants;

public class PlayerSection extends JPanel {
	public static int sectionWidth = 250;
	public static int sectionHeight = 500;
	public ArrayList<Player> _players = new ArrayList<Player>();
	
	private JLabel _currentPlayerLabel;
	private int _currentPlayerTurn;
	
	public PlayerSection(int playerCount) {
		setBackground(Constants.backgroundColor);
		setPreferredSize(new Dimension(sectionWidth,  sectionHeight));
	
		for (int i = 0; i < playerCount; i++) {
			_players.add(new Player("Player "+(i+1), i+1));
		}
		_players.forEach(player -> {
			add(player);
		});
		
		_currentPlayerTurn = 0;
		
		_currentPlayerLabel = new JLabel("Turno de Jogador "+getCurrentPlayingPlayer());
		add(_currentPlayerLabel);
	}
	
	public void addTry(CardItem card1, CardItem card2)   {
		Player currentPlayer = _players.get(_currentPlayerTurn);
		
		
		currentPlayer.addTry();
		
	
		//As cartas da tentativa são iguais, +1 ponto
		if (card1.getItemId().equals(card2.getItemId())) {
			currentPlayer.addPoint();
			
			card1.setVisible(false);
			card2.setVisible(false);
			
			//Mostra a descrição da carta
			new PairDescription(card1);
		}
		else {
			_currentPlayerTurn = _players.size() == _currentPlayerTurn + 1 ? 0 : _currentPlayerTurn + 1;
			_currentPlayerLabel.setText("Turno de Jogador "+getCurrentPlayingPlayer());
			card1.hideCardImage();
			card2.hideCardImage();
		}
		
	}
	
	
	public int getCurrentPlayingPlayer() {
		return _currentPlayerTurn + 1;
	}
	
	public ArrayList<Player> getPlayers(){
		return _players;
	}
}
