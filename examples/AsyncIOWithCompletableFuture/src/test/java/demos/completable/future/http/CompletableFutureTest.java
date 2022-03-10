package demos.completable.future.http;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompletableFutureTest {
	private AsyncHttpClient client;

	@BeforeEach
	public void start() {
		client = Dsl.asyncHttpClient();
	}

	@AfterEach
	public void end() throws IOException {
		client.close();
	}

	@Test
	public void showBasicUsage() throws InterruptedException, java.util.concurrent.ExecutionException {
		CompletableFuture<Response> future = callPing(client, 2);
		String result = future.get().getResponseBody();
		assertEquals("Pingback after 2", result);
	}

	@Test
	public void showApply() throws InterruptedException, java.util.concurrent.ExecutionException {
		CompletableFuture<String> result = callPing(client, 3)
				.thenApply(this::buildResult);
		assertEquals("Pingback after 3", result.get());
	}

	@Test
	public void showAccept() throws InterruptedException, java.util.concurrent.ExecutionException {
		CompletableFuture<Void> result = callPing(client, 4)
				.thenApply(this::buildResult)
				.thenAccept(str -> assertEquals("Pingback after 4", str));
		result.get();
	}

	@Test
	public void showAcceptEither() throws InterruptedException, java.util.concurrent.ExecutionException {
		CompletableFuture<Void> result = callPing(client, 4)
				.acceptEither(callPing(client, 3),
						resp -> assertEquals("Pingback after 3", buildResult(resp)));
		result.get();
	}

	@Test
	public void showRun() throws InterruptedException, java.util.concurrent.ExecutionException {
		CompletableFuture<Void> result = callPing(client, 5)
				.thenApply(this::buildResult)
				.thenAccept(str -> assertEquals("Pingback after 5", str))
				.thenRun(() -> System.out.println("\tDone!"));
		result.get();
	}

	@Test
	public void showCompose() throws InterruptedException, java.util.concurrent.ExecutionException {
		Function<Response, CompletableFuture<Response>> plus = resp -> {
			int num = Integer.parseInt(resp.getResponseBody());
			return callPlus(client, num);
		};

		Function<Response, CompletableFuture<Response>> ping = resp -> {
			int num = Integer.parseInt(resp.getResponseBody());
			return callPing(client, num);
		};

		CompletableFuture<Void> result = callPlus(client, 1)
				.thenCompose(plus)
				.thenCompose(plus)
				.thenCompose(ping)
				.thenApply(this::buildResult)
				.thenAccept(str -> assertEquals("Pingback after 4", str));
		result.get();
	}

	@Test
	public void showAllOf() throws InterruptedException, java.util.concurrent.ExecutionException {
		Function<Integer, CompletableFuture<String>> ping = num -> callPing(client, num)
				.thenApply(this::buildResult);

		CompletableFuture<String> result1 = ping.apply(3);
		CompletableFuture<String> result2 = ping.apply(4);
		CompletableFuture<String> result3 = ping.apply(5);

		CompletableFuture<Void> results = CompletableFuture.allOf(result1, result2, result3);
		results.get();

		assertEquals("Pingback after 3", result1.get());
		assertEquals("Pingback after 4", result2.get());
		assertEquals("Pingback after 5", result3.get());
	}

	private CompletableFuture<Response> callPing(AsyncHttpClient client, int timeout) {
		String url = String.format("http://localhost:8080/ping/%s", timeout);
		return client
				.prepareGet(url)
				.execute()
				.toCompletableFuture();
	}

	private CompletableFuture<Response> callPlus(AsyncHttpClient client, int value) {
		String url = String.format("http://localhost:8080/plus/%s", value);
		return client
				.prepareGet(url)
				.execute()
				.toCompletableFuture();
	}

	private String buildResult(Response result) {
		return result.getResponseBody();
	}
}
