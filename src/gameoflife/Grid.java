package gameoflife;

public class Grid {
    
    private Cell[][] cells;

    public Grid(int gridX, int gridY) {
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

    @Override
    public String toString() {

        String gridString = "\n";

        for (int y = 0; y < cells.length; y++) {

            String row = "";

            for (int x = 0; x < cells[0].length; x++) {
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
