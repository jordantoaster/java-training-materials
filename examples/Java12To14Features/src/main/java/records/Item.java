package records;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public record Item(String catalogNum,
                   int quantity,
                   double unitPrice) {

    public Item {
        if(quantity < 1) {
            throw new IllegalStateException("Quantity must be positive!");
        }
    }

    public static Optional<Item> parse(String input) {
        Pattern p = Pattern.compile("([A-Z0-9]+)\\:([0-9]+)\\:([0-9\\.]+)");
        Matcher m = p.matcher(input);
        try {
            if (m.matches()) {
                String num = m.group(1);
                int quantity = parseInt(m.group(2));
                double price = parseDouble(m.group(3));
                return Optional.of(new Item(num, quantity, price));
            }
        } catch(NumberFormatException ex) {
            throw new IllegalStateException("Item string incorrect: " + ex.getMessage());
        }
        return Optional.empty();
    }
}
