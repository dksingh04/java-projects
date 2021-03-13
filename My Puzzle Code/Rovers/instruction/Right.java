package instruction;

import direction.Direction;
import rover.*;

public class Right extends Instruction{

	@Override
	public Position execute(Position pos) {
		Direction direction = pos.getDirection();
		direction = direction.turnRight();
		Position position = new Position(direction, pos.getPoint());
		return position;
		// TODO Auto-generated method stub
		
	}

}
