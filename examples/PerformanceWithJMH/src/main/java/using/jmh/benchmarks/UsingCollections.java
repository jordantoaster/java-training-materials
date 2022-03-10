package using.jmh.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.*;

import static java.lang.Math.random;

@State(Scope.Benchmark)
public class UsingCollections {
	private static final int NUM_REMOVALS = 1000;
	private static final int NUM_INSERTS = 1000;
	private static final int DATA_SOURCE_LENGTH = 100000;
	private static Double [] dataSource = buildDataSource(DATA_SOURCE_LENGTH);
	private static double sink;
	
	public LinkedList<Double> sampleLinkedList;
	public ArrayList<Double> sampleArrayList;
	
	@Setup(Level.Invocation)
	public void start() {
		sampleLinkedList = new LinkedList<>();
		sampleArrayList = new ArrayList<>();
		loadValuesIntoCollection(sampleArrayList);
		loadValuesIntoCollection(sampleLinkedList);
	}
	@Benchmark
	public void indexingIntoArrayList() {
		iterateItems(sampleArrayList);
	}
	@Benchmark
	public void indexingIntoLinkedList() {
		iterateItems(sampleLinkedList);
	}
	@Benchmark
	public void removingFromArrayList() {
		removeItemsFromStart(sampleArrayList);
	}
	@Benchmark
	public void removingFromLinkedList() {
		removeItemsFromStart(sampleLinkedList);
	}
	@Benchmark
	public void insertingIntoArrayList() {
		insertItemsAtStart(sampleArrayList);
	}
	@Benchmark
	public void insertingIntoLinkedList() {
		insertItemsAtStart(sampleLinkedList);
	}
	private void iterateItems(List<Double> testList) {
		for(int x=0;x<testList.size();x++) {
			sink = testList.get(x);
		}
	}
	private void removeItemsFromStart(List<Double> testList) {
		for(int x=0; x<NUM_REMOVALS;x++) {
			testList.remove(0);
		}
	}
	private void insertItemsAtStart(List<Double> testList) {
		for(int x=0; x<NUM_INSERTS;x++) {
			testList.add(0,new Double(random() * 100));
		}
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
