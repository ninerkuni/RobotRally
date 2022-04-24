package Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.stream.Collectors;

import Elements.Robot;



public class Hand {
	private int capacity;
	private ArrayList<Card> cards;
	private int spaces;
	private Card[] order;
	
	public Hand(int capacity) {
		this.capacity = capacity;
		cards = new ArrayList<Card>(capacity);
		cards.ensureCapacity(capacity);
		order = new Card[capacity];
		spaces = capacity;
		
	}

//	public int getCapacity() {
//		return capacity;
//	}
//
//	public void setCapacity(int capacity) {
//		//maybe create ensure instanceof or something
//		if(this.capacity < capacity) ((ArrayList<Card>) cards).ensureCapacity(capacity);
//		else if (this.capacity > capacity) cards = cards.stream().limit(capacity).toList();
//		
//		this.capacity = capacity;
//		
//		
//	}

	public void empty() {
		cards.clear();
	}

	public boolean isEmpty() {
		return (cards.isEmpty());
	}

//	public void makeSpace() {
//		if(cards.size() == capacity) {
//			((ArrayList<Card>) cards).ensureCapacity(capacity+1);
//			spaces ++;
//			makeSpace();
//		}
		
//	}

	public int getSpaces() {
		return capacity - cards.size();
	}

	public void setSpaces(int spaces) {
		this.spaces = spaces;
	}

	public void draw(Deck deck) {
		cards.add(deck.draw());
	}

	public boolean contains(Card card) {
		return cards.contains(card);
	}

	public String print() {
		String str = "";
		for (Card c : cards) {
			str += "Title: "+c.getTitle() +" Action: "+ c.printActions()+"\n";
		}
		return str;
	}

	public void fill(Deck deck) {
		if (getSpaces() > 0) {
//			System.out.println("fill deck");
			draw(deck);
			fill(deck);
		}

		
	}

	public boolean full() {
		return (getSpaces() == 0);
	}

	public boolean space() {
		return (cards.size() <= capacity);
	}


	public int numCards() {
		return cards.size();
	}

	public void add(Card card) {
		//check that capacity won't be exceeded
		if (cards.size() < capacity -1 ) cards.add(card);
		else place(card, capacity-1);
	}

	public void setPosition(Card card, int i) {
		order[i] = card;
		
	}

	public int getPosition(Card card) {
		for(int i = 0; i < capacity; i++) {
			if(order[i] == card) return i;
		}
		return capacity;
	}

	public void place(Card card, int i) {
		int old = getPosition(card);
		if(i >= capacity) return;
		if (order[i] == null) {
			order[i] = card;
			if(old < capacity) order[old] = null;
		}
		else {
			Card c = order[i];
			order[i] = card;
			//careful with this one, cards just get shoved down in the order if a new card is inserted at their place
			if(old < capacity) order[old] = c;
			else place(c,i+1);
		}
		
	}

	public Card getCardPosition(int i) {
		if(i >= capacity) return null;
		return order[i];
	}

	public void orderRandom() {
		Collections.shuffle(cards);
		order = cards.toArray(order);
//		System.out.println("Ordered cards:");
//		for(Card c : order) {
//			c.printActions();
//		}
	}

	public void ordered(boolean b) {
		if(!b) order = new Card[capacity];
	}

	public boolean isOrdered() {
		for(int i = 0; i < order.length; i++) {
			if(order[i] != null) {
				return true;
			}
		}
		return false;
	}

	public void play(Robot robot) {
		for(Card c : order) {
			c.play(robot);
		}
		empty();
		ordered(false);
	}

	public Card pickRandom() {
		int rand = (int) (capacity*Math.random());
		return cards.get(rand);
	}

	public Card getCard(int i) {
		if(i >= capacity) return null;
		return cards.get(i);
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean printOrder() {
		boolean ordered = true;
		for(Card c : order) {
			if(c != null) c.printActions();
			else ordered = false;
		}
		return ordered;
		
	}
	
	public String[] getTitles() {
		String[] titles = new String[capacity];
		int i = 0;
		for(Card c : cards) {
			titles[i] = c.getTitle();
		}
		return titles;
	}
	
//	public void order() {
//		int ordered = 0;
//		int 
//		while(ordered < cards.size()-1) {
//			Prompter.hand(capacity);
//		}
//	}
//	
	
	
	
	
}
