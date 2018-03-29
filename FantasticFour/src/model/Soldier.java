package model;

import java.util.ArrayList;

public class Soldier extends Piece
{

	
	/**
	 * move 1 step
	 * Direction: 360
	 * Attack type: slash
	 * 
	 * Description: A soldier can attack enemy within its range
	 * 
	 */
	
	/*===================
	 * SOLDIER DEFINITION
	 *===================
	 */
	public Soldier(Player player, Square coordinate) {
		super(player, coordinate);
	}
	
	
	/*===================
	 * MOVEMENT
	 *===================
	 */
	@Override
	public int getMoveRange() {
		return Piece.RANGE_TWO;
	}

	@Override
	public ArrayList<Square> getMoveDirection() {
		ArrayList<Square> nextMoves = new ArrayList<Square>();
		
		for(int i= 1; i<=this.getMoveRange(); i++){
			nextMoves.add(super.dirNorth(i));
			nextMoves.add(super.dirEast(i));
			nextMoves.add(super.dirSouth(i));
			nextMoves.add(super.dirWest(i));
			nextMoves.add(super.dirNorthEast(i));
			nextMoves.add(super.dirNorthWest(i));
			nextMoves.add(super.dirSouthEast(i));
			nextMoves.add(super.dirSouthWest(i));
		}
		return nextMoves;
	}

	@Override
	public void move(Square location) {
		/*
		 * check for obstruction(if the square is occupied, do not allow)
		 * check if the location is within the range
		 */
//		if (!location.isOccupied() && this.getMoveDirection().contains(location)){
//			this.getCoordinate().setOccupied(false);
//			this.setCoordinate(location);
//		}
//		else{
//			System.out.println("Illegal move");
//		}
		
		ArrayList <Square> legalMoves = this.getMoveDirection();
		
		
		System.out.println(location.getPositionX() + " " + location.getPositionY());
			
		if (legalMoves.contains(location)){
			System.out.println(location.getPositionX() + " " + location.getPositionY());
		}
		else{
			System.out.println(" Illegal move");
		}
	}

	/*===================
	 * ATTACKING
	 *===================
	 */
	@Override
	public int getAttackRange() {
		return Piece.RANGE_ONE;
	}

	@Override
	public ArrayList<Square> getAttackDirection() {
		ArrayList<Square> attackArea = new ArrayList<Square>();
		
		for(int i= 1; i<=this.getAttackRange(); i++){
			attackArea.add(super.dirNorth(i));
			attackArea.add(super.dirEast(i));
			attackArea.add(super.dirSouth(i));
			attackArea.add(super.dirWest(i));
			attackArea.add(super.dirNorthEast(i));
			attackArea.add(super.dirNorthWest(i));
			attackArea.add(super.dirSouthEast(i));
			attackArea.add(super.dirSouthWest(i));
		}
		return attackArea;
	}

	
	// Note: Please add removePiece() in player class
	// 		 and change the player pieces array to arraylist type for easy removal
//	/**
//	 * remove attacked piece from arrayList of pieces
//	 * 
//	 */
//	public void removePiece(Piece piece){
//		boolean exist = false;
//		for (Piece p: pieces){
//			if (p == piece){
//				exist = true;
//			}
//		}
//		
//		if (exist == true){
//			pieces.remove(piece);
//		}
//	}
	
	@Override
	public void attack(Square location, Piece enemyPiece) {
		
		if (location.isOccupied() && this.getAttackDirection().contains(location)){
			
			if (this.getPlayer() == enemyPiece.getPlayer()){
				System.out.println("You can't attack your own piece");
			}
			else{
				Player enemyPlayer = enemyPiece.getPlayer();
				enemyPlayer.removePiece(enemyPiece);
				location.setOccupied(false);
			}
		}		
	}

}
