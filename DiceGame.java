package com.grupi2c.yahtzee.model;

import com.grupi2c.yahtzee.constants.Const;

public abstract class DiceGame extends Game {

	public DiceGame(String gameName) {
		super(Const.DICE, gameName);
	}

}
