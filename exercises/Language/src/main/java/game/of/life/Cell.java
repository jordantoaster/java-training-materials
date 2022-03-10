package game.of.life;

import java.util.List;

public class Cell {
    private List<Cell> neighbours;
    private CellState state;

    public Cell(List<Cell> neighbours) {
        super();
        state = CellState.DEAD;
        this.neighbours = neighbours;
        if (neighbours.size() > 8) {
            throw new IllegalStateException();
        }
    }

    public void makeAlive() {
        setState(CellState.ALIVE);
    }

    public void makeDead() {
        setState(CellState.DEAD);
    }

    private void setState(CellState newState) {
        state = newState;
    }

    public void addNeighbour(Cell neighbour) {
        if (neighbours.size() == 8) {
            throw new IllegalStateException();
        }
        neighbours.add(neighbour);
    }

    public void changeState() {
        CellState result;
        int aliveNeighbours = 0;
        for (Cell c : neighbours) {
            if (c.state == CellState.ALIVE) {
                aliveNeighbours++;
            }
        }
        if (state == CellState.DEAD && aliveNeighbours == 3) {
            result = CellState.ALIVE;
        } else if (state == CellState.ALIVE && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
            result = CellState.ALIVE;
        } else {
            result = CellState.DEAD;
        }
        state = result;
    }

    public boolean isAlive() {
        return state == CellState.ALIVE;
    }

    public boolean isDead() {
        return state == CellState.DEAD;
    }
}
