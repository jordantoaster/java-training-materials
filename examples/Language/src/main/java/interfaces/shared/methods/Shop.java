package interfaces.shared.methods;

import java.util.stream.Stream;

public interface Shop {
    static Stream<Weekdays> daysOfferingDiscount(Shop s) {
        return Stream.of(s.openDays())
                .filter(s::offersDiscountOn);
    }

    default Weekdays[] openDays() {
        return Weekdays.values();
    }

    default boolean offersDiscountOn(Weekdays day) {
        return true;
    }

    boolean makePurchase(Item[] items, CreditCard card);

    boolean makePurchase(Item[] items, Customer customer);
}
