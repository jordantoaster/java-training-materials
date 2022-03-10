package classes;

import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) {
        standardSolution();
        System.out.println("-------------");
        functionalSolution();
    }

    private static void functionalSolution() {
        FpStudent s1 = new FpStudent("Joe Bloggs", "Philosophy", 3, new double[]{65.4, 66.5, 72.2});
        FpStudent s2 = new FpStudent("Jane Smith", "Architecture", 2, new double[]{56.4, 68.7});

        DecimalFormat df = new DecimalFormat(".00");
        System.out.println(s1);
        System.out.println("\t With current average of: " + df.format(s1.average()));
        System.out.println(s2);
        System.out.println("\t With current average of: " + df.format(s2.average()));
    }

    private static void standardSolution() {
        Student s1 = new Student("Joe Bloggs", "Philosophy", 3, new double[]{65.4, 66.5, 72.2});
        Student s2 = new Student("Jane Smith", "Architecture", 2, new double[]{56.4, 68.7});

        DecimalFormat df = new DecimalFormat(".00");
        System.out.println(s1);
        System.out.println("\t With current average of: " + df.format(s1.average()));
        System.out.println(s2);
        System.out.println("\t With current average of: " + df.format(s2.average()));
    }
}
