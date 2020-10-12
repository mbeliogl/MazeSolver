#### Maze Solver 

---

A typical maze has walls, a start point, and an end-point. 
The goal of this solver is to find a path from the start to the end that doesn't cross any walls. 
The GUI portion of the program if resposnible for visualizing the algorithm and highlighting the final path if it exists. 



> ###### A maze is represented by a _.txt_ file in the following format: 
>
> - numRows, numCols
>
> - Walls: # (hash)
>
> - Open Spaces: . (period)
>
> - Start: o (lowercase 'O')
>
> - Goal: * (asterisk)
>
>   You can use the provided maze files for guidance in creating your own maze



> ###### Two Agendas:
>
> In order to keep track of the locations in the maze that are reachable but still have to be processed,
> we need an agenda.
>
> - Stack Agenda: Locations are stored and retrieved in a FILO manner
> - Queue Agenda: Locations are stored and retrieved in a FIFO manner 
>
> When the program is executed, the user must specify the type of agenda that the Maze Solver should use.
>
> - The time complexity ( O(n^2) ) of operations executed by the solver remains unchanged regardless of the Agenda type
> - However, the Agenda type can significantly improve or reduce efficiency depending on the Maze layout
> - As a rule of thumb, the Stack Agenda does better with less walls
> - The final solution (path) is not affected by the Agenda type 



> ###### Use Maze Solver:
>
> 1. In  _Main.java_ find the following line of code:  ``` Maze m = new Maze(<path to maze file>) ```
> 2. Provide an _absolute_ path to the desired maze file 
> 3. Run _main_ 
> 4. Follow instructions in the terminal to specify the Agenda type
> 5. GUI Visualization:
>    1. The locations to be visited next will be painted **light grey** 
>    2. The locations that have already been visited will be painted **dark grey**
>    3. The path from start to end will be painted **gold**

