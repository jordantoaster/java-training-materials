package enumerations;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        listEnumValues();
        listEnumValuesWithOrdinals();
        demoExtraMethod();
        showStringConversion();
        showUserDefinedConstructor();
        showConstantSpecificBehaviour();
    }

    private static void showStringConversion() throws IOException {
        String input = "WEST";
        Direction d = Direction.valueOf(input);
        d.print();
    }

    private static void demoExtraMethod() {
        Direction d1 = Direction.NORTH;
        Direction d2 = Direction.WEST;
        Direction d3 = Direction.EAST;
        Direction d4 = Direction.SOUTH;

        d1.print();
        d2.print();
        d3.print();
        d4.print();
    }

    private static void listEnumValues() {
        System.out.println("\nValues of Direction are:");
        for (Direction d : Direction.values()) {
            System.out.println("\t" + d);
        }
        System.out.println("\nValues of Shape are:");
        for (Shape s : Shape.values()) {
            System.out.println("\t" + s);
        }
    }

    private static void listEnumValuesWithOrdinals() {
        System.out.println("\nValues of Direction are:");
        for (Direction d : Direction.values()) {
            System.out.println("\t" + d + " (" + d.ordinal() + ")");
        }
        System.out.println("\nValues of Shape are:");
        for (Shape s : Shape.values()) {
            System.out.println("\t" + s + " (" + s.ordinal() + ")");
        }
    }

    private static void showUserDefinedConstructor() {
        System.out.println("\nDescriptions of game types are:");
        for (GameType g : GameType.values()) {
            System.out.println("\t" + g + "-->" + g.description());
        }

    }

    private static void showConstantSpecificBehaviour() {
        System.out.println("\nDescriptions of movie types are:");
        for (MovieType m : MovieType.values()) {
            System.out.println("\t" + m + "-->" + m.description());
        }
    }

}
