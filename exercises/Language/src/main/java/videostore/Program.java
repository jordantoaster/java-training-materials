/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore;

public class Program {
    public static void main(String[] args) {
        Movie peterPan = new Movie("Peter Pan", PriceCode.CHILDRENS);
        Movie theHulk = new Movie("The Hulk", PriceCode.REGULAR);
        Movie starWars = new Movie("Star Wars", PriceCode.REGULAR);
        Movie toyStory = new Movie("Toy Story", PriceCode.CHILDRENS);
        Movie killBill = new Movie("Kill Bill", PriceCode.NEW_RELEASE);
        Rental r1 = new Rental(peterPan, 2);
        Rental r2 = new Rental(theHulk, 1);
        Rental r3 = new Rental(starWars, 3);
        Rental r4 = new Rental(toyStory, 2);
        Rental r5 = new Rental(killBill, 4);
        Customer customer = new Customer("Joe Bloggs");
        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);
        customer.addRental(r4);
        customer.addRental(r5);
        System.out.println(customer.statement());
    }
}
