/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore.v2;

public class Movie {
    private final String title;
    private final PriceCode pricecode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.pricecode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    double cost(int daysRented) {
        return pricecode.cost(daysRented);
    }

    int points(int daysRented) {
        return pricecode.points(daysRented);
    }
}
