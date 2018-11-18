package com.dk.graph.maze.solver;

public class MazeSolver {
	//int mazeMap [][];
	int endofMap;
	//boolean visited[][];
	int exitPointNumber;
	Maze maze;
	
	public void solveMaze(Maze maze) {
		setStartPositionOfMaze(maze);
		this.maze = maze;
		try {
			//this.mazeMap = maze.getMazeMap();
			this.endofMap = this.maze.getMazeMap().length-1;
			//this.visited = maze.getVisited();
			this.exitPointNumber = maze.getExitPointNumber();
			solve(maze.getStartPositionRow(), maze.getStartPositionCol());
			
			System.out.println("No route found");
		}catch(RuntimeException re) {
			System.out.println("Rout found, hence exiting..");
		}
		
	}	
	
	private void setStartPositionOfMaze(Maze maze) {
		int mazeMap[][] = maze.getMazeMap();
		for(int i = 0; i < maze.getNoOfRow(); i++) {
			for(int j = 0; j < maze.getNoOfCol(); j++) {
				if(mazeMap[i][j] == maze.getStartPointNumber()) {
					maze.setStartPositionRow(i);
					maze.setStartPositionCol(j);
				}
			}
		}
	}
	
	
	private void solve(int rowIndex, int colIndex) {
		
		System.out.println("Visiting RowIndex: "+rowIndex+", and ColIndex: "+colIndex);
		
		if(this.maze.getMazeMap()[rowIndex][colIndex] == this.exitPointNumber) {
			throw new RuntimeException("Rout found"); // exit found hence stopping the iteration
		}
		
		if(this.maze.getVisited()[rowIndex][colIndex]) {
			return;
		}else if(rowIndex < 0 || rowIndex > this.endofMap) {
			return;
		}else if(colIndex < 0 || colIndex > this.endofMap) {
			return;
		}else if(this.maze.getMazeMap()[rowIndex][colIndex] == 1) {
			return; // wall
		}else {
			
			this.maze.getVisited()[rowIndex][colIndex] = true;
			solve(rowIndex + 1, colIndex); //down
			solve(rowIndex, colIndex + 1);  //right
			solve(rowIndex, colIndex - 1); //left
			solve(rowIndex - 1, colIndex); //up
		}
		
	}

}
