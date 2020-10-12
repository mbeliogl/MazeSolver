package com.maxim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

public class MazeGUI extends JPanel {
    GridBagConstraints gbc;
    
    private final Square [][] squares;

    private Location startLocation;
    private Location goalLocation;
    
    public MazeGUI(Maze maze) {
		int rows = maze.getNumRows();
		int cols = maze.getNumColumns();
		squares = new Square[rows][cols];

		/* Initializes the GUI */
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());

		/* Sets up the grid */
		for (int row = 0; row < rows; ++row) {
	    	for (int col = 0; col < cols; ++col) {
				gbc.gridx = col;
				gbc.gridy = row;

				Square sqr = new Square(600/cols, 600/rows);
				Location loc = new Location(row, col);
				String symbol = maze.getSquare(loc);
		
				if (symbol.equals("#")) {
					sqr.setColor(Color.BLACK);
				}
				else if (symbol.equals("o")) {
		    		sqr.setColor(Color.GREEN);
		    		startLocation = new Location(row, col);
				}
				else if (symbol.equals("*")) {
		    		sqr.setColor(Color.RED);
		    		goalLocation = new Location(row, col);
				}
		
				add(sqr, gbc);
				squares[row][col] = sqr;
	    	}
		}
    }

    /*
     * Called when a location is added to agenda in solveMaze
     */
    public void addLocToAgenda(Location loc) {
    	if ((!loc.equals(startLocation)) && (!loc.equals(goalLocation)))
	    squares[loc.getRow()][loc.getColumn()].setColor(Color.LIGHT_GRAY);
    }

    /*
     * Called after a location has been visited in solveMaze
     */
    public void visitLoc(Location loc) {
		if ((!loc.equals(startLocation)) && (!loc.equals(goalLocation)))
	    squares[loc.getRow()][loc.getColumn()].setColor(Color.DARK_GRAY);
    }

    /* 
     * Called as solution path is constructed in solveMaze
     */
    public void addLocToPath(Location loc) {
		if ((!loc.equals(startLocation)) && (!loc.equals(goalLocation)))
	    squares[loc.getRow()][loc.getColumn()].setColor(Color.YELLOW);
    }

    public void pause() {
		try { Thread.sleep(1000); }
		catch (InterruptedException ignored) { }
    }

}
