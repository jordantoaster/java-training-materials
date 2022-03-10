package serialization.basic;

import java.io.Serializable;

@SuppressWarnings("serial")
class Test implements Serializable {
	private float f;
	private int i;
	private char c;
	private String s;

	public Test(float f,int i, char c, String s) {
		super();
		this.f = f;
		this.i = i;
		this.c = c;
		this.s = s;
	}
	public String toString() {
		return "Data is " + f + " " + i + " " + c + " " + s;
	}
}