package GamePlay;

import java.util.ArrayList;

public class Game {
	ArrayList<Robot> robots = new ArrayList<Robot>();
	
	
	public boolean isFinished() {
		return robots.stream().anyMatch(o -> o.winner()==true);
	}

	public void addRobot(Robot robot) {
		robots.add(robot);
		
	}
	
}
