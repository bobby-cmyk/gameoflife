package gameoflife;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Instruction {
    
    private int gridX;
    private int gridY;
    private int startX;
    private int startY;
    private ArrayList<int[]> startingCells;

    public Instruction() {
        startingCells = new ArrayList<>();
    }

    public void read(String filePath) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        int startingCellY = 0;

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            else if (line.contains("GRID")) {
                String[] parts = line.split(" ");
                this.gridX = Integer.parseInt(parts[1]);
                this.gridY = Integer.parseInt(parts[2]);
            }
            else if (line.contains("START")) {
                String[] parts = line.split(" ");
                this.startX = Integer.parseInt(parts[1]);
                this.startY = Integer.parseInt(parts[2]);
            }
            else if (line.contains("*")) {
                String[] parts = line.split("");

                for (int i = 0; i < parts.length ; i++) {
                    if (parts[i].equals("*")) {
                        // Including the starting offset
                        int[] startingCell = {i + startX, startingCellY + startY};
                        startingCells.add(startingCell);
                    }
                }
                startingCellY ++;
            }
        }
        br.close();
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public ArrayList<int[]> getStartingCells() {
        return startingCells;
    }
    
}
