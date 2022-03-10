package guilded.rose.pbt;

import guilded.rose.Item;
import guilded.rose.ItemType;
import org.junit.jupiter.api.Test;
import org.quicktheories.core.Gen;
import org.quicktheories.core.Profile;

import static guilded.rose.ItemType.Sulfuras;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

public class ItemTest {
    static {
        Profile.registerProfile(
                Item.class,
                "item",
                s -> s.withGenerateAttempts(10000)
                        .withExamples(100));
    }

    @Test
    public void suppliedQualityCannotBeNegative() {
        qt().withProfile(getClass(), "item")
                .forAll(genNumberInRange(1, 50),
                        genNumberInRange(1, 50),
                        genItemTypeIndex())
                .checkAssert((sellIn, quality, typeIndex) -> {
                    var type = ItemType.values()[typeIndex];
                    var negativeQuality = quality * -1;
                    assertThrows(IllegalArgumentException.class,
                            () -> new Item(type, sellIn, negativeQuality));
                });
    }

    @Test
    public void suppliedQualityNeverExceedsFifty() {
        qt().withProfile(getClass(), "item")
                .forAll(genNumberInRange(1, 50),
                        genNumberInRange(51, 100),
                        genItemTypeIndex())
                .checkAssert((sellIn, quality, typeIndex) -> {
                    var type = ItemType.values()[typeIndex];
                    assertThrows(IllegalArgumentException.class,
                            () -> new Item(type, sellIn, quality));
                });
    }

    @Test
    public void legendaryItemsNeverLoseQuality() {
        qt().withProfile(getClass(), "item")
                .forAll(genNumberInRange(1, 50),
                        genNumberInRange(1, 50))
                .check((sellIn, quality) -> {
                    var item = new Item(Sulfuras, sellIn, quality);
                    var days = sellIn * 2;
                    for (int i = 0; i < days; i++) {
                        item.endOfDay();
                    }
                    return item.quality() == quality;
                });

    }

    @Test
    public void qualityIsNeverNegative() {
        qt().withProfile(getClass(), "item")
                .forAll(genNumberInRange(1, 50),
                        genNumberInRange(1, 30),
                        genItemTypeIndex())
                .assuming((sellIn, quality, typeIndex) -> quality < sellIn)
                .check((sellIn, quality, typeIndex) -> {
                    var type = ItemType.values()[typeIndex];
                    var item = new Item(type, sellIn, quality);
                    var days = sellIn * 2;
                    for (int i = 0; i < days; i++) {
                        item.endOfDay();
                    }
                    return item.quality() >= 0;
                });

    }

    @Test
    public void qualityNeverExceedsFifty() {
        qt().withProfile(getClass(), "item")
                .forAll(genNumberInRange(11, 40),
                        genNumberInRange(40, 50),
                        genItemTypeIndex())
                .check((sellIn, quality, typeIndex) -> {
                    var type = ItemType.values()[typeIndex];
                    var item = new Item(type, sellIn, quality);
                    for (int i = sellIn; i >= 0; i--) {
                        item.endOfDay();
                    }
                    return item.quality() <= 50;
                });

    }

    private Gen<Integer> genItemTypeIndex() {
        return integers().from(0).upTo(ItemType.values().length);
    }

    private Gen<Integer> genNumberInRange(int startInclusive, int endExclusive) {
        return integers().from(startInclusive).upTo(endExclusive);
    }
}
