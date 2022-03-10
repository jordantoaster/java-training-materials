package streams.collectors;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.stream.Stream;

public class IntroducingCollect {
	public static void main(String[] args) {
		List<String> items = asList("ab","cde","fg","hij","kl","mno");
		List<String> results1 = new ArrayList<>();
		
		withoutCollect(items.stream(), results1);
		List<String> results2 = withCollect(items.stream());

		//just for demo
		results1.forEach(System.out::println);
		results2.forEach(System.out::println);
	}
	private static void withoutCollect(Stream<String> stream, List<String> results1) {
		stream.filter(s -> s.length() == 3).forEach(results1::add);
	}
	private static List<String> withCollect(Stream<String> stream) {
		return stream.filter(s -> s.length() == 3).collect(toList());
	}
}
