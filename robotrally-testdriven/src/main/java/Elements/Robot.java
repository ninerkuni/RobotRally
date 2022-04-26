package Elements;


import Board.Board;


public class Robot extends Element {
	private String name;
	private int score;
	private Coordinates start; 
	private int checkCount;
	private Board board;
	

	private int orientation;


	

	
	public Robot(String name, Board board) {
		this.name = name;
		this.board = board;
//		direction = Direction.N;
		orientation = 0;
//		direction = Dir.get(0);
		score = 0;
	}
	
	public Robot(Board board) {
		this.board = board;
//		direction = Direction.N;
		orientation = 0;
//		direction = Dir.get(0);
		score = 0;
	}
	
	public void reset() {
//		direction = Direction.N;
		orientation = 0;
		score = 0;
		coordinates = start;
	}
	
	public void setStart(int x, int y) {
		start = new Coordinates(x,y);
		coordinates = start;
	}
	
	public Coordinates getStart() {
		return start;
	}

	
	public int getNumCheckpoints() {
		return board.getCheck();
	}
	
	boolean possibleMove(int x, int y) {
		int bound = board.getDimensions();
		return (x < bound && x >= 0 && y < bound && y >= 0);
		
		}
	
	public int next_x() {
		int x = coordinates.getx();
//		System.out.print(orientation);
		return x-((orientation-3)%2);
		
//		if (direction == Direction.W) return x-1;
//		else if (direction == Direction.E) return x+1;
//		else return x;
	}
	
	public int next_y() {
		int y = coordinates.gety();
		return y+((orientation-2)%2);
//		if (direction == Direction.N) return y-1;
//		else if (direction == Direction.S) return y+1;
//		else return y;
	}
	

	

	public int getCheckCount() {
		return checkCount;
	}
	
	public void setCheckCount(int c) {
		checkCount = c;
	}
	

	
//	private void hit(int x, int y) {
//		Element e = board.getElementSpot(x, y);
//		score += e.effect(score);
//		
//		//only takes effect for the conveyer belt
//		e.move(this,board);
//		System.out.println(e.message());
//	}
	
	public String hit(Element e) {
		score += e.effect(score);
		e.move(this);
		e.reset(this);
		return e.message();
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int i) {
		score = i;
	}
	
	public boolean validMove() {
		return possibleMove(next_x(),next_y());
	}
	

	
	
	
	public boolean move(boolean valid) {
		//re-implement the hit (because e.move() changes the coordinates, so hit() has to be after
//		boolean moved = false;
		if(valid) {
			Coordinates next = new Coordinates(next_x(),next_y());
			if(!board.isEmpty(next)){
				Element e = board.getElement(next);
				hit(e);
//				System.out.println("hit element");
			}
			else {
				setCoordinates(next_x(), next_y());
//				System.out.println("Moved");
			}
//			if(board.checkSpot(next_x(), next_y())) {
//				hit(next_x(),next_y());
//				Element e = board.getElementSpot(next_x(), next_y());
//				if(!e.isBarrier()) {
//					setCoordinates(next_x(), next_y(), index);
//					return true;
//				}
//				else return false;
//			}
//			else {
			
				return true;
//			}
			
			
		}
		
		else {
//			System.out.println("Not possible to move");
			return false;
		}

//		board.print();
//		System.out.println(name + " moved!");
		
//		
	}
	
	public boolean moved() {
		return move(new Coordinates(next_x(),next_y()));
	}
	
	//move from the element class, could be used to make one robot push another
	@Override
	public void move(Robot robot) {
		Coordinates coordinates = robot.coordinates;
		for(int i = 0; i < 3;i++) {
			coordinates.movey((robot.getOrientation()-2)%2);
			coordinates.movex(-(robot.getOrientation()-3)%2);
			robot.move(coordinates);
		}
		
	}
	
	
	//effect when one robot hits another
	public int effect(int x) {
		return -2;
	}
	
	public String turnL() {
		orientation = (orientation+3)%4;
		return "turned left!";
	}
	
	public String turnR() {
		orientation = (orientation+1)%4;
		return "turned right!";
	}
	
	public int getOrientation() {
		return orientation;
	}

	public String message() {
		return "Robot "+name;
	}
//	
	public void setOrientation(int d) {
		orientation = d;
	}

	public boolean winner() {
		if(checkCount == board.getCheck()) return true;
		else return false;
	}

	public boolean move(Coordinates coordinates) {
		if(possibleMove(coordinates.getx(),coordinates.gety())) {
			setCoordinates(coordinates);
			if(!board.isEmpty(coordinates)) {
				Element e = board.getElement(coordinates);
				hit(e);
			}
		}
		return(getCoordinates() == coordinates);
		
	}


	
}
