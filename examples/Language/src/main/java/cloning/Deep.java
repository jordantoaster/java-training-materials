package cloning;

class Deep implements Cloneable {
    private StringBuffer buffer;

    Deep(String s) {
        super();
        buffer = new StringBuffer(s);
    }

    public void change(String str) {
        buffer.append(str);
    }

    protected Object clone() throws CloneNotSupportedException {
        Deep myclone = (Deep) super.clone();
        myclone.buffer = new StringBuffer(buffer.toString());
        return myclone;
    }

    public String toString() {
        return buffer.toString();
    }
}
