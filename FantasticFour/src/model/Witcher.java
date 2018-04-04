package model;

public class Witcher extends Piece
{
	public Witcher(String id)
	{
		super(id);
		this.name ="witcher";
		this.moveDirections = new int[]{2,4,6,8};
		this.moveMax = 2;
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
		System.out.println("Witcher has moved.");
	}

	@Override
	public void attack(Square source, Square target, Piece enemy)
	{
		// TODO Auto-generated method stub
		
	}

}
