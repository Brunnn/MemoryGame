package com.game.configuration;

public class Configuration {
	private int PlayerCount;
	
	private int GameDifficulty;

	public int getGameDifficulty() {
		return GameDifficulty;
	}

	public void setGameDifficulty(int gameDifficulty) {
		GameDifficulty = gameDifficulty;
	}

	public int getPlayerCount() {
		return PlayerCount;
	}

	public void setPlayerCount(int playerCount) {
		PlayerCount = playerCount;
	}
}
