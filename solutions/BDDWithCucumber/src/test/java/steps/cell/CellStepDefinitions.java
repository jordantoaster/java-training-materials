package steps.cell;

import cell.Cell;
import cell.CellState;
import io.cucumber.java8.En;

import static cell.CellState.*;
import static org.junit.jupiter.api.Assertions.*;

public class CellStepDefinitions implements En {
    private Cell cell;
    private Exception lastException;

    public CellStepDefinitions() {
        Given("^a new cell$",this::setup);
        Given("^a new cell which is (DEAD|ALIVE)$",(String stateStr) -> {
            setup();
            changeCellState(stateStr);
        });
        Given("^a new cell with neighbours$",() -> {
            setup();
            addRandomNeighbours();
        });
        When("^we make it (DEAD|ALIVE)$", this::changeCellState);
        When("we add a new neighbour", () -> {
            try {
                cell.addNeighbour(new Cell());
            } catch(IllegalStateException ex) {
                lastException = ex;
            }
        });
        And("^(\\d+) neighbours are ALIVE$",(Integer numAlive) -> {
            for (Cell c : createNeighbours(numAlive)) {
                cell.addNeighbour(c);
            }
        });
        Then("^the next state will be (DEAD|ALIVE)$", (String stateStr) -> {
            CellState state = CellState.valueOf(stateStr);
            cell.changeState();
            checkAliveOrDead(state);
        });
        Then("^the state of the cell is (DEAD|ALIVE)$", (String stateStr) -> {
            CellState state = CellState.valueOf(stateStr);
            checkAliveOrDead(state);
        });
        Then("an exception is thrown", () -> {
            assertNotNull(lastException);
        });
    }

    private void setup() {
        cell = new Cell();
        lastException = null;
    }

    private void checkAliveOrDead(CellState state) {
        switch (state) {
            case ALIVE:
                assertTrue(cell.isAlive());
                break;
            case DEAD:
                assertTrue(cell.isDead());
                break;
            default:
                throw new IllegalStateException("Unknown cell state");
        }
    }

    private void addRandomNeighbours() {
        for (int x = 0; x < 8; x++) {
            Cell newCell = new Cell();
            CellState state = Math.random() > 0.5 ? ALIVE : DEAD;
            newCell.setState(state);
            cell.addNeighbour(newCell);
        }
    }

    private Cell[] createNeighbours(int aliveCount) {
        Cell[] neighbours = {
                new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell()
        };
        for (int x = 0; x < aliveCount; x++) {
            neighbours[x].setState(ALIVE);
        }
        return neighbours;
    }

    private void changeCellState(String stateStr) {
        CellState state = CellState.valueOf(stateStr);
        cell.setState(state);
    }
}
