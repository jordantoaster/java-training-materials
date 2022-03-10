/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore.v1;

public class Movie {
    private String title;
    private PriceCode pricecode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.pricecode = priceCode;
    }

    public PriceCode getPriceCode() {
        return pricecode;
    }

    public void setPriceCode(PriceCode arg) {
        pricecode = arg;
    }

    public String getTitle() {
        return title;
    }

    double cost(int daysRented) {
        double cost = 0;
        switch (pricecode) {
            case REGULAR:
                cost += 2;
                if (daysRented > 2)
                    cost += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                cost += daysRented * 3;
                break;
            case CHILDRENS:
                cost += 1.5;
                if (daysRented > 3)
                    cost += (daysRented - 3) * 1.5;
                break;
        }
        return cost;
    }

    int points(int daysRented) {
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((pricecode == PriceCode.NEW_RELEASE)
                && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
