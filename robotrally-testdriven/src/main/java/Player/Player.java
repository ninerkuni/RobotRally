package Player;

import java.util.Scanner;

import Elements.Robot;

public class Player{
	
//	private String[] hand = new String[5];
//	private static Card cards = new Card("card ");
	private Hand hand;
	private Robot robot;
	
	
	public Player() {
		
	}
	
	public Player(Robot robot) {
		this.robot = robot;
//		hand = new Hand(5);
	}
	
	
	public void play() {
		if(!hand.isOrdered()) {
			hand.orderRandom();
		}
		hand.play(robot);
	}
	
//	public void order() {
//		int ordered = 0;
//		while(ordered < cards)
//	}
	
//	private static String[] drawCards() {
////		cards.showRandomCards();
////		return cards.CardsOnHand;
//		String[] c = {"insert","cards","here"};
//		return c;
//	}


//	private void orderCards(String[] rndhand) {
//		String[] order = new String[5];
//		Scanner obj = new Scanner(System.in);
//		for(int i = 0; i<5; i++) {
//			order[i] = rndhand[(obj.nextInt())-1];
//		}
//		for(int i = 0; i<5; i++) {
//			hand[i] = order[i];
//		}
//		obj.close();
//	}

	
	
//	private void play1Card(String card) {
//		if (card == "MoveForward") {
//			robot.move(true);
//		} else if (card == "Turn Clockwise") {
//			robot.turnR();
//		} else if (card == "Turn Counter Clockwise") {
//			robot.turnL();
//		} else {
//			//does something, we can implement an easter egg here
//		}
//	}


	public void setHand(Hand hand) {
		this.hand = hand;
		
	}


	public void orderRandom() {
		hand.orderRandom();
		
	}


	public boolean emptyHand() {
		return hand.isEmpty();
	}


	public void fillHand(Deck deck) {
		hand.fill(deck);
		
	}


	public void setOrdered(boolean b) {
		hand.ordered(b);
		
	}


	public boolean areOrdered() {
		return hand.isOrdered();
	}

//	public void order() {
//		Card temp;
//		for(int i = 0; i < hand.numCards();i++) {
////			System.out.println("Card number "+i);
//			temp = hand.getCard(i);
////			temp.printActions();
//			int position = Prompter.hand(hand,System.in);
//			hand.setPosition(temp, position);
//		}
//		
//	}

	public void printHand() {
		System.out.println(hand.print());
		
	}
}