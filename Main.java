package com.maxim;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Instantiating Maze and MazeGUI
        Maze m = new Maze("C:\\Users\\MAX\\IdeaProjects\\Maze\\src\\com\\maxim\\Maze Files\\mazefile3");
        MazeGUI mazeGraphics = new MazeGUI(m);

        // Setting graphics settings
        JFrame frame = new JFrame("Maze Solver");
        frame.getContentPane().add("Center", mazeGraphics);

        mazeGraphics.setFocusable(true);
        mazeGraphics.requestFocusInWindow();

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        /**
         * Getting user input for agenda type (Stack or Queue)
         * Generating an agenda accordingly and creating a new solver
         * Using the solver to call solveMaze and store result in variable 'path'
         * If path is empty, print error message stating path doesn't exists
         * If path is not empty, print the path
         */
        System.out.println("Type 's' to use a Stack Agenda. Type 'q' to use a Queue Agenda: ");
        System.out.println("Type any other letter to quit.");
        Scanner scanner = new Scanner((System.in));
        String agendaType = scanner.nextLine();


        if(agendaType.equals("s")){
            StackAgenda stackAgenda = new StackAgenda();
            MazeSolver solver = new MazeSolver(stackAgenda);
            ArrayList<Location> path = solver.solveMaze(m, mazeGraphics);
            int sizeOfPath = path.size();
            if(sizeOfPath == 0){
                System.err.println("No path exists. Please check the maze file.");
            }
            else{ System.out.println(path); }

        }
        else if(agendaType.equals("q")){
            QueueAgenda queueAgenda = new QueueAgenda();
            MazeSolver solver = new MazeSolver(queueAgenda);
            ArrayList<Location> path = solver.solveMaze(m, mazeGraphics);
            int sizeOfPath = path.size();
            if(sizeOfPath == 0){
                System.err.println("No path exists. Please check the maze file.");
            }
            else{ System.out.println(path); }
        }

        else{
            System.out.println("----- EXITING -----");
            System.exit(1);
        }
    }
}
