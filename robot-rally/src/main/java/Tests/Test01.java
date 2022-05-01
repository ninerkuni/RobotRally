package Tests;
//
//import GamePlay.Obstacle;
//import GamePlay.Gear;
//import GamePlay.Hand;
//import GamePlay.Pit;
//import GamePlay.Prompter;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import GamePlay.Card;
//import GamePlay.Deck;
//
//
//
//
//class ObstacleFactory{
//	private ArrayList<Obstacle> obstacles;
//	public ObstacleFactory() {
//		obstacles = new ArrayList<Obstacle>();
//	}
//	
//	public Obstacle pick() {
//		if(!(obstacles.isEmpty())) {
//			int rand = obstacles.size() * ((int) Math.random());
//			return obstacles.get(rand).construct();
//		}
//		else return null;
//	}
//	
//	public void add(Obstacle obstacle) {
//		obstacles.add(obstacle);
//	}
//	
//	public void print() {
//		for(Obstacle o : obstacles) {
//			System.out.println(o.marker());
//		}
//	}
//	
//}

//public class Test01 {
//	public static void main(String[] args) {
//		
//		Hand hand = new Hand(5);
//		Deck deck = new Deck();
//		Card move = new Card("move");
//		move.setAction(Arrays.asList(Card.action.move));
//		
//		deck.add(move);
//		
//		Card turnL = new Card("turnL");
//		turnL.setAction(Arrays.asList(Card.action.turnL));
//		
//		deck.add(turnL);
//		
//		Card turnR = new Card("turnR");
//		turnR.setAction(Arrays.asList(Card.action.turnR));
//		
//		deck.add(turnR);
//		
//		System.out.println("Number of cards in the deck: "+deck.getNumCards());
//		
//		System.out.println("Random numbers: ");
//		
//		int rand;
//		
//		for(int i = 0; i < 10; i++) {
//			rand = (int) (deck.getNumCards() * Math.random());
//			System.out.println(rand);
//		}
//		
//		hand.fill(deck);
//		
//		hand.print();
//		
//		Prompter.hand(hand, System.in);
//		
//		hand.printOrder();
		
//		hand.printOrder();
	
//		Obstacle obstacle = new Obstacle();
//		
//		Obstacle gear = new Gear();
//		
//		Obstacle pit = new Pit();
//		
//		
//		ObstacleFactory factory = new ObstacleFactory();
//		
//		factory.add(gear);
//		factory.print();
//		
//		Obstacle gear1 = factory.pick();
//		Obstacle gear2 = factory.pick();
//		
//		gear1.setCoordinates(1, 2);
//		gear2.setCoordinates(2, 3);
//		
//		System.out.println("gear 1:");
//		gear1.getCoordinates().print();
//		System.out.println("gear 2:");
//		gear2.getCoordinates().print();
		
		
//		
//		
//	}
//}
