// This package is based on Command Pattern. 

package instruction;

import rover.*;
import direction.*;
public class Left extends Instruction{

	@Override
	public Position execute(Position pos) {
		Direction direction = pos.getDirection();
		direction = direction.turnLeft();
		Position position = new Position(direction, pos.getPoint());
		return position;
	}

}
