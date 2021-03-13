package direction;

import rover.*;

public class East extends Direction {
	final String dirName="E";
	
	@Override
	public void move(Point point) {
		point.moveXByOne();
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
		// TODO Auto-generated method stub
		return new North();
	}
	@Override
	public Direction turnRight() {
		// TODO Auto-generated method stub
		return new South();
	}
	
}
