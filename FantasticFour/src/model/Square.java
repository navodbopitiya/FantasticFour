/**
 * 
 */
package model;

import javax.swing.JButton;

/**
 * @author Navod Bopitiya
 *
 */
public class Square extends JButton 
{
	private int positionX, positionY;
	private boolean occupied;
	private int size;
	private boolean colour;
	
	public int getPositionX() 
	{
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
 
	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public void draw(){
		
	}
}
