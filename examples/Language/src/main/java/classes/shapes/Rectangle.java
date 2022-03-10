package classes.shapes;

/*
	A class to represent a Rectangle
*/
public class Rectangle extends Shape {
    //The length of the rectangle
    private int length;
    //The height of the rectangle
    private int height;

    //The only constructor of the class
    public Rectangle(String title, int length, int height) {
        //Call the super class constructor
        // to save the title in the top layer
        super(title);
        //Save the length and height in the object
        // using the 'this' operator to resolve scope
        this.length = length;
        this.height = height;
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
        for (int i = 0; i < length; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    private void drawMiddle() {
        //Draw the sides
        int verticalDistance = height - 2;
        int horizontalDistance = length - 2;

        //For each row required
        for (int i = 0; i < verticalDistance; i++) {
            //Print the row
            System.out.print("#");
            for (int x = 0; x < horizontalDistance; x++) {
                System.out.print(" ");
            }
            System.out.println("#");
        }
    }
}