package com.maxim;
import java.util.ArrayList;

public class MazeSolver {
    protected Agenda agenda;

    /* Constructor */
    public MazeSolver(Agenda ag) { agenda = ag; }
    
    public ArrayList<Location> solveMaze(Maze m, MazeGUI mg) {
		/* clears the agenda and initializes values */
		agenda.clear();

		ArrayList<Location> added = new ArrayList<Location>(); //keeping track of the items that have been added
		Location [][] prev = new Location[m.getNumRows()][m.getNumColumns()];

		Location start = m.getStartLocation();
		added.add(start);
		agenda.addLocation(start);

        ArrayList<Location> path = new ArrayList<Location>();


		while(! agenda.isEmpty()) {
		
			Location loc = agenda.getLocation();
			mg.pause();
			mg.visitLoc(loc);

			if(m.getGoalLocation().equals(loc)) {
				agenda.clear();
				Location finalLoc = m.getGoalLocation();
		        
			
				while(! finalLoc.equals(start)) {
					path.add(finalLoc);
					finalLoc = prev[finalLoc.getRow()][finalLoc.getColumn()];
				}
				path.add(finalLoc);
			
			
				for(int i = 0, j = path.size()-1; i<j; i++) {
					path.add(i, path.remove(j));
			    }
				for(Location l : path){
					mg.addLocToPath(l);
				}

				return path;
			}


			/*Each if statement checks a specific condition (N,S,E,W)
			*Initializes location objects if the criteria is met
			*Checks if the list added already contains the object and if it is not a wall by using the characters array
		 	*/
		
			if(loc.row + 1 < m.getNumRows() && !added.contains(m.maze[loc.row + 1][loc.col]) && !m.characters[loc.row+1][loc.col].equals("#")) {
				Location locS = m.maze[loc.row+1][loc.col];
				added.add(locS);
				mg.addLocToAgenda(locS);
				agenda.addLocation(locS);
				prev[locS.getRow()][locS.getColumn()] = loc;
		    }

			if(loc.row - 1 >= 0 && !added.contains(m.maze[loc.row - 1][loc.col]) && !m.characters[loc.row-1][loc.col].equals("#")) {
				Location locN = m.maze[loc.row-1][loc.col];
				added.add(locN);
				mg.addLocToAgenda(locN);
				agenda.addLocation(locN);
				prev[locN.getRow()][locN.getColumn()] = loc;
		    }
		
			if(loc.col + 1 < m.getNumColumns() && !added.contains(m.maze[loc.row][loc.col + 1]) && !m.characters[loc.row][loc.col+1].equals("#")) {
				Location locE = m.maze[loc.row][loc.col+1];
				added.add(locE);
				mg.addLocToAgenda(locE);
				agenda.addLocation(locE);
				prev[locE.getRow()][locE.getColumn()] = loc;
		    }

			if(loc.col - 1 >= 0 && !added.contains(m.maze[loc.row][loc.col - 1]) && !m.characters[loc.row][loc.col-1].equals("#")) {
				Location locW = m.maze[loc.row][loc.col-1];
				added.add(locW);
				mg.addLocToAgenda(locW);
				agenda.addLocation(locW);
				prev[locW.getRow()][locW.getColumn()] = loc;
			}
		}
		return path;
    }
    
}




