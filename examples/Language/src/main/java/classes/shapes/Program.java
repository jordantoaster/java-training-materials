package classes.shapes;

public class Program {
    //Entry point for our application
    public static void main(String[] args) {
        testShapesOne();
        testShapesTwo();
    }

    //Draw each of the shapes in an array. The apparent type
    // of each object is Shape, but the actual type could be
    // any class that inherits from Shape
    private static void printAllShapes(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
    }

    //Build a test array of different shapes
    private static void testShapesOne() {
        Shape[] testData = new Shape[6];

        testData[0] = new Square("SQUARE ONE", 5);
        testData[1] = new Square("SQUARE TWO", 10);
        testData[2] = new Rectangle("RECTANGLE ONE", 10, 5);
        testData[3] = new Rectangle("RECTANGLE TWO", 8, 4);
        testData[4] = new Square("SQUARE THREE", 5);
        testData[5] = new Square("SQUARE FOUR", 10);

        printAllShapes(testData);
    }

    //Same as 'testShapesOne' but using a more concise
    // way of declaring the array of shapes
    private static void testShapesTwo() {
        Shape[] testData = new Shape[]{
                new Square("SQUARE ONE", 5),
                new Square("SQUARE TWO", 10),
                new Rectangle("RECTANGLE ONE", 10, 5),
                new Rectangle("RECTANGLE TWO", 8, 4),
                new Square("SQUARE THREE", 5),
                new Square("SQUARE FOUR", 10)
        };

        printAllShapes(testData);
    }
}