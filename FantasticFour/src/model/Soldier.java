package model;


public class Soldier extends Piece
{
	public Soldier(String id)
	{
		super(id);
		this.name ="soldier";
		this.moveDirections = new int[]{1,2,3,4,5,6,7,8};
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
		System.out.println("Soldier has moved.");
	}

	@Override
	public void attack(Square source, Square target, Piece enemy)
	{
		
	}

}
