@tag
Feature: Starting the Game
  
  @tag1
  Scenario: Select game mode
  	Given the game difficulty is set "EASY"
  	And multiplayer is false
  	When game start
  	Then a board is created
  	And there are at least 6 obstacles
  	And there are at least 3 checkpoints
  	And there are 1 robots 
  
#  @tag1
#  Scenario Outline: Select game mode
#  	Given the game difficulty is set <level>
#  	And amount of players is <players>
#  	When game start
#  	Then a board is created
#  	And there are at least <obstacles> obstacles
#  	And there are at least <checkpoints> checkpoints
#  	And there are <players> robots 
  
#  	Examples:
#	  	|	level		|	players	|	obstacles	|	checkpoints	|
#	  	|	"EASY"	|	1				|	6					|	3						|
#	  	|	"MEDIUM"|	1				|	12				|	1						|
#	  	|	"HARD"	|	1				|	18				|	1						|
#	  	|	"EASY"	|	2				|	6					|	3						|
#	  	|	"MEDIUM"|	2				|	12				|	1						|
#	  	|	"HARD"	|	2				|	18				|	1						|
#  @tag1
#  Scenario: Select game mode
#    Given the game difficulty is set "EASY"
#    And amount of players is 1
#    And dimensions is 8
#    When initialize dimensions for board
#    Then automaton returns dimensions for game board
    
#  @tag2
#  Scenario: Select game mode
#    Given the game difficulty is set "HARD"
#    And amount of players is 2
#    And dimensions is 8
#    When initialize dimensions for board
#    Then automaton returns dimensions for game board
    
#  @tag3
#  Scenario: Select game mode
#    Given the game difficulty is set "HARD"
#    And amount of players is 1
#    And dimensions is 8
#    When initialize dimensions for board
#    And initialize 1 robot
#    Then automaton create one robots
    
#	@tag4
#  Scenario: Select game mode
#    Given the game difficulty is set "HARD"
#    And amount of players is 2
#    And dimensions is 8
#    When initialize dimensions for board
#    And initialize 2 robot
#    Then automaton create two robots