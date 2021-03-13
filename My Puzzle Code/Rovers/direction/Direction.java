package direction;

import rover.*;

public abstract class Direction {
	public abstract void move(Point point);
	public abstract Direction turnLeft();
	public abstract Direction turnRight();
	
	public String getDirName(){
		return "No Direction is Set";
	}

}
