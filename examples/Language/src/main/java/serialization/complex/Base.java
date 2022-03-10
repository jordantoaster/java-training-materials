package serialization.complex;

//NB does not implement Serializable
class Base {
	Base() {
		super();
		System.out.println("Base.Base");
	}
	Base(int i,float f, double d){
		this();
		this.i = i;
		this.f = f;
		this.d = d;
	}
	int i;
	double d;
	float f;
}
