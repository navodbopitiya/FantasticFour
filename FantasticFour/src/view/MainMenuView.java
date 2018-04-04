package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.GameEngine;

public class MainMenuView extends JFrame {

	private JFrame frame;
	public static final Pattern PATTERN = Pattern.compile("^\\d+$"); //pattern for numeric inputs
	private GameEngine gameEngine;

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	

	public MainMenuView(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		initialize();
	}

	private void initialize() {
		/*Create new frame*/
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(27, 91, 127));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/* Label for Player One Text Field*/
		JLabel lblPlayerA = new JLabel("Player One");
		lblPlayerA.setForeground(Color.ORANGE);
		lblPlayerA.setFont(new Font("Arial", Font.BOLD, 13));
		lblPlayerA.setBounds(58, 80, 120, 23);
		frame.getContentPane().add(lblPlayerA);
		
		/*TextField for Player One*/
		final JTextField playerATextField = new JTextField();
		playerATextField.setBounds(174, 80, 168, 23);
		frame.getContentPane().add(playerATextField);
		playerATextField.setColumns(10);
		
		/* Label for Player Two Text Field*/
		JLabel lblPlayerB = new JLabel("Player Two");
		lblPlayerB.setForeground(Color.ORANGE);
		lblPlayerB.setFont(new Font("Arial", Font.BOLD, 13));
		lblPlayerB.setBounds(58, 120, 120, 23);
		frame.getContentPane().add(lblPlayerB);
		
		/*TextField for Player Two*/
		final JTextField playerBTextField = new JTextField();
		playerBTextField.setBounds(174, 120, 168, 23);
		frame.getContentPane().add(playerBTextField);
		playerBTextField.setColumns(10);
		
		/* Label for TimerText Field*/
		JLabel timerlbl = new JLabel("Round Time (s)");
		timerlbl.setForeground(Color.ORANGE);
		timerlbl.setFont(new Font("Arial", Font.BOLD, 13));
		timerlbl.setBounds(58, 160, 120, 23);
		frame.getContentPane().add(timerlbl);

		/*TextField for Timer*/
		final JTextField timerTextField = new JTextField();
		timerTextField.setBounds(174, 160, 168, 23);
		frame.getContentPane().add(timerTextField);
		timerTextField.setColumns(10);
		
		/* Play button action */
		JButton btnPlay = new JButton("Play");
		btnPlay.setBackground(Color.ORANGE);	
		btnPlay.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!playerATextField.getText().isEmpty() && !playerBTextField.getText().isEmpty() 
						&& !timerTextField.getText().isEmpty()) { //Check for null fields 
					if (PATTERN.matcher(timerTextField.getText()).matches()) { //Check for non-numeric inputs for timer using a pattern
						//Set player and timer data in gameEngine
						gameEngine.initialize(playerATextField.getText(), playerBTextField.getText(), Integer.parseInt(timerTextField.getText()));
						frame.dispose();
					}else{
						//If the timerValue is non-numeric
						JOptionPane.showMessageDialog(frame, "Please enter a numeric value for timer");
					}

				}else{
				 //If there is even one field empty
					JOptionPane.showMessageDialog(frame, "Please enter all fields");
				}
				
				
			}
			
		});
		btnPlay.setBounds(174, 210, 79, 23);
		frame.getContentPane().add(btnPlay);

	}

}
