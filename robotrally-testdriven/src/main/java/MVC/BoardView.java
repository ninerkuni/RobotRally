//package MVC;
//
//import Board.ObstacleFactory;
//import Elements.Element;
//import Elements.Gear;
//import Elements.Obstacle;
//import Elements.Pit;
//import Player.Card;
//
//import java.awt.*;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.*;
//import javax.swing.border.Border;
//
//public class BoardView extends View {
//	private int dimensions;
//
//	private String[][] board;
//	private String[] cards;
//
//	JFrame cardDisplay;
//
//
//	JPanel boardDisplay;
//	JPanel handPanel;
//	JPanel orderPanel;
//
//	JPanel stats;
//	JFrame trace;
//
//
//	ArrayList<Element> elements = new ArrayList<>();
//
//	public BoardView(Controller controller) {
//		super(controller);
//		System.out.println("boardView()");
//
//		rally.remove(panel);
//		panel.removeAll();
//		rally.repaint();
//
//		rally.setPreferredSize(new Dimension(1000,800));
//
//		panel.setLayout(new BorderLayout());
//
//		stats = new DisplayPanel();
//
//		dimensions = controller.getDimensions();
//
//		updateStatistics();
//		setUpGame();
//		board();
//		rally.pack();
//
//	}
//
//	public void updateStatistics() {
//		stats.removeAll();
//		stats.setLayout(new FlowLayout());
//		controller.getStats();
//		stats.repaint();
//		panel.add(stats,BorderLayout.PAGE_END);
//
//	}
//
//	public void addStats(String name, int[] stats) {
//
//		int row = 0;
//
//		DisplayPanel statistics = new DisplayPanel();
//		JLabel n = new JLabel(name);
//		JLabel s = new JLabel("Score: "+stats[0]);
//		JLabel check = new JLabel("Checkpoint Counter: "+stats[1]+"/"+controller.getNumCheckpoints());
//		statistics.add(n, row(c,row));
//		row++;
//		statistics.add(s,row(c,row));
//		row++;
//		statistics.add(check,row(c,row));
//
//		this.stats.add(statistics);
//
//
//	}
//
////	private JLabel cardIllustration(String title){
////		JLabel card = new JLabel(title);
//////		card.setBackground(new Color(-16143860));
////		card.setForeground(Color.WHITE);
////		return card;
////	}
//
//	private int count;
//	private JButton cardChoice(String title){
//		ImageIcon icon = new ImageIcon();
//		try {
//			icon = CardImages.card(title);
//		}
//		catch (IOException e){
//			showWarning("Image tile couldn't be found!");
//		}
//		JLabel spot = new JLabel(icon);
//		spot.setAlignmentX(Component.CENTER_ALIGNMENT);
//		JButton card = new JButton(icon);
//		card.setAlignmentX(Component.CENTER_ALIGNMENT);
//		card.addActionListener(
//				e->{
//					controller.setCardToPosition(title,count);
//					orderPanel.add(spot,titleRow(c,count+1));
//					card.setVisible(false);
//					handPanel.repaint();
//					orderPanel.repaint();
//					count++;
//				}
//		);
//		return card;
//	}
//
//
//
//	@Override
//	public void updateCards(){
//
//	}
//
//	private void showCards(){
//		JLabel title = new JLabel("Your cards:");
//		title.setForeground(Color.WHITE);
//
//		handPanel = new JPanel();
//		handPanel.setLayout(new BoxLayout(handPanel, BoxLayout.Y_AXIS));
//		handPanel.setBackground(new Color(-16143860));
//
//		orderPanel = new JPanel();
//		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
//		orderPanel.setBackground(new Color(-16143860));
//
//		cards = controller.getCards();
//		count = 0;
//		int row = 0;
//		handPanel.add(title,titleRow(c,row));
//
//		for(int i = 0; i < cards.length; i++){
//			System.out.println("Card: "+cards[i]);
//			handPanel.add(cardChoice(cards[i]),titleRow(c,i+1));
//		}
//
//		JButton Done = new JButton("Done");
//		Done.addActionListener(
//				e-> {
//					if(controller.isOrdered()){
//
//						controller.playCardsOneByOne();
//					}
//				}
//		);
//
//
//
//		row++;
//
//		orderPanel.add(Done,mainMenu(c,cards.length));
//		panel.add(handPanel,BorderLayout.WEST);
//		panel.add(orderPanel, BorderLayout.EAST);
//
//	}
//
//	private void setUpGame(){
//		JButton drawCards = new JButton("Draw cards");
//		drawCards.addActionListener(
//				e->{
//					controller.drawCards();
//					drawCards.setVisible(false);
//					showCards();
//				}
//		);
//		panel.add(drawCards,BorderLayout.PAGE_START);
//
//
//	}
//
//	private void board(){
//		System.out.println("board()");
//		System.out.println(controller);
//
//		board = new String[dimensions][dimensions];
//
//		update();
//
//	}
//
//	@Override
//	public void update() {
//		System.out.println("view updated...");
//		panel.removeAll();
//		rally.remove(panel);
//		updateStatistics();
//		loadBoard();
//		fillImages();
//		showCards();
//		rally.add(panel);
//		rally.repaint();
//		rally.pack();
//	}
//	@Override
//	public void nextRound() {
//		setUpGame();
//		update();
//	}
//
//
//	private void fillImages() {
//		JPanel boardPanel = new DisplayPanel();
//		boardPanel.setLayout(new GridLayout(dimensions, dimensions, 10, 10));
//		JLabel tile = new JLabel();
//		for(int j = 0; j < dimensions; j++) {
//			for (int i = 0; i < dimensions; i++) {
//				try {
//					tile = Tile.tile(board[i][j]);
//				}
//				catch (IOException e){
//					showWarning("Image tile "+board[i][j]+" couldn't be found!");
//				}
//				boardPanel.add(tile);
//			}
//		}
//		panel.add(boardPanel, BorderLayout.CENTER);
//	}
//
//
//	public void addTrace(String card) {
//		if(trace == null){
//
//		}
//	}
//
//	private void fill(){
//		JButton tile;
//		for(int i = 0; i < dimensions; i++) {
//			for (int j = 0; j < dimensions; j++) {
//				tile = new JButton(board[i][j]);
//				panel.add(tile);
//			}
//		}
//		rally.add(panel, BorderLayout.CENTER);
//		rally.pack();
//
//	}
//
//	private void initiateElements(int size) {
//		System.out.println("elements instantiated");
//		Obstacle o = new Pit();
//		o.setCoordinates(3,4);
//		elements.add(o);
//
//		o = new Gear();
//		o.setCoordinates(5,6);
//		elements.add(o);
//
//		//ObstacleFactory factory = new ObstacleFactory();
//		//factory.defaultFill();
//		//System.out.println("There are"+size+"elements");
//		//for(int i = 0; i < size; i++) {
//		//	Obstacle o = factory.pick();
//		//	System.out.println(o.message());
//		//	elements.add(o);
//		//}
//
//	}
//
//	public ArrayList<Element> getElements() {
//		return elements;
//	}
//
//	public void loadBoard(){
//		board = controller.loadBoard();
//	}
//
////	public void showBoard() {
////		System.out.println("board is shown");
////		rally.repaint();
////		JButton tile;
////		tile = new JButton("Button");
//////		rally.add(tile,3,4);
////		panel.add(tile,3,4);
////		rally.add(panel);
//////		for(int i = 0; i < dimensions; i++) {
//////			for (int j = 0; j < dimensions; j++) {
//////				if(board[i][j] == null){tile = new JButton("empty"); System.out.println("empty at "+i+" "+j);}
//////				else {tile = new JButton(board[i][j]);System.out.println("element at "+i+" "+j);}
//////				rally.add(tile);
//////			}
//////		}
////		//rally.add(boardDisplay);
////		rally.pack();
////
////	}
//
//
//
//
//
//
//
//
//	}
//
//
