package gameoflife;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        Grid grid = new Grid(3,3);

        System.out.println(grid.getCell(0, 0));

        System.out.println(">>> Action: Set cell");

        grid.setCell(0, 0, new Cell(true));
        
        System.out.println(grid.getCell(0, 0));

        System.out.println(">>> Action: Kill cell");
        grid.getCell(0, 0).setAlive(false);

        System.out.println(grid.getCell(0,0));

        Instruction instruction = new Instruction();

        System.out.println("Read file");

        instruction.read("gol/toad.gol");

        System.out.printf("Grid X: %d\n", instruction.getGridX());

        System.out.printf("Grid Y: %d\n", instruction.getGridY());

        for (int[] position : instruction.getStartingCells()) {
            System.out.println(position[0] + ":" + position[1]);
        }

    }
}


/*
 


// Classes:

1. Cell (DONE)
variables: boolean alive, int x-axis, int y-axis
methods: get and set whether a cell is alive.

2. Grid (DONE)
variables: An array of cells Cell[]
instantiate: A grid, get parameters, what is the size of grid


3. Game:

variables: two Grids. currentGrid , and afterGrid, int generation, final int GAMES = 5

Game (File)


method: Method -> setGame: read the file, and get what is the starting point, and then use the set-cell method to set the cell alive

private method --> playGeneration (currentGrid, afterGrid) {   loop through the evaluator   }

public playGame ();
    for (gen : GAMES) {

    playGeneration ()

        currentGrid = afterGrid
        afterGrid
    
}


4. Evalutor:


evaluate ()


5. File Reader

 */