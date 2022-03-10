/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore.v3;

public class Program {
    public static void main(String[] args) {
        var peterPan = new Movie("Peter Pan", PriceCode.CHILDRENS);
        var theHulk = new Movie("The Hulk", PriceCode.REGULAR);
        var starWars = new Movie("Star Wars", PriceCode.REGULAR);
        var toyStory = new Movie("Toy Story", PriceCode.CHILDRENS);
        var killBill = new Movie("Kill Bill", PriceCode.NEW_RELEASE);

        var r1 = new Rental(peterPan, 2);
        var r2 = new Rental(theHulk, 1);
        var r3 = new Rental(starWars, 3);
        var r4 = new Rental(toyStory, 2);
        var r5 = new Rental(killBill, 4);

        var customer = new Customer("Joe Bloggs");
        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);
        customer.addRental(r4);
        customer.addRental(r5);

        var statement = customer.statement();
        System.out.println(statement);
    }
}
