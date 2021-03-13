
//The complete package is an implementation of state pattern, 
//instead of using final variable and 
//switch case change the sate of robots.


package direction;


import rover.*;

public class North extends Direction {
	final String dirName="N";
	
	@Override
	public void move(Point point) {
		point.moveYByOne();
	}
	public String getDirName(){
		return dirName;
	}
	@Override
	public String toString(){
		return dirName;
	}
	
	@Override
	public Direction turnLeft() {
		return new West();
	}
	@Override
	public Direction turnRight() {
		return new East();
	}
}
