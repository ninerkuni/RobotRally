package Elements;

import Board.Board;

abstract public class Element {
	protected Coordinates coordinates = new Coordinates();
	protected int index;
	protected Board board;
	protected int ID;
	protected boolean visited;
	
	public Element() {};
	
//	void setIndex(int i) {
//		this.index = i;
//	}
	
	public void setCoordinates(int x, int y) {
//		board.xcoordinates.add(x);
//		board.ycoordinates.add(y);
		System.out.println("set coordinates");
		coordinates.set(x,y);
		
	}
	
	public void setCoordinates(Coordinates n) {
//		board.xcoordinates.set(index,n.getx());
//		board.ycoordinates.set(index, n.gety());
		coordinates.set(n.getx(),n.gety());
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
//	abstract void move(Robot r, Board b);
	
	abstract String message();
	

	
	abstract int effect(int x);
	
	public Coordinates move(Robot robot) {
		Coordinates coordinates = new Coordinates(robot.next_x(),robot.next_y());
		return coordinates;
	}
	
	public int getID(){
		return ID;
	}
	
//	public boolean isBarrier() {
//		return false;
//	}
	

	
	public void reset(Robot robot) {
	}
	
	public void setLeft(boolean left) {
		
	}
	
	public void setVisited(boolean v) {
		visited = v;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
}
