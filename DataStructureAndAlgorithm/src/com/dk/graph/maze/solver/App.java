package com.dk.graph.maze.solver;

public class App {
	
	public static void main(String ...strings) {
		// Initialize Maze Map;
		// Number 2 is the start point and  3 is exit point, 0 is pass and q1 is wall and you cannot move in that direction.
		
		int mazeMap [][] = new int[][] {
			{1, 1, 1, 1, 1},
			{1, 2, 0, 1, 1},
			{1, 1, 0, 1, 1},
			{1, 1, 0, 3, 1},
			{1, 1, 1, 1, 1}
		};
		Maze maze = new Maze(5, 5, 2, 3, mazeMap);
		
		MazeSolver mazeSolver = new MazeSolver();
		mazeSolver.solveMaze(maze);
		
		// No route to exit.
		int mazeMap1 [][] = new int[][] {
			{1, 1, 1, 1, 1},
			{1, 2, 0, 1, 1},
			{1, 1, 0, 1, 1},
			{1, 1, 1, 3, 1},
			{1, 1, 1, 1, 1}
		};
		Maze maze1 = new Maze(5, 5, 2, 3, mazeMap1);
		mazeSolver.solveMaze(maze1);
	}

}
