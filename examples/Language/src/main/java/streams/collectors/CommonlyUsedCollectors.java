package streams.collectors;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class CommonlyUsedCollectors {
	private static  Stream<String> sample() {
		return Stream.of("ab","cde","fghi","jk","lmn","opqr","st","uvw","xyz");
	}
	public static void main(String [] args) {
		System.out.println("Count is:\t" + sample().collect(counting()));
		System.out.println("Joining gives:\t" + sample().collect(joining()));
		System.out.println("Average gives:\t" + sample().collect(averagingDouble(String::length)));
		System.out.println("Summing gives:\t" + sample().collect(summingInt(String::length)));
		
		Map<Integer,List<String>> groups = sample().collect(groupingBy(String::length));
		System.out.println("Grouping gives:");
		for(int key : groups.keySet()) {
			System.out.printf("\t%d indexes ", key);
			for(String value : groups.get(key)) {
				System.out.printf(" %s", value);
			}
			System.out.println();
		}
		
		List<String> list1 = sample().collect(toList());
		Set<String> set1 = sample().collect(toSet());
		List<String> list2 = sample().collect(toCollection(LinkedList::new));
		Set<String> set2 = sample().collect(toCollection(TreeSet::new));
		
		System.out.println(list1.getClass().getName());
		System.out.println(list2.getClass().getName());
		System.out.println(set1.getClass().getName());
		System.out.println(set2.getClass().getName());
	}
}
