package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import GUI.ResumeFrame;
import GUI.StartFrame;

class setDefaultFont{
	static void setFont(FontUIResource myFont) {
	    UIManager.put("CheckBoxMenuItem.acceleratorFont", myFont);
	    UIManager.put("Button.font", myFont);
	    UIManager.put("ToggleButton.font", myFont);
	    UIManager.put("RadioButton.font", myFont);
	    UIManager.put("CheckBox.font", myFont);
	    UIManager.put("ColorChooser.font", myFont);
	    UIManager.put("ComboBox.font", myFont);
	    UIManager.put("Label.font", myFont);
	    UIManager.put("List.font", myFont);
	    UIManager.put("MenuBar.font", myFont);
	    UIManager.put("Menu.acceleratorFont", myFont);
	    UIManager.put("RadioButtonMenuItem.acceleratorFont", myFont);
	    UIManager.put("MenuItem.acceleratorFont", myFont);
	    UIManager.put("MenuItem.font", myFont);
	    UIManager.put("RadioButtonMenuItem.font", myFont);
	    UIManager.put("CheckBoxMenuItem.font", myFont);
	    UIManager.put("OptionPane.buttonFont", myFont);
	    UIManager.put("OptionPane.messageFont", myFont);
	    UIManager.put("Menu.font", myFont);
	    UIManager.put("PopupMenu.font", myFont);
	    UIManager.put("OptionPane.font", myFont);
	    UIManager.put("Panel.font", myFont);
	    UIManager.put("ProgressBar.font", myFont);
	    UIManager.put("ScrollPane.font", myFont);
	    UIManager.put("Viewport.font", myFont);
	    UIManager.put("TabbedPane.font", myFont);
	    UIManager.put("Slider.font", myFont);
	    UIManager.put("Table.font", myFont);
	    UIManager.put("TableHeader.font", myFont);
	    UIManager.put("TextField.font", myFont);
	    UIManager.put("Spinner.font", myFont);
	    UIManager.put("PasswordField.font", myFont);
	    UIManager.put("TextArea.font", myFont);
	    UIManager.put("TextPane.font", myFont);
	    UIManager.put("EditorPane.font", myFont);
	    UIManager.put("TabbedPane.smallFont", myFont);
	    UIManager.put("TitledBorder.font", myFont);
	    UIManager.put("ToolBar.font", myFont);
	    UIManager.put("ToolTip.font", myFont);
	    UIManager.put("Tree.font", myFont);
	    UIManager.put("FormattedTextField.font", myFont);
	    UIManager.put("IconButton.font", myFont);
	    UIManager.put("InternalFrame.optionDialogTitleFont", myFont);
	    UIManager.put("InternalFrame.paletteTitleFont", myFont);
	    UIManager.put("InternalFrame.titleFont", myFont);}
}


public class View {
	RallyFrame rally;
	JPanel panel;
	GridBagConstraints c;

	Controller controller;

	GridBagConstraints rowRight (GridBagConstraints c,int row) {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.insets = new Insets(10,10,10,10); 
		c.gridx = 2;
		c.gridy = row;
		
		return c;
	}
	
	GridBagConstraints rowLeft (GridBagConstraints c,int row) {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.insets = new Insets(10,10,10,10); 
		c.gridx = 1;
		c.gridy = row;
		
		return c;
	}
	
	GridBagConstraints titleRow (GridBagConstraints c,int row) {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 3;
		c.gridx = 1;
		c.gridy = row;
		
		return c;
	}
	
	
	GridBagConstraints mainMenu(GridBagConstraints c, int row) {
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_END;
		c.ipady = 0;//bottom of space
		c.insets = new Insets(50,10,10,10);  //top padding
		c.gridx = 2;
		c.gridy = row+1;
		
		return c;
	}
	
	
	class RallyFrame extends JFrame{
		public RallyFrame(String title) {
			super(title);
		    setPreferredSize(new Dimension(800,800));
		    setBackground(new Color(-16143860));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		}
		    
	}
	
	public View() {
		rally = new RallyFrame("Robot Rally");
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		panel.setBackground(new Color(-16143860));

	    
	      //add custom font
	      try {
		          //create the font to use. Specify the size!
		      	Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("/Users/ninapeuker/Downloads/orange_kid/orange kid.ttf")).deriveFont(48f);
	    	  	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		          //register the font
	    	  	ge.registerFont(customFont);
		      } catch (IOException e) {
		          e.printStackTrace();
		      } catch(FontFormatException e) {
		          e.printStackTrace();
		      }
	      
	      //use the font
	    setDefaultFont.setFont(new FontUIResource(new Font ("Orange Kid", Font.BOLD, 30)));
	      
	    rally.add(panel);
	    rally.setVisible(true);
	    
	}

	public void setController(Controller controller){
		this.controller = controller;
	}

//	public void updateView(int step) {
//		if(step == 0) {
//			
//			JLabel welcome = new JLabel("Welcome to Robot Rally!!!");
//			welcome.setHorizontalAlignment(SwingConstants.CENTER);
//			welcome.setFont(new Font("Orange Kid", Font.BOLD, 50));
//			welcome.setForeground(Color.WHITE);
//			
//			
//			panel.add(welcome,BorderLayout.NORTH);
//			
//			
//			JButton newGame = new JButton("New Game");
//			newGame.addActionListener(
//					e ->{
//						single = true;
////						StartFrame start = new StartFrame("start");
////						start.setVisible(true);
////						start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//						frame.dispose();
//					}	
//					);
//			panel.add(newGame,BorderLayout.CENTER);
//			
//			
//			JButton resumeGame = new JButton("Resume Game");
//			resumeGame.addActionListener(
//					e ->{
//						single = false;
////						ResumeFrame resume = new ResumeFrame("resume");
////						resume.setVisible(true);
////						resume.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//						frame.dispose();
//					}	
//					);
//			panel.add(resumeGame,BorderLayout.CENTER);
//			
//			
//			
//			
//			rally.add(panel);
//		}
//		else if (step == 1) {
//			if(display.isSingle()) {
//				StartFrame start = new StartFrame("start");
//				start.setVisible(true);
//				start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			}
//			else {
//				ResumeFrame resume = new ResumeFrame("resume");
//				resume.setVisible(true);
//				resume.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			}
//		}
//		
//	}

}
