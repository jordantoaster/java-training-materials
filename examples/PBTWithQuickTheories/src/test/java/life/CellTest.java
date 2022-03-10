package life;

import game.of.life.Cell;
import org.junit.Before;
import org.junit.Test;
import org.quicktheories.core.Profile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertTrue;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.range;
import static org.quicktheories.generators.SourceDSL.lists;

public class CellTest {
    static {
        Profile.registerProfile(
                CellTest.class,
                "cell",
                s -> s.withGenerateAttempts(10000)
                        .withExamples(100));
    }

    private List<Cell> neighbours;
    private Cell cell;

    public void buildNewCell() {
        neighbours = new ArrayList<Cell>();
        for (int x = 0; x < 8; x++) {
            neighbours.add(new Cell(new ArrayList<Cell>()));
        }
        cell = new Cell(neighbours);
    }

    @Test(expected = IllegalStateException.class)
    public void throwsWhenItHasTooManyNeighbours() {
        buildNewCell();
        cell.addNeighbour(new Cell(new ArrayList<>()));
    }

    @Test
    public void isDeadByDefault() {
        buildNewCell();
        assertTrue(cell.isDead());
    }

    @Test
    public void canBeMadeAlive() {
        buildNewCell();
        cell.makeAlive();
        assertTrue(cell.isAlive());
    }

    @Test
    public void canBeMadeDead() {
        buildNewCell();
        cell.makeAlive();
        assertTrue(cell.isAlive());
        cell.makeDead();
        assertTrue(cell.isDead());
    }

    @Test
    public void becomesAliveWhenThreeNeighboursAreAlive() {
        qt().withProfile(getClass(),"cell")
                .forAll(lists().of(range(0,7)).ofSize(3))
                .assuming(this::noDuplicates)
                .check(list -> {
                    buildNewCell();
                    list.forEach(num -> neighbours.get(num).makeAlive());
                    cell.changeState();
                    return cell.isAlive();
                });
    }

    @Test
    public void starvesWhenLessThanTwoNeighboursAreAlive() {
        qt().withProfile(getClass(),"cell")
                .forAll(range(0,7))
                .check(num -> {
                    buildNewCell();
                    cell.makeAlive();
                    neighbours.get(0).makeAlive();
                    cell.changeState();
                    return cell.isDead();
                });
    }

    @Test
    public void isOvercrowdedWhenMoreThanThreeNeighboursAreAlive() {
        qt().withProfile(getClass(),"cell")
                .forAll(lists().of(range(0,7)).ofSize(4))
                .assuming(this::noDuplicates)
                .check(list -> {
                    buildNewCell();
                    cell.makeAlive();
                    list.forEach(num -> neighbours.get(num).makeAlive());
                    cell.changeState();
                    return cell.isDead();
                });
    }

    @Test
    public void staysDeadUnlessThreeNeighboursAreAlive() {
        buildNewCell();
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

    private<T> boolean noDuplicates(List<T> items) {
        return items.size() == new HashSet<T>(items).size();
    }
}
