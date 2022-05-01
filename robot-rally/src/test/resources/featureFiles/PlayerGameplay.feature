@tag
Feature: Player and Hand

	@tag1
		Scenario: Empty hand
		Given a hand of cards with capacity 5
		When hand is emptied
		Then hand is empty
	
	@tag2
		Scenario: Draw card to hand
		Given a hand of cards with capacity 5
		And a deck
		And a card with a title and an action
		And card is added to deck
		And space on hand
		And number of free spaces
		When card is drawn
		Then card is on hand
		And number of free spaces decrease by one
	
	@tag3
		Scenario: Draw multiple cards to hands
		Given a hand of cards with capacity 2
		And a deck
		And a card with a title and an action
		And card is added to deck
		And space on hand
		And number of free spaces
		When card is drawn
		And card is drawn
		Then card is on hand
		And number of free spaces decrease
	
	@tag4
		Scenario: Draw cards to empty hand until full
		Given a hand of cards with capacity 5
		And hand is emptied
		And a deck of cards
		When hand is filled
		Then hand is full
		And there are as many cards as there is space
	
	@tag5
		Scenario: Draw cards to hand until full
		Given a hand of cards with capacity 5
		And a card with a title and an action
		And card is added to hand
		And a deck of cards
		When hand is filled
		Then hand is full
		And there are as many cards as there is space
		
	@tag6
		Scenario: change position
		Given a hand of cards with capacity 2
		And a card with a title and an action
		And card is added to hand
		And card is at position two
		And initial position of the card
		And position one is empty
		When card is placed in position one
		Then position changed
		And card is at position one
		And position two is empty
		
	@tag7
		Scenario: order cards randomly
    Given a robot on a board
    And the board is set up
		And a hand of cards with capacity 5
		And a deck of cards
		And a player with the robot
		And hand is connected to player
		And player fills hand
		And cards are not ordered
		When cards are ordered randomly
		Then cards are ordered
		And order can be printed
		
	@tag8
		Scenario: player plays cards
    Given a robot on a board
    And the board is set up
		And a hand of cards with capacity 5
		And a deck of cards
		And a player with the robot
		And hand is connected to player
		And player fills hand
		And cards are not ordered
		And coordinates of the robot
		When cards are ordered randomly
		And player plays hand
		Then final coordinates of the robot
		And robot moved
		And players hand is empty
	
	
	#@tag9
	#	Scenario: change position of card from user input
	#	Given a hand of cards with capacity 5
	#	And a deck of cards
	#	And a player
	#	And hand is connected to player
	#	And player fills hand
	#	And cards are not ordered
	#	And one card from the hand
	#	And initial position of the card
	#	And user input position 2
	#	When order cards
	#	Then position changed
	#	And card at position of user input 
		
	#@tag1
  #	Scenario: Drawing cards 
  #	Given a hand of cards
  #	And hand has capacity 5
	#	And hand is emptied
		#And order of cards is {3, 5, 1, 4, 2} 
	#	When play
	#	Then user should draw 5 cards
		
	#@tag2
	#Scenario: Ordering cards
	#	Given Hand is full
	#	And order of cards is {3, 5, 1, 4, 2}
	#	When ordering
	#	Then User should have ordered cards
		
	#@tag3
	#Scenario: Play 1 card
	#	Given Hand is full
	#	And order of cards is {3, 5, 1, 4, 2}
	#	When play
	#	Then Then user should use 1 card
	
	#@tag4	
	#Scenario: Play whole hand
	#	Given Hand is full
	#	And order of cards is {3, 5, 1, 4, 2}
	#	When play all cards
	#	Then Hand is empty	