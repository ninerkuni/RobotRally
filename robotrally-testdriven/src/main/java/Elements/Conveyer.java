package Elements;

public class Conveyer extends Obstacle{

	public int effect(int score) {
		return -1;
	}

	@Override
	public void move(Robot robot) {
		Coordinates coordinates = robot.coordinates;
		coordinates.movex(3);
		robot.move(coordinates);
	}
	

	public String message() {
		return "Conveyer";
	}
	
	@Override
	public Conveyer construct() {
		return new Conveyer();
	}
	
}
