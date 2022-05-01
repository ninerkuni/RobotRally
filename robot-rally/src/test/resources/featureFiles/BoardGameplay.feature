@tag
Feature: Board

	@tag1
		Scenario: element on board
		Given a board
    And a robot on a board
    And the board is set up 
		And a checkpoint
		And coordinates 3 and 4
		And element at coordinates
		And element on board
		When coordinates are checked
		Then spot is not empty
		
	@tag2
		Scenario: element at random spot on board
		Given a board
    And a robot on a board
    And the board is set up 
		And a checkpoint
		And element on random spot on board
		When check if element is on board
		Then element is on board
		
	@tag3
		Scenario: robot on the board
		Given a board
		And a robot on a board
		When the board is set up
		Then robot is on board
		And start of the robot
		And spot is not empty
	
	@tag4
		Scenario: initializing with n checkpoints
		Given a board
		And 3 checkpoints
		And a robot on a board
		When board is set up with checkpoints
		Then board contains n checkpoints
		And there is one more element than checkpoints

	
	@tag6 
		Scenario: Robot hits Checkpoint on the board
		Given a board
   	And a robot on a board
    And the board is set up
    And robots checkpoint counter 1
    And checkpoint id is equal to counter plus one 
		And a checkpoint
		And robot score
		And next coordinates of the robot
		And element at coordinates
		And element on board
		And the move is valid
		And checkpoint has not been visited
    When the robot moves
    And coordinates are checked
		Then robot is at the next coordinates
		And spot is not empty
		And there is an element at the spot
		And checkpoint counter is incremented
    And checkpoint is visited
    And the score is incremented

 
	@tag7
		Scenario: Robot hits pit on the board
	 	Given a board
	  And a robot on a board
	  And the board is set up
	  And robot score
	  And a pit
	  And next coordinates of the robot
		And element at coordinates
		And element on board
		And the move is valid
	  When the robot moves
	  Then the robot returns to start
	  And the score is zero
 
 


 
# @tag8
# 	Scenario: inititalizing with checkpoints and obstacles
# 	Given a board
# 	And a robot on a board
# 	And <numCheckpoints> checkpoints and <numObstacles> obstacles
 	