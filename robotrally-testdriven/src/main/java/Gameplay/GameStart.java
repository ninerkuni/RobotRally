package Gameplay;

import java.util.ArrayList;
import java.util.Scanner;

import Board.Board;
import Board.ObstacleFactory;
import Elements.Robot;



public class GameStart {
    private int obstacles;
    private int checkpoints;
    private int rows;
    private int cols;
    private Board board;
    private ObstacleFactory factory;
//    private ArrayList<Robot> robots = new ArrayList<Robot>();
    
    
    
    
    int amountOfPlayers;
    
    public void setDifficulty(String difficulty) {
    	switch(difficulty) {
    		case ("EASY"):
    			obstacles = (int) (6 + 6 * Math.random());
    		    checkpoints = (int) (3 + 2 * Math.random());
    		    break;
    		case ("MEDIUM"):
    			obstacles = (int) (12 + 6 * Math.random());
    		    checkpoints = (int) (1 + 2 * Math.random());
    		    break;
    		case ("HARD"):
    			obstacles = (int) (18 + 6 * Math.random());
    		    checkpoints = 1;
    		    break;
    	}
    }
    

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    
    }
    
    public void setDimensions(int d) {
    	this.rows = d;
    	this.cols = d;
    }

    public int getRows() {
        return this.rows;
    }
    public int getCols(){
        return this.cols;
    }

    public int getObstacles(){
        return this.obstacles;
    }

    public int getCheckpoints(){
        return this.checkpoints;
    }


	public void start() {
		if(amountOfPlayers == 1) {
			board = new Board(cols);
			Robot robot = new Robot(board);
			board.setUp(robot, obstacles, checkpoints, factory);
		}
		else if (amountOfPlayers == 2) {
			board = new Board(cols);
			Robot robot1 = new Robot(board);
			Robot robot2 = new Robot(board);
			board.setUp(robot1, robot2, obstacles, checkpoints, factory);
		}
		
	}


	public Board getBoard() {
		// TODO Auto-generated method stub
		return board;
	}

    public int getAmountofPlayers() {
		return amountOfPlayers;
    }
}