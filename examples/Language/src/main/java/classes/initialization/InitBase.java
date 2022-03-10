package classes.initialization;

public class InitBase {
	public InitBase() {
		super();
		System.out.println("InitBase - constructor");
	}

	static {
		System.out.println("InitBase - static initializer one");
	}

	static {
		System.out.println("InitBase - static initializer two");
	}

	{
		System.out.println("InitBase - initializer one");
	}

	{
		System.out.println("InitBase - initializer two");
	}
}
