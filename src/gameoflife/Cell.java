package gameoflife;

public class Cell {
    
    private boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }
    // By default cell should be dead
    public Cell() {
        this(false);
    }

    // Should be able to set and get from the grid.
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        String cellStatus = "";

        if (this.alive) {
            cellStatus = "alive :)";
        }
        else {
            cellStatus = "dead :(";
        }
        return "Cell is %s".formatted(cellStatus);
    }

}
