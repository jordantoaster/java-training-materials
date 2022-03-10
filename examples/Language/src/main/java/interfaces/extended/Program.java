package interfaces.extended;

public class Program {
    public static void main(String[] args) {
        Shop.Item[] items = {
                new Shop.Item(12.34, "abc"),
                new Shop.Item(56.78, "def"),
                new Shop.Item(90.12, "ghi")
        };

        Shop s = new ShopImpl();
        s.makePurchase(items, new CreditCard());
        s.makePurchase(items, new Customer());
    }

}
