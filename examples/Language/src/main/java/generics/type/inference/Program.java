package generics.type.inference;

import java.util.ArrayList;
import java.util.List;

class ThingHolder<T> {
	public ThingHolder(T item) {
		things = new ArrayList<T>();
		things.add(item);
	}
	@SuppressWarnings("unchecked")
	public <Z> List<Z> fetchFirst() {
		return func();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List func() {
		List tmp = new ArrayList();
		tmp.add(things.get(0));
		return tmp;
	}
	private List<T> things;
}

public class Program {
	public static void main(String[] args) {
		ThingHolder<String> th = new ThingHolder<>("wibble");
		
		List<String> myList = new ArrayList<>();
		myList.addAll(th.<String>fetchFirst());  //required in Java 7
		myList.addAll(th.fetchFirst());          //compiles in Java 8
	}
}
