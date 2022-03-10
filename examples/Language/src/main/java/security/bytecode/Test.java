package security.bytecode;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Test extends Object implements Cloneable, Serializable {

	public void foo() {}
	public int bar() { return 7; }
}
