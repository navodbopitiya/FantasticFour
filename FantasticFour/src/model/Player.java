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

	private String playername;
	private Piece[] pieces;
	private PLAYER_SIDE sidePosition;
	
	public Player(PLAYER_SIDE sidePosition)
	{
		this.sidePosition = sidePosition;
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
