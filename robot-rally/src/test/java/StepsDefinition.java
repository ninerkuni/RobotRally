import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import GamePlay.Board;
import GamePlay.Card;
import GamePlay.Checkpoint;
import GamePlay.Conveyor;
import GamePlay.Coordinates;
import GamePlay.Deck;
import GamePlay.Element;
import GamePlay.Game;
import GamePlay.GameStart;
import GamePlay.Gear;
import GamePlay.Hand;
import GamePlay.Obstacle;
import GamePlay.ObstacleFactory;
import GamePlay.Pit;
import GamePlay.Player;
import GamePlay.Robot;
import GamePlay.Trampoline;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepsDefinition {
	Board b;
	String name;
	Robot robot;
	@Given("a board")
	public void a_board() {
	    b = new Board();
	}
	@Given("a name {string}")
	public void a_name(String string) {
	    name = string;
	}
	@When("the game starts")
	public void the_game_starts() {
	    GameStart game;
	}
	@Then("robot is initiated")
	public void robot_is_initiated() {
	    robot = new Robot(name, b);
	}

	
	int obstacles;
	int checkpoints;
	boolean valid;
	int iOrientation;
	int fOrientation;
	int diff;
	
	Coordinates initial;
	Coordinates fin;
	
	//move across board

	@Given("a robot on a board")
	public void a_robot_on_a_board() {
		b = new Board();
		robot = new Robot(b);
	}
	@Given("the board is set up")
	public void the_board_is_set_up() {
	    b.setUp(robot);
	}
	
	@Given("coordinates of the robot")
	public void coordinates_of_the_robot() {
	    initial = new Coordinates (robot.getCoordinates().getx(),robot.getCoordinates().gety());
	}
	

	@When("the move is valid")
	public void the_move_is_valid() {
	    valid = true;
	}
	
	@When("the robot moves")
	public void the_robot_moves() {
		assertTrue(robot.move(valid));
	}
	@Then("final coordinates of the robot")
	public void final_coordinates_of_the_robot() {
		fin = new Coordinates (robot.getCoordinates().getx(),robot.getCoordinates().gety());
	}

	
	@Then("robot moved")
	public void robot_moved() {
//		initial.print();
//		fin.print();
		assertFalse(initial.equals(fin));
	}

	
	
	//turning left
	
	@Given("initial orientation of the robot")
	public void initial_orientation_of_the_robot() {
	    iOrientation = robot.getOrientation();
	}
	@When("robot turns left")
	public void robot_turns_left() {
		assertEquals(robot.turnL(),"turned left!");
	}
	@Then("robot turned left")
	public void robot_turned_left() {
	    fOrientation = robot.getOrientation();
	    diff = (4-(fOrientation-iOrientation))%4;
	    assertEquals(diff,1);
	}
	
	//turning right
	@When("robot turns right")
	public void robot_turns_right() {
		assertEquals(robot.turnR(),"turned right!");
	}
	@Then("robot turned right")
	public void robot_turned_right() {
		fOrientation = robot.getOrientation();
		diff = (4-(fOrientation-iOrientation))%4;
	    assertEquals(diff,3);
	}
	
	//correct move
	
	
	@Then("move is correct")
	public void move_is_correct() {
	    int dx = initial.diffx(fin);
	    int dy = initial.diffy(fin);
	    
	    assertTrue((dx == ((iOrientation-2)%2))&&(dy == ((iOrientation-1)%2)));
	}

	
	// hit conveyer
	Element e;
	int score;
	@Given("a conveyer")
	public void a_conveyer() {
	    e = new Conveyor();
	}
	@Given("robot score")
	public void robot_score() {
	    score = robot.getScore();
	}
	@When("robot hits conveyer")
	public void robot_hits_conveyer() {
	    assertEquals(robot.hit(e),"Conveyer");
	}

	@Then("the score is decreased")
	public void the_score_is_decreased() {
	    assertTrue((robot.getScore() - score) < 0);
	}
	
	//hit pit
	
	@Given("a pit")
	public void a_pit() {
	    e = new Pit();
	}
	@When("robot hits pit")
	public void robot_hits_pit() {
	    robot.hit(e);
	}
	@Then("the robot returns to start")
	public void the_robot_returns_to_start() {
		Coordinates start = robot.getStart();
	    assertTrue(robot.getCoordinates().equals(start));
	}
	@Then("the score is zero")
	public void the_score_is_zero() {
	    assertEquals(robot.getScore(),0);
	}

	//hit gear
	@Given("a gear")
	public void a_gear() {
		e = new Gear();
	}
	@Given("gear turns left")
	public void gear_turns_left() {
		e.setLeft(true);
	}
	@When("robot hits gear")
	public void robot_hits_gear() {
		robot.hit(e);
	}
	@Given("gear turns right")
	public void gear_turns_right() {
	    e.setLeft(false);
	}
	
	//hit another robot
	@Given("an opponent robot")
	public void an_opponent_robot() {
	    e = new Robot(b);
	    
	}
	@When("robot hits opponent")
	public void robot_hits_opponent() {		
	    robot.hit(e);
	    
	}
	
	//hit checkpoint
	int checkCount;
	int checkID;
	int cpBoard;
	
	@Given("robots checkpoint counter {int}")
	public void robots_checkpoint_counter(Integer int1) {
		checkCount = int1;
	    robot.setCheckCount(checkCount);
	}
	
	@Given("checkpoint id is equal to counter plus one")
	public void checkpoint_id_is_equal_to_counter_plus_one() {
		checkID = checkCount+1;
	}
	@Given("a checkpoint")
	public void a_checkpoint() {
	    e = new Checkpoint(checkID);
	}
	@Given("checkpoint has not been visited")
	public void checkpoint_has_not_been_visited() {
	    e.setVisited(false);
	}

	
	@When("robot hits checkpoint")
	public void robot_hits_checkpoint() {
	    robot.hit(e);
	}
	
	@Then("the score is incremented")
	public void the_score_is_incremented() {
	    assertTrue((robot.getScore() - score) > 0);
	}
	@Then("checkpoint counter is incremented")
	public void checkpoint_counter_is_incremented() {
	    assertEquals(robot.getCheckCount() - checkCount,1);
	}
	@Then("checkpoint is visited")
	public void checkpoint_is_visited() {
	    assertTrue(e.getVisited());
	}
	
	@Given("number of checkpoints on the board")
	public void number_of_checkpoints_on_the_board() {
	    cpBoard = b.getCheck();
	}
	@Given("number of checkpoints at least equal to checkpoint counter")
	public void number_of_checkpoints_at_least_equal_to_checkpoint_counter() {
	    checkID = cpBoard;
	    checkCount = cpBoard;
	    robot.setCheckCount(checkCount);
	 
	}
	@Given("checkpoint has been visited")
	public void checkpoint_has_been_visited() {
	    e.setVisited(true);
	}
	
	//move from specific coordinates
	@Given("robot at coordinates {int} and {int}")
	public void robot_at_coordinates_and(Integer int1, Integer int2) {
		initial = new Coordinates(int1,int2);
	    robot.setCoordinates(initial);
	}
	
	
	//move north from first row
	int dim;
	boolean possible;
	@Given("dimensions of the board")
	public void dimensions_of_the_board() {
	    dim = b.getDimensions();
	}
	
	@Given("robots orientation is north")
	public void robots_orientation_is_north() {
	    robot.setOrientation(0);
	}
	@Given("robot is in the first row and x {int}")
	public void robot_is_in_the_first_row_and_x(Integer int1) {
		initial = new Coordinates((int1%dim), 0);
	    robot.setCoordinates(initial);
	}
	@When("the robot tries to move")
	public void the_robot_tries_to_move() {
	    possible = robot.moved();
	}
	@Then("move is not possible")
	public void move_is_not_possible() {
	    assertFalse(possible);
	}
	@Then("robot didnt move")
	public void robot_didnt_move() {
	    assertTrue(initial.equals(fin));
	}
	
	//move south from last row
	@Given("robots orientation is south")
	public void robots_orientation_is_south() {
	    robot.setOrientation(2);
	}
	@Given("robot is in the last row and x {int}")
	public void robot_is_in_the_last_row_and_x(Integer int1) {
		initial = new Coordinates((int1%dim), dim-1);
	    robot.setCoordinates(initial);
	}
	
	//move west from first column
	@Given("robots orientation is west")
	public void robots_orientation_is_west() {
		robot.setOrientation(3);
	}
	@Given("robot is in the first column and y {int}")
	public void robot_is_in_the_first_column_and_y(Integer int1) {
	    initial = new Coordinates(0,int1%dim);
	    robot.setCoordinates(initial);
	}
	
	//move east from last column
	@Given("robots orientation is east")
	public void robots_orientation_is_east() {
	    robot.setOrientation(1);
	}
	@Given("robot is in the last column and y {int}")
	public void robot_is_in_the_last_column_and_y(Integer int1) {
		initial = new Coordinates(dim-1,int1%dim);
	    robot.setCoordinates(initial);
	}
	
	
	//Card and Deck
	//card is added to deck
	Deck deck;
	int numCards;
	String title;
	Card card;
	Card card2;
	@Given("a deck")
	public void a_deck() {
	    deck = new Deck();
	}
	@Given("number of cards in deck")
	public void number_of_cards_in_deck() {
	    numCards = deck.getNumCards();
	}
	@Given("a card with a title {string}")
	public void a_card_with_a_title(String string) {
	    title = string;
	    card = new Card(title);
	}
	@When("card is added to deck")
	public void card_is_added_to_deck() {
	    deck.add(card);
	}
	@Then("deck size incremented")
	public void deck_size_incremented() {
	    assertEquals(numCards+1,deck.getNumCards());
	}
	@Then("card is in deck")
	public void card_is_in_deck() {
	    assertTrue(deck.contains(card));
	}
	
	//card added and drawn from deck
//	@When("card is drawn from deck")
//	public void card_is_drawn_from_deck() {
//	    card = deck.draw();
//	}
//	@Then("cards are equal")
//	public void cards_are_equal() {
//	    assertEquals(card);
//	}
	
	//card drawn from deck
	@Given("three cards {string} {string} {string} in deck")
	public void three_cards_in_deck(String string, String string2, String string3) {
	    deck.add(new Card(string));
	    deck.add(new Card(string2));
	    deck.add(new Card(string3));
	}
	
	@When("card is drawn from deck")
	public void card_is_drawn_from_deck() {
	    card = deck.draw();
	}
	
	//add card that is already there
	@Then("deck size is not incremented")
	public void deck_size_is_not_incremented() {
	    assertEquals(numCards,deck.getNumCards());
	}
	
	//remove card from deck
	@When("title is removed")
	public void title_is_removed() {
	    deck.remove(new Card(title));
	}
	@Then("card is not in deck")
	public void card_is_not_in_deck() {
	    assertFalse(deck.contains(card));
	}
	@Then("deck size is decreased")
	public void deck_size_is_decreased() {
	    assertEquals(numCards-1,deck.getNumCards());
	}
	
	
	//add action
	Card.action action;
	List<Card.action> actions = new ArrayList<Card.action>();
	@Given("an sequence of actions")
	public void an_sequence_of_actions() {
		actions.add(Card.action.move);
		actions.add(Card.action.move);
		
		
	}
	@When("add action")
	public void add_action() {
	    card.setAction(actions);
	}
	
	@Then("action is added")
	public void action_is_added() {
	    assertEquals(card.printActions(),Arrays.toString(actions.toArray()));
	}
	
	//action move
	@Given("the action move")
	public void the_action_move() {
	    action = Card.action.move;
	}
	@Given("action is added to card")
	public void action_is_added_to_card() {
	    actions.add(action);
	}
	@When("card is played")
	public void card_is_played() {
	    assertTrue(card.play(robot));
	}
	
	//action turn left once
	@Given("the action turn left")
	public void the_action_turn_left() {
		action = Card.action.turnL;
	}
	
	//action turn right once
	@Given("the action turn right")
	public void the_action_turn_right() {
		action = Card.action.turnR;
	}
	
	
	//player 
	
	Hand hand;
	int capacity;
	int spaces;
	
	@Given("a hand of cards with capacity {int}")
	public void a_hand_of_cards_with_capacity(Integer int1) {
	    capacity = int1;
	    hand = new Hand(capacity);
	}
	
	@When("hand is emptied")
	public void hand_is_emptied() {
	    hand.empty();
	}
	@Then("hand is empty")
	public void hand_is_empty() {
	    assertTrue(hand.isEmpty());
	}
	
	
	@Given("a card with a title and an action")
	public void a_card_with_a_title_and_an_action() {
	    card = new Card("title");
	    action = Card.action.move;
	    actions.add(action);
	    card.setAction(actions);
	}
	
	@Given("space on hand")
	public void space_on_hand() {
		//redo this one, there shouldn't be an assert in this one
		assertTrue(hand.space());
//	    hand.makeSpace();
	}
	@Given("number of free spaces")
	public void number_of_free_spaces() {
	    spaces = hand.getSpaces();
	}
	@When("card is drawn")
	public void card_is_drawn() {
	    hand.draw(deck);
	}
	@Then("card is on hand")
	public void card_is_on_hand() {
	    assertTrue(hand.contains(card));
	}
	@Then("number of free spaces decrease by one")
	public void number_of_free_spaces_decrease_by_one() {
//		System.out.println("1.) old spaces: "+spaces+" new space: "+hand.getSpaces());
		assertEquals(spaces,hand.getSpaces()+1);
	}
	
	@Then("number of free spaces decrease")
	public void number_of_free_spaces_decrease() {
//		System.out.println("2.) old spaces: "+spaces+" new space: "+hand.getSpaces());
	    assertTrue(hand.getSpaces()-spaces<0);
	}
	
	@Given("a deck of cards")
	public void a_deck_of_cards() {
		deck = new Deck();
		card = new Card("title");
	    action = Card.action.move;
	    actions.add(action);
	    card.setAction(actions);
	    deck.add(card);
	}
	@When("hand is filled")
	public void hand_is_filled() {
	    hand.fill(deck);
	}
	@Then("hand is full")
	public void hand_is_full() {
	    assertTrue(hand.full());
	}
	@Then("there are as many cards as there is space")
	public void there_are_as_many_cards_as_there_is_space() {
	    assertEquals(capacity,hand.numCards());
	}
	
	@Given("card is added to hand")
	public void card_is_added_to_hand() {
	    hand.add(card);
	}
	
	//ordering cards
	int position;
	@Given("card is at position two")
	public void card_is_at_position_two() {
	    hand.setPosition(card,1);
	}
	@Given("initial position of the card")
	public void initial_position_of_the_card() {
	    position = hand.getPosition(card);
	}
	@Given("position one is empty")
	public void position_one_is_empty() {
	    hand.setPosition(null, 0);
	}
	@When("card is placed in position one")
	public void card_is_placed_in_position_one() {
	    hand.place(card,0);
	}
	@Then("position changed")
	public void position_changed() {
	    assertNotEquals(hand.getPosition(card),position);
	}
	@Then("card is at position one")
	public void card_is_at_position_one() {
	    assertEquals(hand.getPosition(card),0);
	}
	@Then("position two is empty")
	public void position_two_is_empty() {
	    assertNull(hand.getCardPosition(1));
	}

//  order cards as a player
	Player player;
	@Given("player fills hand")
	public void player_fills_hand() {
	    player.fillHand(deck);
	    player.printHand();
	}
	@Given("cards are not ordered")
	public void cards_are_not_ordered() {
	    player.setOrdered(false);
	}
	@Then("cards are ordered")
	public void cards_are_ordered() {
	    assertTrue(player.areOrdered());
	}
	
//	Player plays cards
	@Given("a player with the robot")
	public void a_player_with_the_robot() {
	    player = new Player(robot);
	}
	@Given("hand is connected to player")
	public void hand_is_connected_to_player() {
	    player.setHand(hand);
	}
	@When("cards are ordered randomly")
	public void cards_are_ordered_randomly() {
	    player.orderRandom();
	}
	@When("player plays hand")
	public void player_plays_hand() {
	    player.play();
	}
	@Then("players hand is empty")
	public void players_hand_is_empty() {
	    assertTrue(player.emptyHand());
	}
	
	
	
	
	//board scenarios
	Coordinates coordinates;
	boolean empty;
	boolean contains;
	@Given("coordinates {int} and {int}")
	public void coordinates_and(Integer int1, Integer int2) {
	    coordinates = new Coordinates(int1,int2);
	}
	@Given("element at coordinates")
	public void element_at_coordinates() {
	    e.setCoordinates(coordinates);
	}
	@Given("element on board")
	public void element_on_board() {
	    b.add(e);
	}
	@When("coordinates are checked")
	public void coordinates_are_checked() {
	    empty = b.isEmpty(coordinates);
	}
	@Then("spot is not empty")
	public void spot_is_not_empty() {
	    assertFalse(empty);
	}
	
	@Given("element on random spot on board")
	public void element_on_random_spot_on_board() {
	    b.addRandom(e);
	}
	@When("check if element is on board")
	public void check_if_element_is_on_board() {
	    contains = b.contains(e);
	}
	@Then("element is on board")
	public void element_is_on_board() {
	    assertTrue(contains);
	}
	
	@Given("start of the robot")
	public void start_of_the_robot() {
	    coordinates = robot.getStart();
	}
	@Then("robot is on board")
	public void robot_is_on_board() {
	    assertTrue(b.contains(robot));
	}
	
	
	@Given("{int} checkpoints")
	public void checkpoints(Integer int1) {
	    checkpoints = int1;
	}
	
	@When("board is set up with checkpoints")
	public void board_is_set_up_with_checkpoints() {
	    b.setUp(robot,checkpoints);
	}

	
	@Then("board contains n checkpoints")
	public void board_contains_n_checkpoints() {
	    assertEquals(checkpoints,b.getCheck());
	}
	@Then("there is one more element than checkpoints")
	public void there_is_one_more_element_than_checkpoints() {
		assertEquals(checkpoints+1,b.getElements());
	}

	@Given("next coordinates of the robot")
	public void next_coordinates_of_the_robot() {
	    coordinates = new Coordinates(robot.next_x(),robot.next_y());
	}
	
	@Then("robot is at the next coordinates")
	public void robot_is_at_the_next_coordinates() {
	    assertEquals(robot.getCoordinates(),coordinates);
	}
	
	@Then("there is an element at the spot")
	public void there_is_an_element_at_the_spot() {
	    assertNotNull(b.getElement(coordinates));
	}
	
	@Then("order can be printed")
	public void order_can_be_printed() {
	    assertTrue(hand.printOrder());
	}
	
	//obstaclefactory
	ObstacleFactory factory;
	int numObstacles;
	int dimensions;
	int numRobots;
	Robot robot1;
	Robot robot2;
	@Given("a factory")
	public void a_factory() {
	    factory = new ObstacleFactory();
	}
	@When("obstacle is added to factory")
	public void obstacle_is_added_to_factory() {
		factory.add((Obstacle) e);
	}
	@Then("obstacle is in factory")
	public void obstacle_is_in_factory() {
	    assertTrue(factory.contains((Obstacle) e));
	}
	
	
	
	@Given("a factory with obstacles")
	public void a_factory_with_obstacles() {
		factory = new ObstacleFactory();
		factory.add(new Pit());
		factory.add(new Gear());
		factory.add(new Conveyor());
	}
	@Given("{int} obstacles")
	public void obstacles(Integer int1) {
	    numObstacles = int1;
	}
	@Given("{int} of the board")
	public void of_the_board(Integer int1) {
	    dimensions = int1;
	}
	
	@Given("a board with one robot")
	public void a_board_with_one_robot() {
		b = new Board();
	    robot = new Robot(b);
	    numRobots = 1;
	    
	}
	
	@Given("a board with two robots")
	public void a_board_with_two_robots() {
		b = new Board();
	    robot1 = new Robot(b);
	    robot2 = new Robot(b);
	    numRobots = 2;
	}
	
	@When("board set up with elements")
	public void board_set_up_with_elements() {
	    if(numRobots == 1) b.setUp(robot, numObstacles, checkpoints, factory);
	    else if (numRobots == 2) b.setUp(robot1, robot2, numObstacles, checkpoints, factory);
	}
	@Then("there are {int} obstacles on board")
	public void there_are_obstacles_on_board(Integer int1) {
	    assertEquals(b.getNumElements(),numObstacles+numRobots+checkpoints);
	}

	
	Game game = new Game();
	//game ends
	@Given("a final checkpoint")
	public void a_final_checkpoint() {
		checkCount = b.getCheck();
	    e = new Checkpoint(checkCount);
	    
	}
	@Given("all other checkpoints have been visited")
	public void all_other_checkpoints_have_been_visited() {
	    robot.setCheckCount(checkCount-1);
	}
	@Then("the game is finished")
	public void the_game_is_finished() {
		game.addRobot(robot);
	    assertTrue(game.isFinished());
	}
	@Then("the robot won")
	public void the_robot_won() {
	    assertTrue(robot.winner());
	}

	
	//gamestart
	GameStart gamestart = new GameStart();
	Board board;
	
	@Given("the game difficulty is set {string}")
	public void the_game_difficulty_is_set(String string) {
		gamestart.setDifficulty(string);
//		System.out.println("set difficulty passed");
	}
	
	@Given("amount of players is {int}")
	public void amount_of_players_is(int int1) {
	    gamestart.setAmountOfPlayers(int1);
//	    System.out.println("amount of players passed");
	}
	
	@Given("multiplayer is false")
	public void multiplayer_is_false() {
		gamestart.setAmountOfPlayers(1);
	}

	
	@When("game start")
	public void game_start() {
	    gamestart.start();
	    System.out.println("gamestart passed");
	}
	@Then("a board is created")
	public void a_board_is_created() {
	    assertTrue(gamestart.getBoard() instanceof Board);
	    System.out.println("instanceof board passed");
	}
	@Then("there are at least {int} obstacles")
	public void there_are_at_least_obstacles(Integer int1) {
	    assertTrue(gamestart.getObstacles() >= int1);
	    System.out.println("getObstacles passed");
	}
	@Then("there are at least {int} checkpoints")
	public void there_are_at_least_checkpoints(Integer int1) {
	    assertTrue(gamestart.getCheckpoints() >= int1);
	    System.out.println("checkpoints passed");
	}
	@Then("there are {int} robots")
	public void there_are_robots(Integer int1) {
	    assertTrue(gamestart.getBoard().getNumRobots()==int1);
	    System.out.println("robots passed");
	}
	
	
	//Advanced obstacles
	@Given("a trampoline")
	public void a_trampoline() {
	    e = new Trampoline();
	}
	
	@When("robot hits obstacle")
	public void robot_hits_obstacle() {
	    robot.hit(e);
	}
	
	@Then("robot is at least {int} fields away")
	public void robot_is_at_least_fields_away(Integer int1) {
	    assertTrue(fin.diff(initial) >= 3);
	}
	
//	@Given("dimensions is {int}")
//	public void dimensions_is(int int1) {
//		gamestart.setDimensions(int1);
//	}
//	
//	@When("initialize dimensions for board")
//	public void initialize_dimensions_for_board() {
//	    board = new Board(gamestart.getCols());
//	}
//	
//	@Then("automaton returns dimensions for game board")
//	public void automaton_returns_dimensions_for_game_board() {
//	    assertNotNull(board.getDimensions());
//	}
//	
//	@When("initialize {int} robot")
//	public void initialize_robot(Integer int1) {
//	    if(int1 == 1 ) {
//	    	Robot rob = new Robot("Robby",board);
//	    	board.setUp(rob, gamestart.getObstacles(), gamestart.getCheckpoints());
//	    } else if(int1 == 2) {
//	    	Robot rob1 = new Robot("Robby",board);
//	    	Robot rob2 = new Robot("Robert",board);
//	    	board.setUp(rob1, rob2);
//	    }
//	}
//	
//	@Then("automaton create two robots")
//	public void automaton_create_two_robots() {
//	    assertEquals(board.getNumRobots(),2);
//	}
//	
//	@Then("automaton create one robots")
//	public void automaton_create_one_robots() {
//	    assertEquals(board.getNumRobots(),1);
//	}
	

}
