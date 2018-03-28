package model;

public class Soldier extends Piece
{

	
	public Soldier()
	{
		;
	}

	private final int MOVE_MAX = 1;
	private final int ATTACK_RANGE = 1; // Maybe not needed?

	

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

	@Override
	public int getMoveMax() {
		return this.MOVE_MAX;
	}

	@Override
	public int getAttackRange() {
		return this.ATTACK_RANGE;
	}
	
	//move 1 step
	//Direction: 360
	//Attack type: slash
	
	//Attack and move are the same 
	//Some piece dont though

}
