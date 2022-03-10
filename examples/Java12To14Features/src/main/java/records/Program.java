package records;

import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        Item item1 = new Item("AB12", 20, 3.40);
        Item item2 = new Item("AB12", 20, 3.40);

        System.out.println(item1 == item2);
        System.out.println(item1.equals(item2));
        System.out.println(item1.catalogNum());

        try {
            new Item("AB12", 0, 3.40);
        } catch(Exception ex) {
            System.out.println("Cannot create item with no quantity:");
            System.out.printf("\t%s\n", ex.getMessage());
        }

        Optional<Item> item3 = Item.parse("CD34:17:4.50");
        item3.ifPresent(System.out::println);
    }
}
