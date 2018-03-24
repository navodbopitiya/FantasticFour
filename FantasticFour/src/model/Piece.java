package model;

public abstract class  Piece {
	
	private String pieceName;
	private int moveMax, attackRange, locationX, locationY;
	private Integer[] pieceCapability, moveDirections, attackDirections;
	
	public int getLocationX() {
		return locationX;
	}
	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}
	public int getLocationY() {
		return locationY;
	}
	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}
	public String getPieceName() {
		return pieceName;
	}
	public int getMoveMax() {
		return moveMax;
	}
	public int getAttackRange() {
		return attackRange;
	}
	public Integer[] getPieceCapability() {
		return pieceCapability;
	}
	public Integer[] getMoveDirections() {
		return moveDirections;
	}
	public Integer[] getAttackDirections() {
		return attackDirections;
	}
	
	public abstract void move();
	public abstract void attack();

}
