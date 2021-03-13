package constants;

import java.util.HashMap;
import java.util.Map;
import direction.*;
import instruction.*;

public class Constants {
	private static Map<String, Direction> directionMap;
	private static Map<Character, Instruction> instructionMap;
	//public static final String clockWiseMove="NESWN"; // When Instruction will be for Right Direction
	//public static final String antiClockWiseMove="NWSEN"; // When Instruction will be for Left Direction
	public static Map<String, Direction> getDirectionMap() {
		if(directionMap == null){
			directionMap = new HashMap<String, Direction>();
			directionMap.put("N", new North());
			directionMap.put("S", new South());
			directionMap.put("E", new East());
			directionMap.put("W", new West());
		}
		return directionMap;
	}
	public static Map<Character, Instruction> getInstructionMap() {
		if(instructionMap == null){
			instructionMap = new HashMap<Character, Instruction>();
			instructionMap.put('L', new Left());
			instructionMap.put('R', new Right());
			instructionMap.put('M', new Move());
		}
		return instructionMap;
	}

	
	
	
}
