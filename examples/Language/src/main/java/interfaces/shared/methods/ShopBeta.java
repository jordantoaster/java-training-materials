package interfaces.shared.methods;

public class ShopBeta implements Shop {
    @Override
    public boolean makePurchase(Item[] items, CreditCard card) {
        return false;
    }

    @Override
    public boolean makePurchase(Item[] items, Customer customer) {
        return false;
    }
}
