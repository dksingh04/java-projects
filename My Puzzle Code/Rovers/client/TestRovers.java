package client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.*;
import instruction.*;
import rover.*;

public class TestRovers {
	private Scanner keyboard;
	List<Rovers> roversList = new ArrayList<Rovers>();
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ReadingException, InvalidMoveException{
		TestRovers testRover = new TestRovers();
		testRover.readInput();
		testRover.executeInstructions();
		testRover.displayOutput();
	}
	
	public void readInput()throws ReadingException{
		System.out.println("Enter Grid Area.. \n");
		keyboard = new Scanner(System.in);
		RectangularArea.xMaxRange = keyboard.nextInt();
		RectangularArea.yMaxRange = keyboard.nextInt();
		keyboard.nextLine();
		char ch = 'Y';
		do {
			int x = keyboard.nextInt();
			int y = keyboard.nextInt();
			String dir = keyboard.next();
			keyboard.nextLine();
			String instruction = keyboard.nextLine();
			Rovers rover = new Rovers(x, y, dir, instruction);
			System.out.println("Would you like to deploye More rovers (Y/y)?\n");
			roversList.add(rover);
			String ques = keyboard.next();
			ch = ques.charAt(0);
		}while(ch=='Y' || ch=='y');
		
	}
	
	public void executeInstructions()throws InvalidMoveException{
		for(Rovers rover:roversList){
			rover.executeInstructions(); 
		}
	}
	
	public void displayOutput(){
		for(Rovers rover:roversList){
			System.out.println(rover.getX()+" "+rover.getY()+" "+rover.getDirection());
		}
	}
}
