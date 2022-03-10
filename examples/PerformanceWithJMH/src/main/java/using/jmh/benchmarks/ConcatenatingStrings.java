package using.jmh.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import static java.lang.Math.random;

@State(Scope.Benchmark)
public class ConcatenatingStrings {
	private static final int DATA_SOURCE_LENGTH = 10000;
	private static String [] dataSource = buildDataSource(DATA_SOURCE_LENGTH);
	private static String sink;
	
	@Benchmark
	public void concatenateViaPlusOperator() {
		String result = "";
		for(int i=0;i<dataSource.length;i++) {
			result += dataSource[i];
		}
		sink = result;
	}
	@Benchmark
	public void concatenateViaMultipleStringBuffers() {
		String result = "";
		for(int i=0;i<dataSource.length;i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(result).append(dataSource[i]);
			result = buffer.toString();
		}
		sink = result.toString();
	}
	@Benchmark
	public void concatenateViaMultipleStringBuilders() {
		String result = "";
		for(int i=0;i<dataSource.length;i++) {
			StringBuilder builder = new StringBuilder();
			builder.append(result).append(dataSource[i]);
			result = builder.toString();
		}
		sink = result.toString();
	}
	@Benchmark
	public void concatenateViaSingleStringBuffer() {
		StringBuffer result = new StringBuffer();
		for(int i=0;i<dataSource.length;i++) {
			result.append(dataSource[i]);
		}
		sink = result.toString();
	}
	@Benchmark
	public void concatenateViaSingleStringBuilder() {
		StringBuilder result = new StringBuilder();
		for(int i=0;i<dataSource.length;i++) {
			result.append(dataSource[i]);
		}
		sink = result.toString();
	}
	private static String[] buildDataSource(int arraySize) {
		String [] dataSource = new String[arraySize];
		for(int i=0;i<dataSource.length;i++) {
			dataSource[i] = String.valueOf((int)(random() * 1000));
		}
		return dataSource;
	}
}
