
@tag
Feature: Robot Scenarios

  @tag1
  Scenario: Initiate Robot
    Given a board
    And a name "Robby"
    When robot is initated
    And board is set up
    Then robot is on board

	@tag2
  Scenario: Move across the board
    Given a board with one robot
    And initial coordinates
    When robot performs a valid move
    Then robot changed position
	
  @tag3
  Scenario Outline: turning
    Given a board with one robot
    And initial orientation
    When robot turns <direction>
    Then robot turned by <diff>

    Examples: 
      | direction  	|	diff 	|
      | right 	  	| 3			|
      | left 				|	1			|
     
   @tag4
   Scenario Outline: Move across the board
    Given a board with one robot
    And initial coordinates
    And the initial orientation is <orientation>
    When robot performs a valid move
    Then robot changed position
    And move is correct
   
    Examples: 
      | orientation |	
      | 1			 	  	|
      | 2		 				|
      |	3						|
      |	4						|
   
	  @tag5
	  Scenario: hit conveyer
	    Given a board with one robot
	    And initial coordinates
	    And robot score
	    And a conveyer
	    When robot hits element
	    Then robot changed position
	    And score is decreased
	    
	  @tag6
	  Scenario: hit pit
	    Given a board with one robot
	    And robot score
	    And a pit
	    When robot hits element
	    Then robot returns to start
	    And score is zero

	   @tag7
	   Scenario Outline: hit gear
	    Given a board with one robot
	    And the initial orientation is <orientation>
	    And initial coordinates
	    And a gear that turns <direction>
	    When robot hits element
	    Then robot turned by <diff>
	    And move is correct
	   
	    Examples: 
	      | orientation |	direction  	|	diff 	|
	      |	1						| right 	  	| 3			|
	      |	1						| left 				|	1			|
	      |	2						| right 	  	| 3			|
	      |	2						| left 				|	1			|
	      |	3						| right 	  	| 3			|
	      |	3						| left 				|	1			|
	      |	4						| right 	  	| 3			|
	      |	4						| left 				|	1			|
	  
	  @tag8
	  Scenario Outline: hit another robot
	    Given a board with one robot
	    And initial coordinates
	    And robot score
	    And the initial orientation is <orientation>
	    And an opponent
	    When robot hits element
	    Then robot changed position
	    And robot moved in the opposite direction
	    And score is decreased
	    
	    Examples: 
	      | orientation |	
	      | 1			 	  	|
	      | 2		 				|
	      |	3						|
	      |	4						|

		@tag9
		Scenario: Trampoline
			Given a board with one robot
			And a trampoline
			And initial coordinates
			When robot hits element
			Then robot changed position
			And robot is at least 3 fields away
			
		
		@tag10 
		Scenario Outline: stay inside borders
			Given a board with one robot 
			And board has dimensions <d>
			And the initial orientation is <orientation>
			And robot at coordinates <x> <y>
			When robot tries to move
			Then robot didnt move
			
			Examples: 
				| orientation |	d	|	x	|	y	|
	      | 1			 	  	|	8	|	3	|	0	|
	      | 2		 				|	8	|	7	|	3	|
	      |	3						|	8	|	3	|	7	|
	      |	4						|	8	|	0	|	3	|

		@tag11
		Scenario: robot is being moved to random coordinates
			Given a board with one robot
			And initial coordinates
			And random coordinates 
			When robot is moved to coordinates
			Then robot is at new coordinates

			
			#