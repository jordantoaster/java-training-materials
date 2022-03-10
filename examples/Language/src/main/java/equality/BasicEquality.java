package equality;

import java.time.LocalDate;

public class BasicEquality {
    public static void main(String[] args) {
        int value1 = 123;
        int value2 = 123;
        LocalDate value3 = LocalDate.of(2020, 12, 31);
        LocalDate value4 = LocalDate.of(2020,12, 31);

        if(value1 == value2) {
            System.out.println("Value types equal");
        } else {
            System.out.println("Value types not equal");
        }

        if(value3 == value4) {
            System.out.println("Reference types equal");
        } else {
            System.out.println("Reference types not equal");
        }
    }
}
