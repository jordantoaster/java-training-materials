package game.of.life;


import game.of.life.Cell;
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

    @Test
    public void becomesAliveWhenThreeNeighboursAreAlive() {
        neighbours.get(0).makeAlive();
        neighbours.get(1).makeAlive();
        neighbours.get(2).makeAlive();
        cell.changeState();
        assertTrue(cell.isAlive());
    }

    @Test
    public void starvesWhenLessThanTwoNeighboursAreAlive() {
        cell.makeAlive();
        neighbours.get(0).makeAlive();
        cell.changeState();
        assertTrue(cell.isDead());
    }

    @Test
    public void isOvercrowdedWhenMoreThanThreeNeighboursAreAlive() {
        cell.makeAlive();
        neighbours.get(0).makeAlive();
        neighbours.get(1).makeAlive();
        neighbours.get(2).makeAlive();
        neighbours.get(3).makeAlive();
        cell.changeState();
        assertTrue(cell.isDead());
    }

    @Test
    public void staysDeadUnlessThreeNeighboursAreAlive() {
        for (int x = 0; x <= 8; x++) {
            Cell cell = new Cell(neighbours);
            for (int y = 0; y < x; y++) {
                neighbours.get(y).makeAlive();
            }
            cell.changeState();
            if (x == 3) {
                assertTrue(cell.isAlive());
            } else {
                assertTrue(cell.isDead());
            }
        }
    }
}
