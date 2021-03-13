package rover;

import direction.Direction;
import constants.Constants;
import instruction.*;
public class Rovers {
	private Position position;
	private String instructions;
	
	public Rovers(int x, int y, String dir, String instructions){
		Point point = new Point(x, y);
		Direction direction = Constants.getDirectionMap().get(dir);
		position = new Position(direction, point);
		this.instructions = instructions;
	}
	
	public void executeInstructions(){
		for(int i = 0; i < instructions.length(); i++){
			char ch = instructions.charAt(i);
			Instruction instr = Constants.getInstructionMap().get(ch);
			position = instr.execute(position);
		}
	}
	
	public int getX(){
		return position.getPoint().getX();
	}
	
	public int getY() {
		return position.getPoint().getY();
	}
	public Direction getDirection(){
		return position.getDirection();
	}
	public String getInstructions() {
		return instructions;
	}
	
}
