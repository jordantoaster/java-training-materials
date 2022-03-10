package classes.shapes;

/*
	This is a base class for all the different types of shape

	We need a base class because:
	  1)  We want to hold shared data (the title) in one
	  		 place to avoid duplicating code
	  2)  We need to have a 'slot' on the front of the
	  		 object for the draw method, so clients can
	  		 access derived objects (e.g. Square) via
	  		 references of type Shape

	 We make the class abstract so that clients can
	   never say 'new Shape("TITLE")'

	 We make the draw method abstract because there
	   is no useful implementation at the base class level
*/
public abstract class Shape {
	//All shapes have a title
	protected String title;
	//Constructor to be called by derived classes
	public Shape(String title) {
		this.title = title;
	}
	//The 'slot' for the draw method
	public abstract void draw();
}