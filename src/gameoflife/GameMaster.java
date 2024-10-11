package gameoflife;

import java.util.ArrayList;

public class GameMaster {
    
    public Grid currentGrid;
    public Grid nextGrid;
    // Track the current generation
    public int currentGen;
    // Number of generations to loop through
    private final int GENS = 5;
    
    // Get grid size to start game
    public GameMaster(int gridX, int gridY) {
        this.currentGrid = new Grid(gridX, gridY);
        this.nextGrid = new Grid(gridX, gridY);
    }

    public void setStartingCells(ArrayList<int[]> startingCells) {

        for (int[] startingCell : startingCells) {

            int xPos = startingCell[0];
            int yPos = startingCell[1];

            this.currentGrid.populateCell(xPos, yPos);
        }
    }

    public Grid getCurrentGrid() {
        return this.currentGrid;
    }
}
