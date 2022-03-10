package cloning;

public class Program {
    public static void main(String[] args) {
        try {
            Shallow shallowOriginal = new Shallow("abcdefg");
            Shallow shallowCopy = (Shallow) shallowOriginal.clone();

            shallowOriginal.change("hijklmnop");

            System.out.println("Shallow original holds: " + shallowOriginal);
            System.out.println("Shallow copy holds: " + shallowCopy);

            Deep deepOriginal = new Deep("abcdefg");
            Deep deepCopy = (Deep) deepOriginal.clone();

            deepOriginal.change("hijklmnop");

            System.out.println("Deep original holds: " + deepOriginal);
            System.out.println("Deep copy holds: " + deepCopy);

        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}






