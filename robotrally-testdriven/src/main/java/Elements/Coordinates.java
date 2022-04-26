package Elements;


public class Coordinates {
	private int[] coordinates;
	
	public Coordinates() {
		coordinates = new int[2];
	}
	
	public Coordinates(int x, int y) {
		coordinates = new int[] {x,y};
	}
	
	public void set(int x, int y){
		coordinates[0] = x; 
		coordinates[1] = y;
//		System.out.println("coordinates changed");
	}
//	public int[] get() {
//		return coordinates;
//		
//	}
	
	public int getx() {
		return coordinates[0];
	}
	
	public int gety() {
		return coordinates[1];
	}
	
//	public String print() {
//		return "x = "+coordinates[0]+", y = "+coordinates[1];
//	}
	
	public int diffx(Coordinates c) {
//		int xf = c.getx();
//		int yf = c.gety();
//		System.out.println(c.getx()+"-"+this.getx()+"="+(c.getx()-this.getx()));
		return (c.getx()-this.getx());
	}
	
	public int diffy(Coordinates c) {
//		System.out.println(c.gety()+"-"+this.gety()+"="+(c.gety()-this.gety()));
		return (c.gety()-this.gety());
	}
	
	
	public void movex(int move) {
		this.set(getx()+move, gety());
	}
	
	public void movey(int move) {
		this.set(getx(), gety()+move);
	}
	
//	public void movex(int move, int bound) {
//		if(coordinates[0]+move <= bound && coordinates[0]+move >= 0) this.set(coordinates[0]+move, coordinates[1]);
//		else if (coordinates[0]+move > bound) this.set(bound, coordinates[1]);
//		else if (coordinates[0]+move < 0) this.set(0, coordinates[1]);
//	}
////	
//	public void movey(int move, int bound) {
//		if(coordinates[0]+move <= bound && coordinates[0]+move >= 0) this.set(coordinates[0], coordinates[1]+move);
//		else if (coordinates[0]+move > bound) this.set(coordinates[0],bound);
//		else if (coordinates[0]+move < 0) this.set(coordinates[0],0);
//	}
	

	@Override
    public boolean equals(Object obj) {
    	if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Coordinates coordinates = (Coordinates) obj;
        if(this.coordinates == null || coordinates.coordinates == null) {
        	return false;
        }
        
        return (this.getx()==coordinates.getx()&&this.gety()==coordinates.gety());
    }
	
	
	public void print() {
		System.out.println("("+getx()+","+gety()+")");
	}

	public int diff(Coordinates c) {
		int dx = Math.abs(this.getx()-c.getx());
		int dy = Math.abs(this.gety()-c.gety());
		return (int) Math.sqrt(dx*dx+dy*dy);
	}

	public void setRandom(int dimensions) {
		int x = (int) (dimensions*Math.random());
		int y = (int) (dimensions*Math.random());
		
		this.set(x, y);
	}
}
