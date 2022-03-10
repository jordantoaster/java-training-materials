package classes.shapes;

/*
	A class to represent a Square
*/
public class Square extends Shape {
    //The size of each side
    private int size;

    //The only constructor of the class
    public Square(String title, int size) {
        //Call the super class constructor
        // to save the title in the top layer
        super(title);
        //Save the size in the object using
        // the 'this' operator to resolve scope
        this.size = size;
    }

    //Override the draw method of the base
    // class i.e. make the 'draw' slot in the layer
    // above refer to the code in this method
    public void draw() {
        System.out.println(title);    //print the title
        drawTopOrBottom();            //print the top
        drawMiddle();                //print the sides
        drawTopOrBottom();            //print the bottom
    }

    private void drawTopOrBottom() {
        for (int i = 0; i < size; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    private void drawMiddle() {
        //Draw the sides
        int distance = size - 2;

        //For each row required
        for (int i = 0; i < distance; i++) {
            //Print the row
            System.out.print("#");
            for (int x = 0; x < distance; x++) {
                System.out.print(" ");
            }
            System.out.println("#");
        }
    }
}