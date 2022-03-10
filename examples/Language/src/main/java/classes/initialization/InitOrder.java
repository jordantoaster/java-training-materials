package classes.initialization;

public class InitOrder extends InitBase {
    public InitOrder() {
		super();
		System.out.println("InitOrder - Derived constructor");
	}

	static {
		System.out.println("InitOrder - static initializer one");
	}

	static {
		System.out.println("InitOrder - static initializer two");
	}

	{
		System.out.println("InitOrder - initializer one");
	}

	{
		System.out.println("InitOrder - initializer two");
	}
}
