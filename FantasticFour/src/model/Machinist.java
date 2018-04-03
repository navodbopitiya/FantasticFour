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
	public void move() 
	{
		
	}

	@Override
	public void attack() 
	{
		
	}

	
	
	

}
