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
		view = new WelcomeView();
		step++;
		initiateView();
		updateView();
	}
	
	private void initiateView(){
		view.setController(this);
	}

	void loadBoard() {
		
	}
	
	
	
	
	public void updateView() {
		System.out.println("view is updating...");
		//if the welcome view is still running, loop through the parameters
		if(view instanceof WelcomeView) {
			WelcomeView welcomeview = (WelcomeView)view;
			System.out.println("We are at step: welcome");
		while(!welcomeview.isDone()) {
			try{Thread.sleep(500);}catch(InterruptedException e){updateView();;}    
		}
		if(welcomeview.isDone()) {
			System.out.println("set-up is completed!");
			if(welcomeview.isNewGame()) {
					System.out.println("a new game should be started");
					String difficulty = welcomeview.getDifficulty();
					
					boolean single = welcomeview.isSingle();
					ArrayList<String> robots = welcomeview.getRobots();
					
				if(single) {
						String robotName = robots.get(0);
						model = new Model(robotName,difficulty);
					}
				else {
						String robotName1 = robots.get(0);
						String robotName2 = robots.get(1);
						model = new Model(robotName1,robotName2,difficulty);
					}
					
				view = new NewGameView();
					
				}
			
			else {
					System.out.println("an old game should be loaded");
					view = new SavedGameView();
				}
			}
		}
		
		
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
}
