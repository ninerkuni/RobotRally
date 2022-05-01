@tag 
	Feature: Card and Deck in the game
	
	@tag1
		Scenario: Add card to deck
		Given a deck
		And number of cards in deck
		And a card with a title "title"
		When card is added to deck
		Then deck size incremented 
		And card is in deck
	
	@tag2
		Scenario: Draw card from deck
		Given a deck
		And three cards "title1" "title2" "title3" in deck
		When card is drawn from deck
		Then card is in deck

		
	@tag3
		Scenario: Add card to deck that already exists
		Given a deck
		And a card with a title "title"
		And card is added to deck
		And number of cards in deck
		And card is in deck
		When card is added to deck
		Then card is in deck
		And deck size is not incremented
	
	@tag4
		Scenario: Remove card from deck
		Given a deck
		And a card with a title "title"
		And card is added to deck
		And number of cards in deck
		When title is removed
		Then card is not in deck
		And deck size is decreased
	
	@tag5
		Scenario: Add action to card
		Given a card with a title "title" 
		And an sequence of actions
		When add action
		Then action is added
		
	@tag6
		Scenario: card moves robot by one
    Given a robot on a board
    And a card with a title "title"
    And the action move
 		And action is added to card
 		And add action
    And the board is set up
   	And coordinates of the robot
    When card is played
  	Then final coordinates of the robot
    And robot moved
    And move is correct
		
	@tag7
		Scenario: card turns robot left once
    Given a robot on a board
    And a card with a title "title"
    And the action turn left
 		And action is added to card
 		And add action
    And the board is set up
 		And initial orientation of the robot
    When card is played
		Then action is added
		Then robot turned left
	
	@tag8
		Scenario: card turns robot right once
    Given a robot on a board
    And a card with a title "title"
    And the action turn right
 		And action is added to card
 		And add action
    And the board is set up
 		And initial orientation of the robot
    When card is played
		Then action is added
		Then robot turned right
		
		