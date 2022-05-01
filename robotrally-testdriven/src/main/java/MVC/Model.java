package MVC;

import Elements.Element;
import Elements.Robot;
import Gameplay.Game;
import Gameplay.GameStart;
import LoadSave.LoadGame;
import LoadSave.SaveGame;

import java.util.ArrayList;

public class Model {

	private ArrayList<String> robots;
	private Game game;
	private GameStart start;

	private boolean resume;
	
	//constructor for new game
	public Model() {
		robots = new ArrayList<String>();
		start = new GameStart();
		System.out.println("Model initiated");
	}
	
//	public Model(String robotName, String difficulty) {
//		start.setAmountOfPlayers(1);
//		start.setDifficulty(difficulty);
//
//	}
//
//	public Model(String robotName1, String robotName2, String difficulty) {
//		start.setAmountOfPlayers(2);
//		start.setDifficulty(difficulty);
//	}



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

	public ArrayList<String> getRobotNames() {
		return start.getRobotNames();
	}

	public void robotsAdd(String name) {
		start.addName(name);
	}

	public boolean getSingle() {
		if(start.getAmountofPlayers() == 1) return true;
		else return false;
	}

	public boolean allNames() {
		return (start.getAmountofPlayers() == start.getRobotNames().size());
	}

	public boolean resumeGame() {
		return resume;
	}

	public int setResumeGame(boolean b) {
		resume = b;
		if(b) {
			return loadGame();
		}
		return 2;
	}



	public ArrayList<Element> getElements() {
//		System.out.println("model.getElements()");
		return game.getElements();
	}

	public int getDimensions() {
		return game.getBoardDimensions();
	}

	public int loadGame(){
		LoadGame saved = new LoadGame();
		int error = saved.tryLoad();
		if(error == 0){
			game = saved.load();
			return 0;
		}
		else{
			return 1;
		}
	}

	public void newGame() {
		game = start.start();
	}

//	public void moveRobot() {
//		System.out.println("model.moveRobot()");
//		game.moveRobot();
//	}

//	public void leftRobot(boolean b) {
//		System.out.println("model.leftRobot()");
//		game.leftRobot(b);
//	}

	public String[] getCardTitles() {
		return game.getCards();
	}

	public void drawCards() {
		game.drawCards();
	}

	public int setCardToPosition(String title, int position) {
		return game.setCardToPosition(title,position);
	}

	public boolean isOrdered() {
		return game.isOrdered();
	}

	public String playCard() {
		return game.playCard();
	}

	public boolean nextRound() {
		if(game.isFinished()) return false;
		else{
			game.nextRound();
			return true;
		}
	}

	public int getScore() {
		return game.getActiveScore();
	}

	public int getCheckpoints() {
		return game.getActiveCheckpoints();
	}

	public int saveGame() {
		SaveGame saveGame = new SaveGame(game);
		return saveGame.save();
	}

	public int getNumCheckpoints() {
		return game.getBoard().getCheck();
	}

	public ArrayList<Robot> getRobots() {
		return game.getRobots();
	}

	public String getActiveName() {
		return game.activePlayer().getRobot().getName();
	}

	public String getWinner() {
		return game.getWinner();
	}

	public int getRound() {
		return game.getRound();
	}
}
