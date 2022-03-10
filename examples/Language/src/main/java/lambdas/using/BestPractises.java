package lambdas.using;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class BestPractises {
	public static void main(String [] args) {
		doThing(new Callable<String>(){							//bad
					public String call() throws Exception {
						return "porthos";
					}	
				},
				new Consumer<Exception>(){
					public void accept(Exception ex) {
						System.err.println(ex);
					}
				});
		doThing(() -> "athos", ex -> System.err.println(ex));	//better
		doThing(() -> "aramis", System.err::println);			//disco
	}

	public static void doThing(Callable<String> input, Consumer<Exception> handler) {
		try {
			System.out.println(input.call());
		} catch (Exception e) {
			handler.accept(e);
		}
	}
}
