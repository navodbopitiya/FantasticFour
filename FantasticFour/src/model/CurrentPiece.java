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
	
	@Override
	public void move(Square source, Square target)
	{
		target.setPiece(source.getPiece());
		target.setIcon(source.getIcon());
		target.setOccupied(true);
		//
		source.setIcon(null);
		source.setPiece(null);
		source.setOccupied(false);
	}
	
	@Override
	public void attack(Square source, Square target, Piece enemy)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
