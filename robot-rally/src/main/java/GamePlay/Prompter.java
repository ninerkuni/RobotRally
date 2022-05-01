//package GamePlay;
//import java.io.InputStream;
//import java.util.Scanner;
//
//public class Prompter {
//	static Scanner s;
//	public static int hand(Hand hand, InputStream in) {
//		s  = new Scanner(in);
//		int input = 0;
//		boolean correct = false;
//		int counter = hand.getCapacity();
//		System.out.println("Scanner initiated");
//		
//		while(counter > 0) {
//			Card card = hand.getCard(counter-1);
//			card.printActions();
//			System.out.println("Enter Position: ");
//			if(s.hasNextInt()) {
//				System.out.println("has next int");
//				input = s.nextInt();
//				System.out.println("input: "+input);
//				if(input >= 0 && input < hand.getCapacity()) {
//					hand.setPosition(card, input);
//					counter --;
//					System.out.println("valid input");
//				}
//				else System.out.println("Not valid, try again");
//			
//			}
//			else System.out.println("does not have next int");
//		}
////		input = s.nextInt();
////		while(s.hasNextInt()) {
//////			if(s.hasNextInt()) {
////			input = s.nextInt();
////			System.out.println("has next int");
////			if(input >= 0 && input < capacity) {
//////					correct = true;
//////				s.close();
////				System.out.println("correct input: "+input);
////				return input;
//////			}
////			}
////		}
//		System.out.println("input: "+input);
//		return input;
//		
//	}
//	public boolean validHand(Hand hand, int inputInt) {
//		int capacity = hand.getCapacity();
//		return (inputInt >= 0 && inputInt < capacity);
//	}
//
//}
