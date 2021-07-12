package com.game.round;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Player extends JPanel {
	private String _name;
	private int _playerId;
	private int _points = 0;
	private int _tries = 0;
	
	
	private JLabel _nameJLabel;
	private JLabel _triesJLabel;
	private JLabel _pointsJLabel;
	public Player(String name, int playerId) {
		_name = name;
		_playerId = playerId;
		setLayout(new GridLayout(0, 1, 20, 0));
		setBackground(Color.decode("#f3f3f3"));
		
		
		_nameJLabel = new JLabel(_name, SwingConstants.CENTER);
		_triesJLabel = new JLabel("Tentativas 0", SwingConstants.CENTER);
		_pointsJLabel = new JLabel("Pontos 0", SwingConstants.CENTER);
		
		add(_nameJLabel);
		add(_triesJLabel);
		add(_pointsJLabel);
		
		setVisible(true);
	}
	
	public String getPlayerName() {
		return _name;
	}

	public void addPoint() {
		_points++;
		_pointsJLabel.setText("Pontos: "+_points);
	}
	
	public void addTry() {
		_tries++;
		_triesJLabel.setText("Tentativas: "+_tries);
	}
	
	public int getPoints() {
		return _points;
	}
	
	public int getTries() {
		return _tries;
	}
	
	public int getPlayerId() {
		return _playerId;
	}
	
	
	
}
