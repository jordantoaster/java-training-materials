package using.jmh.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import java.util.*;

import static java.lang.Math.random;

@State(Scope.Benchmark)
public class PopulatingCollections {
	private static final int DATA_SOURCE_LENGTH = 10000;
	private static Double [] dataSource = buildDataSource(DATA_SOURCE_LENGTH);
	public static List<Double> sink;
	
	@Benchmark
	public void addingToBadlySizedArrayList() {
		ArrayList<Double> testList = new ArrayList<>();
		loadValuesIntoCollection(testList);
		sink = testList;
	}
	@Benchmark
	public void addingToProperlySizedArrayList() {
		ArrayList<Double> testList = new ArrayList<>(DATA_SOURCE_LENGTH / 2);
		loadValuesIntoCollection(testList);
		sink = testList;
	}
	@Benchmark
	public void addingToLinkedList() {
		LinkedList<Double> testList = new LinkedList<>();
		loadValuesIntoCollection(testList);
		sink = testList;
	}
	private void loadValuesIntoCollection(List<Double> theList) {
		for(double d : dataSource) {
			theList.add(d);
		}
	}
	private static Double[] buildDataSource(int arraySize) {
		Double [] dataSource = new Double[arraySize];
		for(int i=0;i<dataSource.length;i++) {
			dataSource[i] = new Double(random() * 100);
		}
		return dataSource;
	}
}
