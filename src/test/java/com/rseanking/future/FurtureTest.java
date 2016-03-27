package com.rseanking.future;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


import org.junit.Test;

public class FurtureTest {

	@Test
	public void shouldProvideResultsForAsynchronousCall() throws Exception {
		// Given
		final String expectedMessage =
				"Hello World!";
		final ExecutorService executor = Executors.newFixedThreadPool(1);
		
		Future<String> futureMessage = executor.submit(() -> {
			Thread.sleep(4000L);
			return expectedMessage;
		});
		
		// When
		final String message = futureMessage.get();

		// Then
		assertThat(message, is(expectedMessage));
	}
}
