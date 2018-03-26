/**
 * 
 */
package controller;

<<<<<<< HEAD
import javafx.application.Application;
import view.MainMenuView;

=======
import view.Board;
import model.GameConstants.GAME_STATE;
import model.Player;
>>>>>>> origin/master

/**
 * @author Navod Bopitiya
 *
 */
<<<<<<< HEAD
public class GameEngine {
	
	private String playerOneName, playerTwoName;
	private int roundTime;
	
	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

	public void setRoundTime(int roundTime) {
		this.roundTime = roundTime;
	}

	public void startGame(){
		Application.launch(MainMenuView.class);
		System.out.println("Just checking");
=======
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
>>>>>>> origin/master
	}

}
