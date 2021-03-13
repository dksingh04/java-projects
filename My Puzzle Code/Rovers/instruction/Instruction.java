package instruction;

import rover.*;

public abstract class Instruction {
	public abstract Position execute(Position position);
}
