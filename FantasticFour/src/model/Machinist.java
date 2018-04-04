package model;

public class Machinist extends Piece
{
	public Machinist(String id)
	{
		super(id);
		this.name ="machinist";
		this.moveDirections = new int[]{2,4,6,8};
		this.moveMax = GameConstants.NUMBER_OF_BOARD_SQUARE - 1;
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
		System.out.println("Machinist has moved.");
	}

	@Override
	public void attack(Square source, Square target, Piece enemy)
	{
		// TODO Auto-generated method stub
		
	}

	

	
	
	

}
