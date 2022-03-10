package cloning;

class Shallow implements Cloneable {
    private StringBuffer buffer;

    Shallow(String s) {
        super();
        buffer = new StringBuffer(s);
    }

    public void change(String str) {
        buffer.append(str);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return buffer.toString();
    }
}
