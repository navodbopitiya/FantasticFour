package model;


public class Marine extends Piece
{
	public Marine(String id)
	{
		super(id);
		this.name ="marines";
		this.moveDirections = new int[]{2,4,6,8};
		this.moveMax = 1;
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
		System.out.println("Marine has moved.");
	}

	@Override
	public void attack(Square source, Square target, Piece enemy)
	{
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
