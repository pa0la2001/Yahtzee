package com.grupi2c.yahtzee.model;

public abstract class Game {
	protected String gameType;
	protected String gameName;

	public Game(String gameType, String gameName) {
		this.gameType = gameType;
		this.gameName = gameName;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
}
