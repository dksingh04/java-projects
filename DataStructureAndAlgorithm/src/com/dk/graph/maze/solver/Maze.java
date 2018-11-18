package com.dk.graph.maze.solver;

public class Maze {
	
	private int startPositionRow;
	private int startPositionCol;
	private int noOfRow;
	private int noOfCol;
	
	private int startPointNumber;
	private int exitPointNumber;
	
	private int mazeMap[][];
	private boolean visited [][];
	
	public Maze(int noOfRow, int noOfCol, int startPointNumber, int exitPointNumber, int mazeMap[][]) {
		
		this.noOfRow = noOfRow;
		this.noOfCol = noOfCol;
		this.startPointNumber = startPointNumber;
		this.exitPointNumber = exitPointNumber;
		this.mazeMap = new int[this.noOfRow][this.noOfCol];
		this.visited = new boolean[this.noOfRow][this.noOfCol];
		this.mazeMap = mazeMap;
		
	}
	
	public int getStartPositionRow() {
		return startPositionRow;
	}
	public void setStartPositionRow(int startPositionRow) {
		this.startPositionRow = startPositionRow;
	}
	public int getStartPositionCol() {
		return startPositionCol;
	}
	public void setStartPositionCol(int startPositionCol) {
		this.startPositionCol = startPositionCol;
	}
	public int getNoOfRow() {
		return noOfRow;
	}
	public void setNoOfRow(int noOfRow) {
		this.noOfRow = noOfRow;
	}
	public int getNoOfCol() {
		return noOfCol;
	}
	public void setNoOfCol(int noOfCol) {
		this.noOfCol = noOfCol;
	}
	public int getStartPointNumber() {
		return startPointNumber;
	}
	public void setStartPointNumber(int startPointNumber) {
		this.startPointNumber = startPointNumber;
	}
	public int getExitPointNumber() {
		return exitPointNumber;
	}
	public void setExitPointNumber(int exitPointNumber) {
		this.exitPointNumber = exitPointNumber;
	}
	public int[][] getMazeMap() {
		return mazeMap;
	}
	public void setMazeMap(int[][] mazeMap) {
		this.mazeMap = mazeMap;
	}

	public boolean[][] getVisited() {
		return visited;
	}

	public void setVisited(boolean[][] visited) {
		this.visited = visited;
	}
	
	
	

}
