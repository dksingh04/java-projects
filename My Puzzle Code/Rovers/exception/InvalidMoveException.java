package exception;

public class InvalidMoveException extends Exception {

	private static final long serialVersionUID = 4220734176450573844L;
	public InvalidMoveException(){
		super("!!Moved Out of the defined area..!!");
	}

}
