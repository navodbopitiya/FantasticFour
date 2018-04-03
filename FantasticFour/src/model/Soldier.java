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
	public void move() {
		// check if it is player turn
		// check for obstruction(if the square is occupied, do not allow)
		
		// If selected square is within MOVE_MAX range, return new location x,y
		// If north = (x, y+MOVE_MAX) 
		// If east = (x+MOVE_MAX, y)
		// If northEast =(x+MOVE_MAX, y+MOVE_MAX)
		
		// return the square selected 
		
	}

	@Override
	public void attack() {
		//Soldier attack: removing piece that's within its movement range
		
	}

	
	
	//move 1 step
	//Direction: 360
	//Attack type: slash
	
	//Attack and move are the same 
	//Some piece dont though

}
