package MVC;

import Board.ObstacleFactory;
import Elements.Element;
import Elements.Gear;
import Elements.Obstacle;
import Elements.Pit;
import Player.Card;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class BoardView extends View {
	private int dimensions;

	private String[][] board;

	
	JPanel boardDisplay;


	ArrayList<Element> elements = new ArrayList<>();

	public BoardView() {
		super();
		panel.setLayout(new GridLayout(8,8,20,20));
		board();
//		panel.removeAll();
//		rally.remove(panel);
//		rally.repaint();
//		initiateElements(5);
//		dimensions = 8;
//		rally.setLayout(new GridLayout(dimensions,dimensions,20,20));
//		boardDisplay = new JPanel(new GridLayout(dimensions,dimensions));
//		board = new String[dimensions][dimensions];
//		loadBoard();
//		showBoard();
	}

	private void board(){
		rally.remove(panel);
		panel.removeAll();
		rally.repaint();

		dimensions = 10;
		board = new String[dimensions][dimensions];

		initiateElements(6);
		loadBoard();

		fill();


	}

	private void fill(){
		JLabel tile;
		for(int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				tile = new JLabel(board[i][j]);
				panel.add(tile);
			}
		}
		rally.add(panel);
		rally.pack();

	}

	private void initiateElements(int size) {
		System.out.println("elements instatiated");
		Obstacle o = new Pit();
		o.setCoordinates(3,4);
		elements.add(o);

		o = new Gear();
		o.setCoordinates(5,6);
		elements.add(o);

		//ObstacleFactory factory = new ObstacleFactory();
		//factory.defaultFill();
		//System.out.println("There are"+size+"elements");
		//for(int i = 0; i < size; i++) {
		//	Obstacle o = factory.pick();
		//	System.out.println(o.message());
		//	elements.add(o);
		//}

	}

	public ArrayList<Element> getElements() {
		return elements;
	}

	public void loadBoard(){
		System.out.println("load board");
		for(int i = 0; i < elements.size(); i++){
			Element e = elements.get(i);
			int x = e.getCoordinates().getx();
			int y = e.getCoordinates().gety();

			board[x][y] = e.message();
		}
	}

	public void showBoard() {
		System.out.println("board is shown");
		rally.repaint();
		JButton tile;
		tile = new JButton("Button");
//		rally.add(tile,3,4);
		panel.add(tile,3,4);
		rally.add(panel);
//		for(int i = 0; i < dimensions; i++) {
//			for (int j = 0; j < dimensions; j++) {
//				if(board[i][j] == null){tile = new JButton("empty"); System.out.println("empty at "+i+" "+j);}
//				else {tile = new JButton(board[i][j]);System.out.println("element at "+i+" "+j);}
//				rally.add(tile);
//			}
//		}
		//rally.add(boardDisplay);
		rally.pack();

	}






	}


