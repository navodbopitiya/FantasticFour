/**
 * 
 */
package controller;
import view.Board;
import view.MainMenuView;
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
	private String playerOneName, playerTwoName;
	private int timerValue;
	

	
	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

	public void setTimerValue(int timerValue) {
		this.timerValue = timerValue;
	}

	@Override
	public Player getWinner()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public void printText(){
		System.out.printf("You're in the Game Engine! %n Player one Name: %s%n Player Two Name: %s%n Timer Value: %d%n",playerOneName,playerTwoName,timerValue);
	}
	
	public void startMainMenu(){
		MainMenuView mainMenuView = new MainMenuView(this);
		mainMenuView.run();
	}
}
