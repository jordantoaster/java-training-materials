package using.jmh.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.lang.Math.random;

@State(Scope.Benchmark)
public class FunctionalCollections {
	private static final int DATA_SOURCE_LENGTH = 100000;
	private static Double [] objectDataSource;
	private static double [] primitiveDataSource;
	private static double primitiveSink;
	private static Double objectSink;
	private static List<Double> listSink;
	
	public Stream<Double> sampleObjectStream;
	public DoubleStream samplePrimitiveStream;
	
	static {
		buildDataSources(DATA_SOURCE_LENGTH);
	}
	@Setup(Level.Invocation)
	public void start() {
		samplePrimitiveStream = DoubleStream.of(primitiveDataSource);
		sampleObjectStream = Stream.of(objectDataSource);
	}
	@Benchmark
	public void standardLoopOverArrayOfPrimitives() {
		for(int x=0;x<primitiveDataSource.length;x++) {
			primitiveSink = primitiveDataSource[x];
		}
	}
	@Benchmark
	public void standardLoopOverArrayOfObjects() {
		for(int x=0;x<objectDataSource.length;x++) {
			objectSink = objectDataSource[x];
		}
	}
	@Benchmark
	public void mappingPrimitivesWithoutBoxing() {
		samplePrimitiveStream.forEach(d -> primitiveSink = d);
	}
	@Benchmark
	public void mappingObjectsWithoutUnboxing() {
		sampleObjectStream.forEach(d -> objectSink = d);
	}
	@Benchmark
	public void mappingWithBoxing() {
		samplePrimitiveStream.forEach(d -> objectSink = d);
	}
	@Benchmark
	public void mappingWithUnBoxing() {
		sampleObjectStream.forEach(d -> primitiveSink = d);
	}
	@Benchmark
	public void sampleTaskWithPrimitiveStream() {
		primitiveSink = samplePrimitiveStream.filter(d -> d > 0.5)
							 		 		 .map(d -> d * 2)
							 		 		 .sum();
	}
	@Benchmark
	public void sampleTaskWithObjectStream() {
		objectSink = sampleObjectStream.filter(d -> d > 0.5)
							 	  	   .map(d -> d * 2)
							 	  	   .collect(Collectors.summingDouble(d -> d));
	}
	@Benchmark
	public void gatheringResultsWithForEach() {
		List<Double> results = new ArrayList<>();
		sampleObjectStream.filter(d -> d > 0.5)
						  .map(d -> d * 2)
						  .forEach(results::add);
		listSink = results;
	}
	@Benchmark
	public void gatheringResultsWithCollect() {
		List<Double> results;
		results = sampleObjectStream.filter(d -> d > 0.5)
						  		    .map(d -> d * 2)
						  		    .collect(Collectors.toList());
		listSink = results;
	}
	private static void buildDataSources(int arraySize) {
		objectDataSource = new Double[arraySize];
		primitiveDataSource = new double[arraySize];
		for(int i=0;i<arraySize;i++) {
			double tmp = random() * 100;
			objectDataSource[i] = new Double(tmp);
			primitiveDataSource[i] = tmp;
		}
	}
}
