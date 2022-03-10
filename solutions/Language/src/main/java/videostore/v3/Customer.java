/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore.v3;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    private double totalCost() {
        return rentals.stream()
                .mapToDouble(Rental::cost)
                .sum();
    }

    private int totalPoints() {
        return rentals.stream()
                .mapToInt(Rental::points)
                .sum();
    }

    public String statement() {
        return headerLine() + rentalLines() + footerLines();
    }

    private String rentalLines() {
        StringBuilder result = new StringBuilder();

        rentals.forEach(rental -> {
            var line = format(
                    "\t%d\t%s\t%.2f\n",
                    rental.getDaysRented(),
                    rental.getMovie().getTitle(),
                    rental.cost()
            );
            result.append(line);
        });

        return result.toString();
    }

    private String headerLine() {
        return format("\nRental Record for %s\n", getName());
    }

    private String footerLines() {
        var footer1 = format("Amount owed is %.2f\n", totalCost());
        var footer2 = format("You earned %d frequent renter points\n", totalPoints());

        return footer1 + footer2;
    }
}
