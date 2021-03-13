package rover;

import direction.Direction;

public class Position {
	private Direction direction;
	private Point point;
	
	public Position(Direction direction, Point point){
		this.direction = direction;
		this.point = point;
	}
	public Direction getDirection() {
		return direction;
	}
	public Point getPoint() {
		return point;
	}
	
	
}
