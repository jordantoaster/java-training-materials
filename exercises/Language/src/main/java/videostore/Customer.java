/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore;

import java.util.ArrayList;
import java.util.List;

import static videostore.PriceCode.NEW_RELEASE;

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

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();
        //add header lines
        result.append("\nRental Record for ");
        result.append(getName());
        result.append("\n");
        for (Rental each : rentals) {
            double thisAmount = 0;
            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == NEW_RELEASE)
                    && each.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            result.append("\t");
            result.append(each.getDaysRented());
            result.append("\t");
            result.append(each.getMovie().getTitle());
            result.append("\t");
            result.append(thisAmount);
            result.append("\n");
            //add cost of this rental to total cost
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ");
        result.append(totalAmount);
        result.append("\n");
        result.append("You earned ");
        result.append(frequentRenterPoints);
        result.append(" frequent renter points\n");
        return result.toString();
    }
}
