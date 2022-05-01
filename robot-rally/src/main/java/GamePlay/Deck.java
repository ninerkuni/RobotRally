package GamePlay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import java.util.List;


public class Deck {
	private int numCards;
	private List<Card> cards;
	
	public Deck() {
		numCards = 0;
		cards = new ArrayList<Card>();
		
	}
	
	public void add(Card card) {
		if(!this.contains(card)) {
			cards.add(card);
			numCards ++;
		}
	}
	
	public boolean contains(Card c) {
		return cards.contains(c);
	}
	
	public int getNumCards() {
		return numCards;
	}
//	public void setNumCards(int numCards) {
//		this.numCards = numCards;
//	}
	
	public Card draw() {
		int rand = (int) (numCards * Math.random());
		return cards.get(rand);
	}
	
	public void remove(Card card) {
		cards.remove(card);
		numCards --;
	}
}
