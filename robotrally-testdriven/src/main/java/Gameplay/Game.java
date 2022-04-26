package Gameplay;

import java.util.ArrayList;

import Elements.Robot;

public class Game {
	ArrayList<Robot> robots = new ArrayList<Robot>();
	private boolean multiplayer;
	
	private String[] difficulties = {"EASY","MEDIUM","HARD"};
	
	
	public boolean isFinished() {
		return robots.stream().anyMatch(o -> o.winner()==true);
	}

	public void addRobot(Robot robot) {
		robots.add(robot);
		
	}

	public void setMultiplayer(boolean b) {
		multiplayer = b;
		
	}

	public String[] getDifficulties() {
		return difficulties;
	}
	
}
