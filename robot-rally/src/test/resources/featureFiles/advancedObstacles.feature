
@tag
	Feature: Advanced Obstacles
	
	@tag1
	Scenario: Trampoline
		Given a board with one robot
		And a trampoline
		And coordinates of the robot
		When robot hits obstacle
		Then final coordinates of the robot
		And robot moved
		And robot is at least 3 fields away
