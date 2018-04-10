package model;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JPanel;

import model.GameConstants.PLAYER_SIDE;

@SuppressWarnings("serial")
public class LegendPanel extends JPanel implements ILegendPanel
{
	private int boardWidth;
	
	private int boardHeight;
	
	private int legendWidth;
	
	private int legendHeight;
	
	private Player player;
	
	private PLAYER_SIDE sidePosition;
	
	private Label lblPlayerName; 

	private Button btnGo;
	
	private LegendSquare[] legendSquares;
	
	public LegendPanel(Player argPlayer)
	{
		this.player = argPlayer;
		this.legendSquares = new LegendSquare[GameConstants.NUMBER_OF_LEGEND_SQUARE];
		this.sidePosition = argPlayer.getSidePosition();
		this.boardWidth  = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		this.boardHeight = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		this.legendWidth = this.boardWidth;
		this.legendHeight= GameConstants.SIZE_OF_SQUARE;
		
		int x = (boardWidth/2) - (legendWidth/2);
		int y = 0;
		if (this.sidePosition == PLAYER_SIDE.NORTH)
		{
			y = 0;
		}else
		{
			y = legendHeight + boardHeight;
		}
		this.setBackground(Color.WHITE);
		//set this panel x,y positon and width and height
		this.setBounds(x, y, legendWidth, legendHeight);
		//FlowLayout flowLayout = (FlowLayout) this.getLayout();
		//flowLayout.setAlignment(FlowLayout.CENTER);
		FlowLayout flow_panel = new FlowLayout(FlowLayout.CENTER, 2, 2);
		flow_panel.setAlignOnBaseline(true);
		this.setLayout(flow_panel);
	}
	
	public void addNameLabel()
	{
		lblPlayerName = new Label(player.getPlayername());
		if (player.getSidePosition() == PLAYER_SIDE.NORTH)
		{
			lblPlayerName.setForeground(Color.RED);
		}else
		{
			lblPlayerName.setForeground(Color.BLUE);
		}
		lblPlayerName.setAlignment(Label.CENTER);
		lblPlayerName.setPreferredSize(new Dimension(GameConstants.LENGTH_OF_NAME, this.legendHeight));
		this.add(lblPlayerName);
	}
	
	public void addLegendPiece(LegendSquare square)
	{
		for(int i=0;i<legendSquares.length;i++)
		{
			if (legendSquares[i] == null)
			{
				legendSquares[i] = square;
				break;
			}
		}
		this.add(square);
	}
	
	public void addButton()
	{
		btnGo = new Button();
		String btnName = "btnGo"+player.getPlayername();
		btnGo.setName(btnName);
		btnGo.setLabel("GO");
		btnGo.setPreferredSize(new Dimension(80, 50));
		btnGo.setEnabled(false);
		this.add(btnGo);
	}
	
	public Player getPlayer()
	{
		return player;
	}

	public PLAYER_SIDE getSidePosition()
	{
		return sidePosition;
	}

	public int getLegendWidth()
	{
		return legendWidth;
	}

	public int getBoardWidth()
	{
		return boardWidth;
	}

	public LegendSquare[] getLegendSquares()
	{
		return legendSquares;
	}

	public Label getLblPlayerName()
	{
		return lblPlayerName;
	}

	public void setLblPlayerName(Label lblPlayerName)
	{
		this.lblPlayerName = lblPlayerName;
	}

	public Button getBtnGo()
	{
		return btnGo;
	}

	public void setBtnGo(Button btnGo)
	{
		this.btnGo = btnGo;
	}
}
