package cell;

import java.util.ArrayList;
import java.util.List;

import static cell.CellState.*;

public class Cell {
    private List<Cell> neighbours;
    private CellState state;

    public Cell() {
        super();
        state = DEAD;
        neighbours = new ArrayList<Cell>();
    }
    public void setState(CellState newState) {
        state = newState;
    }
    public void addNeighbour(Cell neighbour) {
        if(neighbours.size() >= 8) {
            throw new IllegalStateException("Total of neighbours cannot exceed eight");
        }
	    neighbours.add(neighbour);
    }
    public void changeState() {
        state = calculateStateChange();
    }
    public void toggleState() {
        state = (state == ALIVE) ? DEAD : ALIVE;
    }
    public boolean isAlive() {
        return state == ALIVE;
    }
    public boolean isDead() {
        return state == DEAD;
    }
    private CellState calculateStateChange() {
        int aliveNeighbours = countAliveNeighbours();
        if (state == DEAD && aliveNeighbours == 3) {
            return ALIVE;
        } else if (state == ALIVE
                && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
            return ALIVE;
        } else {
            return DEAD;
        }
    }
    private int countAliveNeighbours() {
        int aliveNeighbours = 0;
        for(Cell c : neighbours) {
            if (c.state == ALIVE) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }
}
