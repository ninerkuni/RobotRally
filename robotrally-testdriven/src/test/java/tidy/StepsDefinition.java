package tidy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import Board.Board;
import Elements.Conveyer;
import Elements.Coordinates;
import Elements.Element;
import Elements.Gear;
import Elements.Pit;
import Elements.Robot;
import Elements.Trampoline;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {
	
	
	Board board;
	String name;
	Robot robot;
	
	
	@Given("a board")
	public void a_board() {
	    board = new Board();
	}
	@Given("a name {string}")
	public void a_name(String string) {
	    name = string;
	}
	@When("robot is initated")
	public void robot_is_initated() {
	    robot = new Robot(name,board);
	}
	
	@When("board is set up")
	public void board_is_set_up() {
	    board.setUp(robot);
	}
	
	@Then("robot is on board")
	public void robot_is_on_board() {
	    assertTrue(board.contains(robot));
	}
	
	Coordinates ini;
	Coordinates fin;
	
	@Given("a board with one robot")
	public void a_board_with_one_robot() {
	    board = new Board();
	    robot = new Robot("Robby",board);
	    board.setUp(robot);
	}
	
	
	@Given("initial coordinates")
	public void initial_coordinates() {
	    ini = new Coordinates(robot.getCoordinates().getx(),robot.getCoordinates().gety());
	}
	@When("robot performs a valid move")
	public void robot_performs_a_valid_move() {
	    robot.move(true);
	}

	@Then("robot changed position")
	public void robot_changed_position() {
	    assertNotEquals(ini.diff(robot.getCoordinates()),0);
	}
	
	int orientation;
	int diff;
	
	@Given("initial orientation")
	public void initial_orientation() {
	    orientation = robot.getOrientation();
	}
	@When("robot turns right")
	public void robot_turns_right() {
	    robot.turnR();
	}
	
	@When("robot turns left")
	public void robot_turns_left() {
	    robot.turnL();
	}
	
	@Then("robot turned by {int}")
	public void robot_turned_by(Integer int1) {
		diff = (4-(robot.getOrientation()-orientation))%4;
	    assertTrue(diff == int1);
	}
	
	@Given("the initial orientation is {int}")
	public void the_initial_orientation_is(Integer int1) {
	    orientation = int1;
	    robot.setOrientation(orientation);
	 
	}
	@Then("move is correct")
	public void move_is_correct() {
		int dx = ini.diffx(robot.getCoordinates());
	    int dy = ini.diffy(robot.getCoordinates());
	    
	    assertTrue((dy == ((orientation-2)%2))&&(dx == (-(orientation-3)%2)));
	}
	
	int score;
	Element e;
	
	@Given("robot score")
	public void robot_score() {
	    score = robot.getScore();
	}
	@Given("a conveyer")
	public void a_conveyer() {
	    e = new Conveyer();
	}
	@When("robot hits element")
	public void robot_hits_element() {
	    robot.hit(e);
	}
	@Then("score is decreased")
	public void score_is_decreased() {
	    assertTrue(robot.getScore()-score < 0);
	}
	
	
	@Given("a pit")
	public void a_pit() {
	    e = new Pit();
	}
	@Then("robot returns to start")
	public void robot_returns_to_start() {
	    assertEquals(robot.getCoordinates(),robot.getStart());
	}
	@Then("score is zero")
	public void score_is_zero() {
	    assertEquals(robot.getScore(),0);
	}
	

	@Given("a gear that turns right")
	public void a_gear_that_turns_right() {
		e = new Gear();
	    e.setLeft(false);
	}
	
	@Given("a gear that turns left")
	public void a_gear_that_turns_left() {
		e = new Gear();
		e.setLeft(true);
	}
	
	@Given("an opponent")
	public void an_opponent() {
	    e = new Robot(board);
	}
	@Then("robot moved in the opposite direction")
	public void robot_moved_in_the_opposite_direction() {

		int dx = -robot.getCoordinates().diffx(ini);
	    int dy = -robot.getCoordinates().diffy(ini);
	    
	    int sx = (int) (Math.signum(-(orientation-3)%2));
	    int sy = (int) (Math.signum((orientation-2)%2));
	    
	    assertTrue(((int)Math.signum(dy) == sy)&&((int)Math.signum(dx) == sx));
	    
	}
	
	@Given("a trampoline")
	public void a_trampoline() {
	    e = new Trampoline();
	}
	
	@Then("robot is at least {int} fields away")
	public void robot_is_at_least_fields_away(Integer int1) {
	    assertTrue(robot.getCoordinates().diff(ini) >= 3);
	}
	
	int d;
	
	
	@Given("board has dimensions {int}")
	public void board_has_dimensions(Integer int1) {
	    d = int1;
	    board.setDimensions(d);
	    
	}
	@Given("robot at coordinates {int} {int}")
	public void robot_at_coordinates(Integer int1, Integer int2) {
		ini = new Coordinates(int1,int2);
	    robot.setCoordinates(ini);
	}
	@When("robot tries to move")
	public void robot_tries_to_move() {
	    robot.moved();
	}
	@Then("robot didnt move")
	public void robot_didnt_move() {
	    assertEquals(ini,robot.getCoordinates());
	}
	
	Coordinates coordinates;
	
	@Given("random coordinates")
	public void random_coordinates() {
	    coordinates = new Coordinates();
	    coordinates.setRandom(board.getDimensions());
	    System.out.print("random coordinates ");
	    coordinates.print();
	}
	@When("robot is moved to coordinates")
	public void robot_is_moved_to_coordinates() {
	    robot.move(coordinates);
	    System.out.print("robots coordinates ");
	    robot.getCoordinates().print();
	}
	@Then("robot is at new coordinates")
	public void robot_is_at_new_coordinates() {
	    assertEquals(coordinates,robot.getCoordinates());
	}
	
}
