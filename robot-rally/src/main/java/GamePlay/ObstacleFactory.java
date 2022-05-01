package GamePlay;

import java.util.ArrayList;

public class ObstacleFactory {
	private ArrayList<Obstacle> obstacles;
	public ObstacleFactory() {
		obstacles = new ArrayList<Obstacle>();
	}
	
	public Obstacle pick() {
		if(!(obstacles.isEmpty())) {
			int rand = obstacles.size() * ((int) Math.random());
			return obstacles.get(rand).construct();
		}
		else return null;
	}
	
	public void add(Obstacle e) {
		obstacles.add(e);
	}
	
	public void print() {
		for(Obstacle o : obstacles) {
			System.out.println(o.message());
		}
	}

	public boolean contains(Obstacle e) {
		return obstacles.contains(e);
	}
}
