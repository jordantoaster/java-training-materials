package serialization.complex;

import java.io.*;


//Extends non-serializable class. Base fields must be serialized manually
class Derived extends Base implements Serializable {
    static final long serialVersionUID = 12345L;

    Derived(int i, float f, double d) {
        super(i, f, d);
    }

    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
        output.writeInt(i);
        output.writeFloat(f);
        output.writeDouble(d);
    }

    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        i = input.readInt();
        f = input.readFloat();
        d = input.readDouble();
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("Derived::writeReplace");
        return this;
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("Derived::readResolve");
        return this;
    }

    public String toString() {
        return "Derived object with values: " + i + " " + f + " " + d;
    }
}
