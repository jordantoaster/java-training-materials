package interfaces.extended;

public class ShopImpl implements Shop {
    public boolean makePurchase(Item[] items, CreditCard card) {
        printItems(items);
        return true;
    }

    public boolean makePurchase(Item[] items, Customer customer) {
        printItems(items);
        return true;
    }

    private void printItems(Item[] items) {
        System.out.println("Received order for:");
        for (Item i : items) {
            System.out.println("\t" + i.getCatalogId() + " costing " + i.getPrice());
        }
    }
}
