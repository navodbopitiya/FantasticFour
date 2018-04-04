/**
 * 
 */
package model;

import java.util.HashMap;

import model.GameConstants.PLAYER_SIDE;
import view.LegendPanel;

/**
 * @author Navod Bopitiya
 *
 */
public class Player 
{
	/**
	 * the player name
	 */
	private String playername;
	
	/**
	 * the side of player,could be north or south
	 * to distingush is it PlayerA or PlayerB 
	 */
	private PLAYER_SIDE sidePosition;
	
	/**
	 * to store pieces in the legend area
	 */
	private HashMap<Integer, LegendSquare> legendSquare;
	
	/**
	 * to hold the pieces in the board
	 */
	private HashMap<String, Piece> boardPieces;
	
	/**
	 * get the Legend Panel belong to this player
	 */
	private LegendPanel legendPanel; 
	
	/**
	 * to present if the player has moved
	 */
	private boolean moved;
	
	
	public Player(PLAYER_SIDE sidePosition,String name)
	{
		this.playername = name;
		
		this.sidePosition = sidePosition;
		
		this.legendSquare = new HashMap<Integer, LegendSquare>();

		this.boardPieces = new HashMap<String, Piece>();
	}
	
	public String getPlayername()
	{
		return playername;
	}

	public void setPlayername(String playername)
	{
		this.playername = playername;
	}

	public HashMap<Integer, LegendSquare> getLegendSquare()
	{
		return legendSquare;
	}

	public void setLegendSquare(HashMap<Integer, LegendSquare> legendSquare)
	{
		this.legendSquare = legendSquare;
	}

	public HashMap<String, Piece> getBoardPieces()
	{
		return boardPieces;
	}

	public void setBoardPieces(HashMap<String, Piece> boardPieces)
	{
		this.boardPieces = boardPieces;
	}

	public PLAYER_SIDE getSidePosition()
	{
		return sidePosition;
	}

	public void setSidePosition(PLAYER_SIDE sidePosition)
	{
		this.sidePosition = sidePosition;
	}

	public LegendPanel getLegendPanel()
	{
		return legendPanel;
	}

	public void setLegendPanel(LegendPanel legendPanel)
	{
		this.legendPanel = legendPanel;
	}

	public boolean isMoved()
	{
		return moved;
	}

	public void setMoved(boolean moved)
	{
		this.moved = moved;
	}
	
}
