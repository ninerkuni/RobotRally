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

//	private class StorageElement{
//		private int index;
//		Element element;
//		public StorageElement(int index, Element e) {
//			this.index = index;
//			this.element = e;
//		}
//		
////		@Override
////	    public boolean equals(Object obj) {
////	    	if (obj == null) {
////	            return false;
////	        }
////
////	        if (obj.getClass() != this.getClass()) {
////	            return false;
////	        }
////
////	        final StorageElement element = (StorageElement) obj;
////	        if(this.element == null || element.element == null || this.element.coordinates== null || element.element.coordinates == null) {
////	        	return false;
////	        }
////	        
////	        return (this.element.coordinates==element.element.coordinates);
////	    }
//	}

	
	private ArrayList<Element> elements;
	ArrayList<Integer> xcoordinates;
	ArrayList<Integer> ycoordinates;
	
	
	

	
	public Board(int cols) {
		dimensions = cols;
		elements = new ArrayList<Element>();
	}
	
	
	public Board() {
		dimensions = 8;
		elements = new ArrayList<Element>();
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
	
	public void setUp(Robot robot1, Robot robot2, int obs, int check, ObstacleFactory factory) {
		numObstacles = obs;
		numCheckpoints = check;
		numRobots = 1;
		int center = (int) (dimensions/2);
		
		//robots are handled
		robot1.setStart(0, 0);
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
	
	
	
	
	public void setUp(Robot robot) {
		ObstacleFactory factory = new ObstacleFactory();
//		factory.add(new Obstacle());
		this.setUp(robot, 0, 2,factory);
	}
	
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
		while(true) {
			if(isEmpty(c)) {
				e.setCoordinates(c);
				add(e);
				break;
			}
			else {
				x = (int) (dimensions*Math.random());
				y = (int) (dimensions*Math.random());
			}
		}
		
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



	
	
}
