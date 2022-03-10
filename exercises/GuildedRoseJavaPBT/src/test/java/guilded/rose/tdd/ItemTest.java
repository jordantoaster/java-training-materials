package guilded.rose.tdd;

import guilded.rose.Item;
import org.junit.jupiter.api.Test;

import static guilded.rose.ItemType.*;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {
    @Test
    public void itemsInitiallyHaveTheirGivenQuality() {
        var item = new Item(4, 10);
        assertEquals(10, item.quality());
    }

    @Test
    public void suppliedQualityCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Item(4, -1));
    }

    @Test
    public void suppliedQualityNeverExceedsFifty() {
        assertThrows(IllegalArgumentException.class, () -> new Item(4, 51));
    }

    @Test
    public void regularItemsDecreaseInQualityToZero() {
        var item = new Item(4, 3);
        assertQuality(item, 2, 1, 0);
    }

    @Test
    public void itemQualityNeverDecreasesBelowZero() {
        var item = new Item(4, 2);
        assertQuality(item, 1, 0, 0);
    }

    @Test
    public void regularItemsDegradeTwiceAsFastAfterExpiry() {
        var item = new Item(4, 10);
        assertQuality(item, 9, 8, 7, 6, 4, 2, 0);
    }

    @Test
    public void agedBrieIncreasesInQuality() {
        var item = new Item(AgedBrie, 3, 10);
        assertQuality(item, 11, 12, 13, 14, 15);
    }

    @Test
    public void agedBrieQualityNeverExceedsFifty() {
        var item = new Item(AgedBrie, 3, 48);
        assertQuality(item, 49, 50, 50, 50, 50);
    }

    @Test
    public void sulfurasQualityNeverChanges() {
        var item = new Item(Sulfuras, 3, 30);
        assertQuality(item, 30, 30, 30, 30, 30);
    }

    @Test
    public void backstagePassesIncreaseInValueWhenTenDaysRemain() {
        var item = new Item(BackstagePass, 12, 20);
        assertQuality(item, 21, 23, 25, 27);
    }

    @Test
    public void backstagePassesIncreaseInValueWhenFiveDaysRemain() {
        var item = new Item(BackstagePass, 8, 20);
        assertQuality(item, 22, 24, 27, 30);
    }

    @Test
    public void backstagePassesLoseAllValueAfterConcert() {
        var item = new Item(BackstagePass, 3, 20);
        assertQuality(item, 23, 26, 29, 0, 0, 0);
    }

    private void assertQuality(Item item, int... qualityValues) {
        range(0, qualityValues.length).forEach(num -> {
            item.endOfDay();
            assertEquals(qualityValues[num], item.quality());
        });
    }
}
