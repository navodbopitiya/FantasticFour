/**
 * 
 */
package controller;
import view.Board;
import model.GameConstants.GAME_STATE;
import model.Player;



public class GameEngine implements CheckGameState
{
	private GAME_STATE gameStauts = GAME_STATE.NITIALIZED;
	
	/**
	 * Access the Board class
	 */
	private Board board;
	
	/**
	 * Access the playerA class
	 */
	private Player playerA;
	
	/**
	 * Access the playerB class
	 */
	private Player playerB;
	
	/**
	 * whose turn
	 */
	private Player currentPlayer;

	
	@Override
	public Player getWinner()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
