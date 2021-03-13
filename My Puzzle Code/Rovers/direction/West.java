package direction;


import rover.*;

public class West extends Direction {
	final String dirName="W";
	
	@Override
	public void move(Point point) {
		point.moveXBackByOne();
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
		
		return new South();
	}
	@Override
	public Direction turnRight() {
		// TODO Auto-generated method stub
		return new North();
	}
}
