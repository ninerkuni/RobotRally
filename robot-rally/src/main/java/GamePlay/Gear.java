package GamePlay;

public class Gear extends Obstacle{
	
	private boolean left;
	
	public void setLeft(boolean left) {
		this.left = left;
	}
	
	@Override
	public void reset(Robot robot) {
		if(left) robot.turnL();
		else robot.turnR();
	}
	

	public String message() {
		return "Gear";
	}
	
	public Gear construct() {
		return new Gear();
	}
}
