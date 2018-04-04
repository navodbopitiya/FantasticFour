package model;

import java.util.ArrayList;


public abstract class  Piece 
{
	
	/*
	 * a piece:
	 * -moves
	 * -attack
	 * -capture flag
	 * 
	 * -knows its own location
	 * -knows who it belongs to
	 * -knows its next legal moves
	 * -knows its next legal attack
	 * -knows when it is attacked by other player: removal
	 */
	protected String id;
	
	protected String name;
	
	protected Square coordinate;
	
	protected int moveMax;
	
	protected int attackRange;
	
	protected int[] moveDirections;
	
	protected ArrayList<Square> avalaibleMovements;
	
	protected int[] attackDirections;
	
	protected Player player;
		
	public Piece(String id)
	{
		this.id = id;
	}
	
	public Piece(Square coordinate, int moveMax, int attackRange) 
	{
		
		this.coordinate = coordinate;
		this.moveMax = moveMax;
		this.attackRange = attackRange;
	}

	public void setCoordinate(Square coordinate)
	{
		if (coordinate.isOccupied()== false)
			this.coordinate = coordinate;
		else
			System.out.println("square is occupied");
	}
	
	public boolean captureFlag(){
		//get flag location
		//if flag not ours and within move range
		//return true
		
		return true;
	}
	
	/**
	 * @param @pre source must be a Square with a piece
	 * @param @pre target must be a Square without a piece 
	 */
	public abstract void move(Square source, Square target);
	
	public abstract void attack(Square source, Square target, Piece enemy);

	// get and set /////////////////////
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public int getMoveMax()
	{
		return moveMax;
	}

	public void setMoveMax(int moveMax)
	{
		this.moveMax = moveMax;
	}

	public int getAttackRange()
	{
		return attackRange;
	}

	public void setAttackRange(int attackRange)
	{
		this.attackRange = attackRange;
	}
	
	public int[] getMoveDirections()
	{
		return moveDirections;
	}

	public void setMoveDirections(int[] moveDirections)
	{
		this.moveDirections = moveDirections;
	}

	public int[] getAttackDirections()
	{
		return attackDirections;
	}

	public void setAttackDirections(int[] attackDirections)
	{
		this.attackDirections = attackDirections;
	}

	public Square getCoordinate()
	{
		return coordinate;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}
}
