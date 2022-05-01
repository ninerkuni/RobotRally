
@tag
Feature: Game initiation

  @tag1
  Scenario: Robot wins
    Given a board with one robot
    And a final checkpoint
    And all other checkpoints have been visited
    When robot hits checkpoint
    Then the game is finished 
    And the robot won

