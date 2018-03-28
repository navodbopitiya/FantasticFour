/**
 * 
 */
package controller;
import javax.swing.JFrame;

import model.GameConstants.GAME_STATE;
import model.GameConstants.PLAYER_SIDE;
import model.Player;
import view.Board;
import view.BoardView;
import view.MainMenuView;



public class GameEngine implements CheckGameState
{
	/**
	 * the game state
	 * could be NITIALIZED, SETTLE, PLAYING, PAUSED, GAMEOVER
	 */
	private GAME_STATE gameStauts = GAME_STATE.NITIALIZED;
	
	/**
	 * Access the Board class
	 */
	private Board boardFrame;
	
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
	
	/**
	 * time limitation per round
	 */
	private int timerValue;

	/**
	 * initializ two Players
	 * @param PlayerA_name
	 * @param PlayerB_name
	 */
	private void initPlayer(String PlayerA_name,String PlayerB_name)
	{
		this.playerA = new Player(PLAYER_SIDE.NORTH,PlayerA_name);
		this.playerB = new Player(PLAYER_SIDE.SOUTH,PlayerB_name);
	}
	
	/**
	 * initialized the game board
	 * to add Board Panel
	 * to add two LegendPanel
	 */
	private void initBoard()
	{
		boardFrame = new Board();
		boardFrame.setBoardPanel();
		boardFrame.setLegendPanel(playerA);
		boardFrame.setLegendPanel(playerB);
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * start the login window
	 */
	public void startMainMenu()
	{
		MainMenuView mainMenuView = new MainMenuView(this);
		mainMenuView.run();
	}
	
	/**
	 * initialize Player A and Player B
	 * initialize current player
	 * initialize time limitation per round
	 * initialize game board
	 */
	public void initialize(String PlayerA_name,String PlayerB_name,int timerValue) 
	{
		initPlayer(PlayerA_name, PlayerB_name);
		this.currentPlayer = this.playerA;
		this.timerValue = timerValue;
		initBoard();
	}
	
	/**
	 * open the BoardView
	 */
	public void openBoardView(GameEngine gameEngine)
	{
		BoardView boardView = new BoardView(gameEngine);
		boardView.display();
	}
	
	/**
	 * Start to play
	 */
	public void startGame()
	{
		;
	}
	
	/**
	 * get the Winner, if the game over
	 */
	@Override
	public Player getWinner()
	{
		return null;
	}

	
	///===get and set methods==============///
	public GAME_STATE getGameStauts()
	{
		return gameStauts;
	}

	public void setGameStauts(GAME_STATE gameStauts)
	{
		this.gameStauts = gameStauts;
	}

	public Board getBoardFrame()
	{
		return boardFrame;
	}

	public void setBoardFrame(Board boardFrame)
	{
		this.boardFrame = boardFrame;
	}

	public Player getPlayerA()
	{
		return playerA;
	}

	public void setPlayerA(Player playerA)
	{
		this.playerA = playerA;
	}

	public Player getPlayerB()
	{
		return playerB;
	}

	public void setPlayerB(Player playerB)
	{
		this.playerB = playerB;
	}

	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}

	public int getTimerValue()
	{
		return timerValue;
	}

	public void setTimerValue(int timerValue)
	{
		this.timerValue = timerValue;
	}
	
}
