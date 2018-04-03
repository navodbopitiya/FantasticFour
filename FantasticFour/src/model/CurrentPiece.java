/**
 * 
 */
package model;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Mar 30, 2018
 * CurrentPiece.java
 * Describe:
 */
public class CurrentPiece extends Piece
{
	public CurrentPiece(String id)
	{
		super(id);
	}
	
	private Player player;
	
	private int	   pieceIdx;
	
	
	public Player getPlayer()
	{
		return player;
	}
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	public int getPieceIdx()
	{
		return pieceIdx;
	}
	public void setPieceIdx(int pieceIdx)
	{
		this.pieceIdx = pieceIdx;
	}
	/* (non-Javadoc)
	 * @see model.Piece#move()
	 */
	@Override
	public void move()
	{
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see model.Piece#attack()
	 */
	@Override
	public void attack()
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
