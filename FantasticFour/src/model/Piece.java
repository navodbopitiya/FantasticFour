package model;

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
	
	private Player player;
	private Square coordinate;
	private int moveMax, attackRange;
	private Integer[] moveDirections, attackDirections;
		
		
	public Piece(Player player, Square coordinate, int moveMax, int attackRange) {
		
		this.player = player;
		this.coordinate = coordinate;
		this.moveMax = moveMax;
		this.attackRange = attackRange;
	}

	public void setPlayer(Player player){
		this.player = player;
	}
	
	public Player getPlayerName(){
		return player;
	}
	
	public void setCoordinate(Square coordinate){
		if (coordinate.isOccupied()== false)
			this.coordinate = coordinate;
		else
			System.out.println("square is occupied");
	}
	
	public Square getCoordinate(){
		return coordinate;
	}
	
	public int getMoveMax() {
		return moveMax;
	}
	
	public int getAttackRange() {
		return attackRange;
	}
	
	public boolean captureFlag(){
		//get flag location
		//if flag not ours and within move range
		//return true
		
		return true;
	}
	
	public Integer[] getMoveDirections() {
		return moveDirections;
	}
	public Integer[] getAttackDirections() {
		return attackDirections;
	}
	
	
	
	public abstract void move();
	public abstract void attack();
	
	
	
	
	
//	private String pieceName;
//	private int moveMax, attackRange, locationX, locationY;
//	private Integer[] pieceCapability, moveDirections, attackDirections;
//	
//	
//	public int getLocationX() {
//		return locationX;
//	}
//	public void setLocationX(int locationX) {
//		this.locationX = locationX;
//	}
//	public int getLocationY() {
//		return locationY;
//	}
//	public void setLocationY(int locationY) {
//		this.locationY = locationY;
//	}
//	public String getPieceName() {
//		return pieceName;
//	}
//	public boolean captureFlag(){
//		return true;
//	}
//	
//	public int getMoveMax() {
//		return moveMax;
//	}
//	public int getAttackRange() {
//		return attackRange;
//	}
//	public Integer[] getPieceCapability() {
//		return pieceCapability;
//	}
//	public Integer[] getMoveDirections() {
//		return moveDirections;
//	}
//	public Integer[] getAttackDirections() {
//		return attackDirections;
//	}
//	
//	
//	public abstract void move();
//	public abstract void attack();

}
