package interfaces.shared.methods;

public class Item {
    public Item(double price, String catalogId) {
        this.price = price;
        this.catalogId = catalogId;
    }

    public double getPrice() {
        return price;
    }

    public String getCatalogId() {
        return catalogId;
    }

    private double price;
    private String catalogId;
}
