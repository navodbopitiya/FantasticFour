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
	public void move() 
	{
		
	}

	@Override
	public void attack() 
	{
		
	}

	
	
	

}
