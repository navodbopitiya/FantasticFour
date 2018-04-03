package model;

public class Crasher extends Piece
{
	public Crasher(String id)
	{
		super(id);
		this.name ="crasher";
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
