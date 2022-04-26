package Elements;

import Board.Board;

public class Checkpoint extends Element{
	
	
	
	public Checkpoint(int id) {
		ID = id;
	}
	
	public int effect(int score) {
//		int v;
//		
//		if(visited) v = 5;
//		else v = 10;
//		
//		visited = true;
//		return v;
		return 0;
		
	}
	public void reset(Robot robot) {
		if (!visited && robot.getCheckCount() == ID-1) {
			robot.setScore(robot.getScore()+10);
		}
		else if (visited && robot.getCheckCount() >= robot.getNumCheckpoints()) {
			robot.setScore(robot.getScore()+5);
		}
		robot.setCheckCount(robot.getCheckCount()+1);
	}
	
	public void move(Robot robot, Board board) {
		
	}
	
	public String message() {
		return "Checkpoint";
	}
}
