package classes.constructors;

//All java objects have a common superclass 'Object'
// the declaration below is equivalent to 'class Base extends Object'
class Base {
    //Fields
    String baseFieldOne;

    //The default constructor is written by the compiler
    // if no constructors are present in the class
    public Base() {
        super();
    }

    //First line of constructor must call superclass
    // or another constructor (default call inserted)
    public Base(String p1) {
        baseFieldOne = p1;
    }

    int foo() {
        return 1;
    }

}
