package MVC;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import GUI.ResumeFrame;
import GUI.StartFrame;
import Gameplay.Game;
import Gameplay.GameStart;

public class Controller {
	private Model model;
	private View view;
	
	
	
	
	private int step = 0;
	
	
	
	public Controller() {
		model = new Model();
		updateView();
	}
	
	private void initiateView(){
		view.setController(this);
	}

	void loadBoard() {
		
	}
	
	
	
	
	public void updateView() {
		if(step == 0) {
			view = new WelcomeView();
		}
		else if(step == 1){
			if(model.resumeGame()){
				view = new SavedGameView();
			}
			else {
				view = new NewGameView();
			}
		}
		initiateView();
		step++;

		
	}

	public void setSingle(boolean b) {
		model.setSingle(b);
	}

	public int addName(String name) {
		if(model.getRobots().contains(name)) {
			return 1;
		}
		else if(name == null || name.trim().length() == 0) {
			return 2;

		}
		else {
			model.robotsAdd(name);
			return 0;
		}

	}

	public String getLastName() {
		if(!model.getRobots().isEmpty()){
			return model.getRobots().get(model.getRobots().size() - 1);
		}
		return null;
	}

	public boolean getSingle() {
		return model.getSingle();
	}

	public boolean allNames() {
		return model.allNames();
	}

	public void setDifficulty(String level) {
		model.setDifficulty(level);
	}

	public void setGameResume(boolean b) {
		model.setResumeGame(b);
	}
}
