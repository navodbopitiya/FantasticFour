package model;

public class SpatialController extends Piece
{
	public SpatialController(String id)
	{
		super(id);
		this.name ="spatialcontroller";
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
