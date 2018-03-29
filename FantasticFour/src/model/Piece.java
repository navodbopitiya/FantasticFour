package model;

import java.util.ArrayList;

public abstract class  Piece {
	
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
	
	
	/*===================
	 * PIECE CONSTANTS
	 *===================
	 */
	public static final int RANGE_ONE = 1;
	public static final int RANGE_TWO = 2;
	public static final int RANGE_THREE = 3;
	public static final int RANGE_MAX = 1;
	
	/*===================
	 * PIECE DEFINITION
	 *===================
	 */
	private Player player;
	private Square coordinate;
		
	public Piece(Player player, Square coordinate) {
		
		this.player = player;
		this.coordinate = coordinate;
	}

	public void setPlayer(Player player){
		this.player = player;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setCoordinate(Square coordinate){
		if (!coordinate.isOccupied())
			this.coordinate = coordinate;
		else
			System.out.println("square is occupied");
	}
	
	public Square getCoordinate(){
		return coordinate;
	}
	
	//Not sure how to write this yet
	public boolean captureFlag(Flag enemyFlag){
		//get flag location
		//if flag not ours and within move range
		// set flag as captured 
		//return true
		
		//flag.getLocation();
		
		return true;
	}
	
	public abstract int getMoveRange();
	public abstract ArrayList<Square> getMoveDirection();
	public abstract void move(Square location);
	
	public abstract int getAttackRange();
	public abstract ArrayList<Square> getAttackDirection();
	public abstract void attack(Square location, Piece enemyPiece);
	
	
	
	/*===================
	 * PIECE DIRECTIONS
	 *===================
	 */
	public Square dirNorth(int range){
		Square nextSquare = new Square();
		nextSquare.setPositionX(coordinate.getPositionX());
		nextSquare.setPositionY(coordinate.getPositionY() + range);
		return nextSquare;
	}
	
	public Square dirNorthEast(int range){
		Square nextSquare = new Square();
		nextSquare.setPositionX(coordinate.getPositionX() + range);
		nextSquare.setPositionY(coordinate.getPositionY() + range);
		return nextSquare;
	}
	
	public Square dirEast(int range){
		Square nextSquare = new Square();
		nextSquare.setPositionX(coordinate.getPositionX() + range);
		nextSquare.setPositionY(coordinate.getPositionY());
		return nextSquare;
	}
	
	public Square dirSouthEast(int range){
		Square nextSquare = new Square();
		nextSquare.setPositionX(coordinate.getPositionX() + range);
		nextSquare.setPositionY(coordinate.getPositionY() - range);
		return nextSquare;
	}
	
	public Square dirSouth(int range){
		Square nextSquare = new Square();
		nextSquare.setPositionX(coordinate.getPositionX());
		nextSquare.setPositionY(coordinate.getPositionY() - range);
		return nextSquare;
	}
	
	public Square dirSouthWest(int range){
		Square nextSquare = new Square();
		nextSquare.setPositionX(coordinate.getPositionX() - range);
		nextSquare.setPositionY(coordinate.getPositionY() - range);
		return nextSquare;
	}
	
	public Square dirWest(int range){
		Square nextSquare = new Square();
		nextSquare.setPositionX(coordinate.getPositionX() - range);
		nextSquare.setPositionY(coordinate.getPositionY());
		return nextSquare;
	}
	
	public Square dirNorthWest(int range){
		Square nextSquare = new Square();
		nextSquare.setPositionX(coordinate.getPositionX() - range);
		nextSquare.setPositionY(coordinate.getPositionY() + range);
		return nextSquare;
	}

}
