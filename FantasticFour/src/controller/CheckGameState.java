package controller;

import model.Player;

public interface CheckGameState
{
	/**
	 * check whether a play has win the game
	 * @return
	 */
	public Player getWinner();
}
