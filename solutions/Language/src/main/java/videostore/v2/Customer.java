/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore.v2;

import java.util.ArrayList;
import java.util.List;

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
        StringBuilder result = new StringBuilder();
        addHeaderLine(result);
        rentals.forEach(rental -> addRentalLine(result, rental));
        addFooterLines(result);
        return result.toString();
    }

    private void addFooterLines(StringBuilder result) {
        result.append("Amount owed is ");
        result.append(totalCost());
        result.append("\n");
        result.append("You earned ");
        result.append(totalPoints());
        result.append(" frequent renter points\n");
    }

    private void addRentalLine(StringBuilder result, Rental rental) {
        result.append("\t");
        result.append(rental.getDaysRented());
        result.append("\t");
        result.append(rental.getMovie().getTitle());
        result.append("\t");
        result.append(rental.cost());
        result.append("\n");
    }

    private void addHeaderLine(StringBuilder result) {
        result.append("\nRental Record for ");
        result.append(getName());
        result.append("\n");
    }
}
