package reflection.parameters;

import java.util.Date;
import java.util.List;

public enum Colors {
    RED,
    GREEN,
    BLUE;

    public void foo(int ival, double dval) {
    }

    public void bar(String what, Date when) {
    }

    public void zed(List<String> things, Date... otherThings) {
    }
}
