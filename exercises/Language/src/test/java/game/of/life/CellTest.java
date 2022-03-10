package game.of.life;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    private List<Cell> neighbours;
    private Cell cell;

    @BeforeEach
    public void start() {
        neighbours = new ArrayList<Cell>();
        for (int x = 0; x < 8; x++) {
            neighbours.add(new Cell(new ArrayList<Cell>()));
        }
        cell = new Cell(neighbours);
    }

    @Test
    public void throwsWhenItHasTooManyNeighbours() {
        assertThrows(
                IllegalStateException.class,
                () -> cell.addNeighbour(new Cell(new ArrayList<Cell>()))
        );
    }

    @Test
    public void isDeadByDefault() {
        assertTrue(cell.isDead());
    }

    @Test
    public void canBeMadeAlive() {
        cell.makeAlive();
        assertTrue(cell.isAlive());
    }

    @Test
    public void canBeMadeDead() {
        cell.makeAlive();
        assertTrue(cell.isAlive());
        cell.makeDead();
        assertTrue(cell.isDead());
    }
}
