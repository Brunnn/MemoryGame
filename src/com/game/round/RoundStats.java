package com.game.round;

import java.util.ArrayList;

import javax.swing.JLabel;

public class RoundStats extends SingleRunFrame {
	public RoundStats(ArrayList<Player> roundPlayers) {
		super();

		
		int highestPoint = -1;
		int tries = 0;
		String highestPointPlayer = "";
		for (int i = 0; i < roundPlayers.size(); i++) {
			if (roundPlayers.get(i).getPoints() > highestPoint) {
				highestPoint = roundPlayers.get(i).getPoints();
				tries = roundPlayers.get(i).getTries();
				highestPointPlayer = "Jogador "+ roundPlayers.get(i).getPlayerId();
			}
		}
		
		add(new JLabel("O "+ highestPointPlayer + " venceu com "+ highestPoint + " pontos e "+ tries+ " tentativas"));
		
		
		ShowOnce();
	}
}
