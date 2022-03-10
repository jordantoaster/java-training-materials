package guilded.rose;

import java.util.function.BiFunction;

public enum ItemType {
    Regular(ItemType::regularPricing),
    AgedBrie((days, quality) -> quality == 50 ? 50 : quality + 1),
    Sulfuras((days, quality) -> quality),
    BackstagePass(ItemType::backstagePassPricing);

    private final BiFunction<Integer, Integer, Integer> action;

    ItemType(BiFunction<Integer, Integer, Integer> action) {
        this.action = action;
    }

    public int apply(int days, int quality) {
        return action.apply(days, quality);
    }

    private static int regularPricing(int days, int quality) {
        if (quality == 0) {
            return 0;
        } else if (days < 0) {
            return quality - 2;
        }
        return quality - 1;
    }

    private static int backstagePassPricing(int days, int quality) {
        if (days < 0) {
            return 0;
        } else if (days <= 5) {
            return quality + 3;
        } else if (days <= 10) {
            return quality + 2;
        }
        return quality + 1;
    }
}
