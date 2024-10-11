package gameoflife;

public class Grid {
    
    private Cell[][] cells;

    public Grid(int gridX, int gridY) {
        this.cells = new Cell[gridX][gridY];
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setCell(int x, int y, Cell cell) {
        cells[x][y] = cell;
    }
    
}
