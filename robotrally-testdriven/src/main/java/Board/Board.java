package Board;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Elements.Checkpoint;
import Elements.Coordinates;
import Elements.Element;
import Elements.Obstacle;
import Elements.Robot;



public class Board {
	private int numObstacles;
	private int numCheckpoints;
	private int numRobots;
	private int dimensions;
	private int counter = 0;
	private Random rnd = new Random();
	private static Board board = null;
	private static ArrayList<Element> elements;
	// getter for all the elements on the board
	public ArrayList<Element> getElementsOnBoard(){
		return elements;}

	//method for initiating board as a singleton
	public static Board getBoard() {
		if(board == null) {
			board = new Board();
		} else {
			elements = new ArrayList<>();
		}
		return board;
	}

	
	public Board(int cols) {
		dimensions = cols;
		elements = new ArrayList<Element>();
	}
	
	
	public Board() {
		System.out.println("Board initiated");
		dimensions = 8;
		elements = new ArrayList<>();
	}

	public int getDimensions() {
		return dimensions;
	}
	
	//overload for multiplayer
	public void setUp(Robot robot, int obs, int check, ObstacleFactory factory) {
		numObstacles = obs;
		numCheckpoints = check;
		numRobots = 1;
		int center = (int) (dimensions/2);
		
		//robot is handled
		robot.setStart(center,center);
		add(robot);
		
		//checkpoints are handled
		Checkpoint c;
		for(int i = 0; i <= numCheckpoints; i++) {
			c = new Checkpoint(i);
			addRandom(c);
		}
		
		//obstacles are handled
		Obstacle o;
		for(int i = 0; i < obs;i++) {
			o = factory.pick();
			addRandom(o);
		}

	}

//	JPanel board = new JPanel();
//	board.add(new ImageIcon("resources/Cards/ASH.png"))
//JPanel Robot1_W = new JPanel();
//	BufferedImage Picture = ImageIO.read(new File("Cards/ASH_W.png"));
//	JLabel picLabel = new JLabel(new ImageIcon(Picture));
//      Robot1_W.add(picLabel);

	//multiplayer setup
	public void setUp(Robot robot1, Robot robot2, int obs, int check, ObstacleFactory factory) {
		numObstacles = obs;
		numCheckpoints = check;
		numRobots = 1;
		int center = (int) (dimensions/2);
		
		//robots are handled
		robot1.setStart(0, 0);
		robot1.setOrientation(2);
		robot2.setStart(dimensions-1, dimensions-1);
		add(robot1);
		add(robot2);
		
		//checkpoints are handled
		Checkpoint c;
		for(int i = 0; i < numCheckpoints; i++) {
			c = new Checkpoint(i);
			addRandom(c);
		}
		
		//obstacles are handled
		Obstacle o;
		for(int i = 0; i < obs;i++) {
			o = factory.pick();
			addRandom(o);
		}

	}

	//used in loadGame for loading in checkpoint
	public void setCheck(int c){ numCheckpoints = c;}

	//used for checking winner and saving the board
	public int getCheck() {
		return numCheckpoints;
	}

	public boolean isEmpty(Coordinates coordinates) {
		return !(elements.stream().anyMatch(o -> o.getCoordinates().equals(coordinates)));
	}

	public void add(Element e) {
		if(!elements.contains(e)) {
			counter++;
			elements.add(e);
		}
	}

	public void addRandom(Element e) {
		int x = (int) (dimensions*Math.random());
		int y = (int) (dimensions*Math.random());
		Coordinates c = new Coordinates(x,y);
		while(!isEmpty(c)) {
			x = (int) (dimensions*Math.random());
			y = (int) (dimensions*Math.random());
			c.set(x,y);
		}
		e.setCoordinates(c);
		add(e);
		
	}

	public boolean contains(Element e) {
		return elements.stream().anyMatch(o -> o.equals(e));
	}

	public void setUp(Robot robot, int checkpoints) {
		ObstacleFactory factory = new ObstacleFactory();
		setUp(robot,0,checkpoints,factory);

	}

	public int getElements() {
		return elements.size();
	}

	//public ArrayList<Element> getElementList() {return elements;}

	//checks if element is on coordinate
	public Element getElement(Coordinates c) {
		return (elements.stream().filter(o -> o.getCoordinates().equals(c)).findFirst().orElse(null));
	}

	public int getNumElements() {
		return elements.size();
	}


	public Integer getNumRobots() {
		return numRobots;
	}


	public void setDimensions(int d) {
		dimensions = d;
		
	}

	//used in SaveGame to save number of robots
	public int getNumObstacles() {
		return numObstacles;
	}


}
