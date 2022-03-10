package guilded.rose;

public class Item {
    private int sellIn;
    private int quality;
    private final ItemType type;

    public Item(ItemType type, int sellIn, int quality) {
        if (quality < 0) {
            throw new IllegalArgumentException("Quality cannot be negative");
        } else if (quality > 50) {
            throw new IllegalArgumentException("Quality cannot exceed fifty");
        }
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

    public Item(int sellIn, int quality) {
        this(ItemType.Regular, sellIn, quality);
    }

    public int quality() {
        return quality;
    }

    public void endOfDay() {
        //Use -1 to signify expired
        if (sellIn >= 0) {
            sellIn--;
        }
        quality = type.apply(sellIn, quality);
    }
}
