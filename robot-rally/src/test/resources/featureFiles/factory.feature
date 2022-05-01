#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Factory

  @tag1
  Scenario Outline: Factory with obstacles
    Given a <obstacle>
    And a factory
    When obstacle is added to factory
    Then obstacle is in factory

    Examples: 
      | obstacle   | 
      | pit				 | 
      | gear			 |  
      | conveyer	 |
      
  @tag2
  Scenario Outline: build board with obstacles
    Given a factory with obstacles
    And a board with <robots>
    And <numObstacles> obstacles
    And <numCheckpoints> checkpoints
    When board set up with elements
    Then there are <numObstacles> obstacles on board

    Examples: 
      | robots	   |	numObstacles	|	numCheckpoints	|
      | one robot	 | 		4						|		2							|
      | two robots |  	3						|		2							|


      