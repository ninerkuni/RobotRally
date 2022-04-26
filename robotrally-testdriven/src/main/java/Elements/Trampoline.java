package Elements;

public class Trampoline extends Element {

	@Override
	String message() {
		return "Trampoline";
	}

	@Override
	int effect(int x) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void move(Robot robot) {
		Coordinates coordinates = robot.coordinates;
		int rx; int ry;
		//robot has to be moved at least 3
		while(true) {
			rx = (int) (1+2*Math.random());
			ry = (int) (Math.sqrt(9-rx*rx)+5*Math.random());
			if(robot.possibleMove(rx,ry) && Math.abs(rx-coordinates.getx())>2 && Math.abs(ry-coordinates.gety())>2) {
				break;
			}

		}
		coordinates.set(rx, ry);
		robot.move(coordinates);
	}

}
