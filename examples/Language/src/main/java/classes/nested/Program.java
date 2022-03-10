package classes.nested;

public class Program {
    public static void main(String[] args) {
        Outer.InnerOne innerOne = new Outer().new InnerOne();
        Outer.InnerTwo innerTwo = new Outer.InnerTwo();
        System.out.println(innerOne);
        System.out.println(innerTwo);
    }
}
