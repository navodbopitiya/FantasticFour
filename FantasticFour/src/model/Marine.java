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
	public void move() 
	{
		
	}

	@Override
	public void attack() 
	{
		
	}

	
	
	

}
