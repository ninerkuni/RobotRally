package MVC;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SavedGameView extends View {
	
	
	public SavedGameView() {
		super();
		//decide whether we want to include a "back to main menu"
		savedGame();
	}
	
	
	
	private void savedGame() {
		rally.repaint();
		int row = 0;
		
	    JLabel gamestart = new JLabel("An old game is loaded...");
		gamestart.setHorizontalAlignment(SwingConstants.CENTER);
		gamestart.setFont(new Font("Orange Kid", Font.BOLD, 50));
		gamestart.setForeground(Color.WHITE);
		
		panel.add(gamestart,titleRow(c,row));
		row++;
	
		
		rally.add(panel);
		rally.pack();
	}
}
