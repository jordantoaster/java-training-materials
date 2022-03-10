/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore.v2;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double cost() {
        return movie.cost(daysRented);
    }

    int points() {
        return movie.points(daysRented);
    }
}
