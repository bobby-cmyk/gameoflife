package gameoflife;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        if (args.length == 0) {
            System.out.println("Please include path of GoL file");
            System.exit(-1);
        }
        
        String filePath = args[0];
        
        Instruction instruction = new Instruction();
        instruction.read(filePath);

        // Grid size for the game
        int gridX = instruction.getGridX();
        int gridY = instruction.getGridY();

        // Starting cells for the game
        ArrayList<int[]> startingCells = instruction.getStartingCells();

        // Initialise game master
        GameMaster game = new GameMaster(gridX, gridY);

        // Start game;
        game.setStartingCells(startingCells);

        Grid currentGrid = game.getCurrentGrid();

        System.out.println(currentGrid);

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


5. File Reader (DONE)

 */