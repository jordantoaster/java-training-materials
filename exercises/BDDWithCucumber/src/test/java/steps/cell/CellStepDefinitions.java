package steps.cell;

import cell.Cell;
import cell.CellState;
import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.*;

public class CellStepDefinitions implements En {
    private Cell cell;

    public CellStepDefinitions() {
        Given("^a new cell$",this::setup);
        When("^we make it (DEAD|ALIVE)$", this::changeCellState);
        Then("^the state of the cell is (DEAD|ALIVE)$", (String stateStr) -> {
            CellState state = CellState.valueOf(stateStr);
            checkAliveOrDead(state);
        });
    }

    private void setup() {
        cell = new Cell();
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

    private void changeCellState(String stateStr) {
        CellState state = CellState.valueOf(stateStr);
        cell.setState(state);
    }
}
