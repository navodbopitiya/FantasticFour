/**
 * 
 */
package model;

import model.GameConstants.PLAYER_SIDE;

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
	private Piece[] piecesLegend;
	
	/**
	 * to hold the pieces in the board
	 */
	private Piece[] pieces;
	
	
	public Player(PLAYER_SIDE sidePosition,String name)
	{
		int num = GameConstants.NUMBER_OF_LEGEND_SQUARE * GameConstants.NUMBER_OF_PIECES_LEGEND;
		this.sidePosition = sidePosition;
		this.piecesLegend = new Piece[num];
		if (sidePosition==PLAYER_SIDE.NORTH)
		{
			piecesLegend[0] = new Soldier();
			piecesLegend[1] = new Soldier();
			piecesLegend[2] = new Soldier();
			piecesLegend[3] = new Soldier();
			piecesLegend[4] = new Soldier();
			piecesLegend[5] = new Soldier();
		}
		if (sidePosition==PLAYER_SIDE.SOUTH)
		{
			piecesLegend[0] = new Soldier();
			piecesLegend[1] = new Soldier();
			piecesLegend[2] = new Soldier();
			piecesLegend[3] = new Soldier();
			piecesLegend[4] = new Soldier();
			piecesLegend[5] = new Soldier();
		}
		
		this.playername = name;
	}
	
	public String getPlayername()
	{
		return playername;
	}

	public void setPlayername(String playername)
	{
		this.playername = playername;
	}

	public Piece[] getPieces()
	{
		return pieces;
	}

	public void setPieces(Piece[] pieces)
	{
		this.pieces = pieces;
	}

	public PLAYER_SIDE getSidePosition()
	{
		return sidePosition;
	}

	public void setSidePosition(PLAYER_SIDE sidePosition)
	{
		this.sidePosition = sidePosition;
	}

	/**
	 * 
	 * @return
	 */
	public Piece selectPiece()
	{
		return null;
		
	}
	
	/**
	 * 
	 */
	public void setPiece(){
		
	}
	
	/**
	 * 
	 */
	public void movePiece(){
		
	}
	
	/**
	 * 
	 */
	public void attackPiece(){
		
	}
	
	/**
	 * 
	 */
	public void captureFlag(){
		
	}
}
