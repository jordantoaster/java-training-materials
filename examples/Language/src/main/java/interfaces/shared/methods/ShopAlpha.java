package interfaces.shared.methods;

import static interfaces.shared.methods.Weekdays.Monday;
import static interfaces.shared.methods.Weekdays.Thursday;

public class ShopAlpha implements Shop {
    @Override
    public boolean makePurchase(Item[] items, CreditCard card) {
        return false;
    }

    @Override
    public boolean makePurchase(Item[] items, Customer customer) {
        return false;
    }

    @Override
    public boolean offersDiscountOn(Weekdays day) {
        return (day == Monday) || (day == Thursday);
    }
}
