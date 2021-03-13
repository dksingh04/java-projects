package direction;


import rover.*;

public class South extends Direction {
	final String dirName="S";
	
	@Override
	public void move(Point point) {
		point.moveYBackByOne();
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
		return new East();
	}
	@Override
	public Direction turnRight() {
		// TODO Auto-generated method stub
		return new West();
	}
}
