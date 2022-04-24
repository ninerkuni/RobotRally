package Gameplay;

import java.util.ArrayList;

import Elements.Robot;

public class Game {
	ArrayList<Robot> robots = new ArrayList<Robot>();
	
	
	public boolean isFinished() {
		return robots.stream().anyMatch(o -> o.winner()==true);
	}

	public void addRobot(Robot robot) {
		robots.add(robot);
		
	}
	
}
