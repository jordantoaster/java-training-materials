/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore.v1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

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
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.cost();
        }
        return totalAmount;
    }

    private int totalPoints() {
        int points = 0;
        for (Rental rental : rentals) {
            points += rental.points();
        }
        return points;
    }

    public String statement() {
        StringBuilder result = new StringBuilder();
        // add header lines
        result.append("\nRental Record for ");
        result.append(getName());
        result.append("\n");
        for (Rental rental : rentals) {
            // show figures for this rental
            result.append("\t");
            result.append(rental.getDaysRented());
            result.append("\t");
            result.append(rental.getMovie().getTitle());
            result.append("\t");
            result.append(rental.cost());
            result.append("\n");
        }
        // add footer lines
        result.append("Amount owed is ");
        result.append(totalCost());
        result.append("\n");
        result.append("You earned ");
        result.append(totalPoints());
        result.append(" frequent renter points\n");
        return result.toString();
    }
}
