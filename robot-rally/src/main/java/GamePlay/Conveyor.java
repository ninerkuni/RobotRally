package GamePlay;

public class Conveyor extends Obstacle{
	
	public int effect(int score) {
		return -1;
	}

	@Override
	public Coordinates move(Robot robot) {
		Coordinates coordinates = robot.coordinates;
		coordinates.movex(3);
		return coordinates;
	}
	

	public String message() {
		return "Conveyer";
	}
	
	@Override
	public Conveyor construct() {
		return new Conveyor();
	}
	
}
