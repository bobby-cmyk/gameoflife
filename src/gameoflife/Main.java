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

        game.playGame();
    }
}