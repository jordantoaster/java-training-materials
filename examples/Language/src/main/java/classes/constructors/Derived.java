package classes.constructors;

public class Derived extends Base {
    //Fields
    String derivedFieldOne;
    String derivedFieldTwo;

    //Calls Base();
    public Derived() {
        super();
    }

    //Calls Base(String)
    public Derived(String p1) {
        super(p1);
    }

    //Reuse existing constructors
    public Derived(String p1, String p2) {
        this(p1);
        derivedFieldOne = p2;
    }

    //Reuse existing constructors
    public Derived(String p1, String p2, String p3) {
        this(p1, p2);
        derivedFieldTwo = p3;
    }

    //We have hidden Base.foo but can access it via super
    int foo() {
        return super.foo();
    }

    public String toString() {
        return "baseFieldOne is: " + baseFieldOne
                + "\nderivedFieldOne is: " + derivedFieldOne
                + "\nderivedFieldTwo is: " + derivedFieldTwo
                + "\n";
    }
}
