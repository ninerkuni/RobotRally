package MVC;

import Board.Board;
import Elements.Robot;
import Gameplay.Game;
import Gameplay.GameStart;

import java.util.ArrayList;
import java.util.Collection;

public class Model {

	private ArrayList<String> robots;
	private Game game;
	private GameStart start = new GameStart();
	
	//constructor for new game
	public Model() {
		
	}
	
	public Model(String robotName, String difficulty) {
		start.setAmountOfPlayers(1);
		start.setDifficulty(difficulty);
		
	}

	public Model(String robotName1, String robotName2, String difficulty) {
		start.setAmountOfPlayers(2);
		start.setDifficulty(difficulty);
	}

	public void setDifficulty(String difficulty) {
		start.setDifficulty(difficulty);
		
	}


	public void setSingle(boolean b) {
		if(b){
			start.setAmountOfPlayers(1);
		}
		else{
			start.setAmountOfPlayers(2);
		}

	}

	public ArrayList<String> getRobots() {
		return robots;
	}

	public void robotsAdd(String name) {
		robots.add(name);
	}

	public boolean getSingle() {
		if(start.getAmountofPlayers() == 1) return true;
		else return false;
	}

	public boolean allNames() {
		return (start.getAmountofPlayers() == robots.size());
	}
}
