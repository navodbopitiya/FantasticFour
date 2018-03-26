package model;

public class GameConstants
{
	public static int SIZE_OF_SQUARE   = 50;
	
	public static int NUMBER_OF_BOARD_SQUARE = 10;
	
	public static int NUMBER_OF_LEGEND_SQUARE = 3;
	
	public static enum GAME_STATE
	{
		NITIALIZED, SETTLE, PLAYING, PAUSED, GAMEOVER
	}
	
	public static enum PLAYER_SIDE
	{
		NORTH, SOUTH
	}
	
}
