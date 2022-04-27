package MVC;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NewGameView extends View {
	
	
	public NewGameView() {
		super();
		//decide whether we want to include a "back to main menu"
		newGame();
	}
	
	
	
	private void newGame() {
		rally.repaint();
		int row = 0;
		
	    JLabel gamestart = new JLabel("A new game is started...");
		gamestart.setHorizontalAlignment(SwingConstants.CENTER);
		gamestart.setFont(new Font("Orange Kid", Font.BOLD, 50));
		gamestart.setForeground(Color.WHITE);
		
		panel.add(gamestart,titleRow(c,row));
		row++;
		
		rally.add(panel);
		rally.pack();
	}
	
	
	
}
