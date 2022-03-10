package interfaces.extended;

public interface Shop {
    class Item {
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

    double MIN_DISCOUNT_AMOUNT = 75.50;
    double MIN_PURCHASE_AMOUNT = ShopUtilities.minAmount();

    boolean makePurchase(Item[] items, CreditCard card);

    boolean makePurchase(Item[] items, Customer customer);
}
