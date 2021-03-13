package rover;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void moveXByOne(){
		x++;
	}
	public int moveXBackByOne(){
		return x--;
	}
	
	public int moveYByOne(){
		return y++;
	}
	public int moveYBackByOne(){
		return y--;
	}
}
