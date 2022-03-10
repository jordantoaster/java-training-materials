/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore;

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
}
