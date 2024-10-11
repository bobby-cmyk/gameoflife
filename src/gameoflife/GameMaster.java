package gameoflife;

import java.util.ArrayList;

public class GameMaster {
    
    public Grid currentGrid;
    public Grid nextGrid;
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

    public void playGame() {
        this.playGame(GENS);
    }

    public void playGame(int numberOfGenerations) {

        for (int i = 0; i < numberOfGenerations; i++) {
            System.out.printf("Generation: %d\n", (i+1));
            playGeneration();
        }
    }

    private void playGeneration() {

        for (int x = 0; x < currentGrid.getGridX(); x++) {
            for (int y = 0; y < currentGrid.getGridY(); y++) {
                
                int[][] cellsToCheck = {
                    {x-1, y+1},
                    {x, y+1},
                    {x+1, y+1}, 
                    {x-1, y}, 
                    {x+1, y}, 
                    {x-1, y-1}, 
                    {x, y-1}, 
                    {x+1, y-1}};

                int nearbyAliveCells = 0;


                for (int c = 0; c < cellsToCheck.length; c++) {
                    int xPos = cellsToCheck[c][0];
                    int yPos = cellsToCheck[c][1];

                    // Only check cells that are within the grid
                    if (xPos > 0 && xPos < currentGrid.getGridX() && yPos > 0 && yPos <currentGrid.getGridY()) {
                        if (currentGrid.getCell(xPos, yPos).isAlive()) {
                            nearbyAliveCells ++;
                        }
                    }
                }

                if (nearbyAliveCells == 0) {
                    nextGrid.killCell(x, y);
                }

                else if (nearbyAliveCells >= 4) {
                    nextGrid.killCell(x, y);
                }

                else if (nearbyAliveCells == 3) {
                    nextGrid.populateCell(x, y);
                }

                // Else dont need to do anything

            }

        }
        System.out.println(currentGrid);

        currentGrid = nextGrid;
        nextGrid = new Grid(currentGrid.getGridX(), currentGrid.getGridY());
    }

    public Grid getCurrentGrid() {
        return this.currentGrid;
    }

    public Grid getNextGrid() {
        return this.nextGrid;
    }
}
