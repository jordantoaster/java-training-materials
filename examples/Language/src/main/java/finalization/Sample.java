package finalization;

public class Sample {
    private int arrayIndex;
    private int boxIndex;

    public Sample(int arrayIndex, int boxIndex) {
        super();    //good habit - will be inserted if absent
        this.arrayIndex = arrayIndex;
        this.boxIndex = boxIndex;
    }

    protected void finalize() throws Throwable {
        super.finalize();    //very good habit - will NOT be inserted if absent
        System.out.println("Finalize called for object in array " + arrayIndex + " and box " + boxIndex);

        //re-release resources here that cannot be garbage collected - just in case...

        //this method is only called ONCE i.e.
        //	throwing an exception postpones GC once
        //	resurrecting an object here only works once
    }
}
