package GamePlay;

public class Pit extends Obstacle{
	public int effect(int score) {
		return -score;
	}

	public String message() {
		return "Pit";
	}
	@Override
	public void reset(Robot robot) {
		robot.reset();

	}
	@Override
	public Pit construct() {
		return new Pit();
	}
	
}