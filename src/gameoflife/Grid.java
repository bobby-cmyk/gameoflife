package gameoflife;

public class Grid {
    
    private Cell[][] cells;
    private int gridX;
    private int gridY;

    public Grid(int gridX, int gridY) {

        this.gridX  = gridX;
        this.gridY = gridY;
        this.cells = new Cell[gridX][gridY];

        // Initialise the grid with dead cells

        for (int x = 0; x < gridX; x++) {
            for (int y = 0; y < gridY; y++) {
                cells[x][y] = new Cell();
            }
        }
    }

    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    public void killCell(int x, int y) {
        this.cells[x][y].setAlive(false);
    }

    public void populateCell(int x, int y) {
        this.cells[x][y].setAlive(true);
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    @Override
    public String toString() {

        String gridString = "\n";

        for (int y = 0; y < this.gridY; y++) {

            String row = "";

            for (int x = 0; x < this.gridX; x++) {
                if (cells[x][y].isAlive()) {
                    row += "[*]";
                }
                else {
                    row += "[ ]";
                }
            }
            gridString += row + "\n";
        }
        return gridString;
    }
    
}

/*
 * 
 * [[2, 3] [3, 4] [5, 6]]
 * 
 * 
 * 
 * 
 */
