// Maze.java

package com.maxim;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Maze {
    private final int numRows;
    private final int numCols;

    protected Location [][] maze;
    protected String [][] characters;

    public Location start;
    public Location goal;

	/**
	 * Constructor initializes maze and characters double arrays to store the maze
 	 * @param fileName, the maze file
	 */
	public Maze(String fileName) {
		File inFile = new File(fileName);

		Scanner input = null;
			try {
				input = new Scanner(inFile);
			} catch (FileNotFoundException fnf) {
				System.err.println("Input file not found");
				System.exit(1);
			}

		numRows = input.nextInt();
		numCols = input.nextInt();
		input.nextLine();

		maze = new Location [numRows][numCols];
		characters = new String [numRows][numCols];
		int row = 0;

		// determining which character is which object
		while(input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineScanner = new Scanner(line);
		
			for(int i = 0; i < numCols; i++) {
				String loc = line.substring(i, i+1);
				maze[row][i] = new Location(row,i);
				characters[row][i] = loc;
		
				if(loc.equals("o")) {
					start = maze[row][i];
			    }
				if(loc.equals("*")) {
					goal = maze[row][i];
			    }
		    }
		row++;
	    }
	
    }

	/**
	 * Get/Set methods
	 * @return numRows,numCols
	 * @return Start/Goal location (Location object)
	 */
	public int getNumColumns() { return numCols; }
    public int getNumRows() { return numRows; }

    public Location getStartLocation() { return start; }
    public Location getGoalLocation() { return goal; }


	/**
	 * Returns the character that occupies given location
	 * @param loc, Location object
	 * @return character at current location
	 */
	public String getSquare(Location loc) {
		int row = loc.getRow();
		int col = loc.getColumn();

		return characters[row][col];
    }

	/**
	 * Formats and prints the maze to terminal
	 * Useful for debugging
	 * @return entire maze as a formatted string
	 */
	public String toString() {
		int row = 0;
		String charAt = "";

		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++) {
				charAt = charAt + " " + characters[row][j];
			}
			row++;
			charAt = charAt + "\n";
	    }
    	return charAt;
    }
}	    
