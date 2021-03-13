package instruction;

import direction.*;
import rover.*;

public class Move extends Instruction{

	@Override
	public Position execute(Position pos) {
		Direction direction = pos.getDirection();
		direction.move(pos.getPoint());
		return pos;
	}
	
}
