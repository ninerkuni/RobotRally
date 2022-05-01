@tag
  Feature: Gameplay as a Robot

	@tag1
   	 Scenario: Initiate Robot
      Given a board
     	And a name "name"
      When the game starts
      Then robot is initiated
 
	@tag2
    Scenario: moving across the board
      Given a board
      And a robot on a board
      And the board is set up 
      And initial orientation of the robot
      And coordinates of the robot
      When the move is valid
      And the robot moves
      Then final coordinates of the robot
      And robot moved
    
	@tag3
    Scenario: turn left
    	Given a board
    	And a robot on a board
    	And the board is set up
    	And initial orientation of the robot
    	When robot turns left
    	Then robot turned left
    	
	@tag4
    Scenario: turn right
    	Given a board
    	And a robot on a board
    	And the board is set up
    	And initial orientation of the robot
    	When robot turns right
    	Then robot turned right
   
  @tag5
   Scenario: move in the right direction
   	Given a board
   	And a robot on a board
   	And the board is set up
   	And initial orientation of the robot
   	And coordinates of the robot
   	When the move is valid
   	And the robot moves
   	Then final coordinates of the robot
   	And move is correct
   	
 
   
   @tag6
    Scenario: hit conveyer
    	Given a board
    	And a robot on a board
    	And the board is set up
    	And coordinates of the robot
    	And robot score
    	And a conveyer
    	When robot hits conveyer
    	Then final coordinates of the robot
    	And the score is decreased
    	And robot moved
    
    @tag7 
    Scenario: hit pit
    	Given a board
    	And a robot on a board
    	And the board is set up
    	And robot score
    	And a pit
    	When robot hits pit
    	Then the robot returns to start
    	And the score is zero
    
    @tag8
    Scenario: hit left turning gear
    	Given a board
    	And a robot on a board
    	And the board is set up
    	And robot score
    	And initial orientation of the robot
    	And a gear
    	And gear turns left
    	When robot hits gear
    	Then robot turned left
    	And the score is decreased
    
    @tag9
    Scenario: hit right turning gear
    	Given a board
    	And a robot on a board
    	And the board is set up
    	And robot score
    	And initial orientation of the robot
    	And a gear
    	And gear turns right
    	When robot hits gear
    	Then robot turned right
    	And the score is decreased
    
    @tag10
	   Scenario: hit another robot
	   		Given a board
	    	And a robot on a board
	    	And an opponent robot
	    	And the board is set up
	    	And coordinates of the robot
	    	And robot score
	    	When robot hits opponent
	    	Then final coordinates of the robot
	    	And the score is decreased
	    	And robot moved
    
    @tag11
    Scenario: hit a new checkpoint
    	Given a board
    	And a robot on a board
    	And robot score
    	And robots checkpoint counter 1
    	And checkpoint id is equal to counter plus one
    	And a checkpoint
    	And checkpoint has not been visited
    	When robot hits checkpoint
    	Then the score is incremented
    	And checkpoint counter is incremented
    	And checkpoint is visited
    	
    @tag12
    Scenario: hit checkpoint again for the first time
    	Given a board
    	And a robot on a board
    	And number of checkpoints on the board
    	And robot score
    	And number of checkpoints at least equal to checkpoint counter
    	And a checkpoint
    	And checkpoint has been visited
    	When robot hits checkpoint
    	Then the score is incremented
    	And checkpoint counter is incremented
    	
    @tag13
    Scenario: move from specific coordinates
    	Given a board 
    	And a robot on a board
    	And the board is set up
    	And robot at coordinates 3 and 4
    	When the move is valid
    	And the robot moves
    	Then final coordinates of the robot
    	And move is correct
    
    @tag14 
    Scenario Outline: stay inside the borders
    	Given a board
    	And a robot on a board
    	And the board is set up
    	And dimensions of the board
    	And robots orientation is <orientation>
    	And robot is in the <static> and <rowcolumn> <int>
    	When robot tries to move
    	Then move is not possible
    	And final coordinates of the robot
    	And robot didnt move
    
    Examples:
    |	dimensions	|	orientation	|	static			|	rowcolumn	|	int	|
    |	8						|	north				|	first row		|		x				|	4		|
 		|	10					|	south				|	last row		|		x				|	6		|
 		|	12					|	west				|	first column|		y				|	4		|
 		|	8						|	east				|	last column	|		y				|	3		|
    
 #   @tag14
 #  Scenario: stay inside borders upper row
 #   	Given a board
 #   	And a robot on a board
 #   	And the board is set up
 #   	And dimensions of the board
 #  	And robots orientation is north
 #   	And robot is in the first row and x 4
 #   	When the robot tries to move
 #   	Then move is not possible
 #   	And final coordinates of the robot
 #   	And robot didnt move
    
 #   @tag15
 #   Scenario: stay inside borders lower row
 #   	Given a board
 #   	And a robot on a board
 #   	And the board is set up
 #   	And dimensions of the board
 #   	And robots orientation is south
 #   	And robot is in the last row and x 4
 #   	When the robot tries to move
 #   	Then move is not possible
 #   	And final coordinates of the robot
 #   	And robot didnt move
    
 #   @tag16
 #   Scenario: stay inside borders first column
 #   	Given a board
 #   	And a robot on a board
 #   	And the board is set up
 #   	And dimensions of the board
 #   	And robots orientation is west
 #   	And robot is in the first column and y 4
 #   	When the robot tries to move
 #   	Then move is not possible
 #   	And final coordinates of the robot
 #   	And robot didnt move
    
 #   @tag17
 #   Scenario: stay inside borders last column
 #   	Given a board
 #   	And a robot on a board
 #   	And the board is set up
 #   	And dimensions of the board
 #   	And robots orientation is east
 #   	And robot is in the last column and y 4
 #   	When the robot tries to move
 #   	Then move is not possible
 #   	And final coordinates of the robot
 #   	And robot didnt move

	@tag18
	Scenario: robot at next coordinates
		Given a board
		And a robot on a board
		And the board is set up
		And next coordinates of the robot
		And the move is valid
		When the robot moves
		Then robot is at the next coordinates
    	
    