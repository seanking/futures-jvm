package com.rseanking.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * These are not really tests but easy ways to experiment with Futures on 
 * the JVM.
 */
public class FutureTest {
	
	@Test
	public void sayHelloWithFuture() throws Exception{
		final ExecutorService executor = Executors.newFixedThreadPool(1);

		Future<String> futureMessage = executor.submit(() -> {
			return getGreeting();
		});
		
		System.out.println(futureMessage.get());
		System.out.println("Goodbye!");
	}

	@Test
	public void sayHelloWithCompleteableFuture() throws Exception {
	  CompletableFuture
	    .supplyAsync(this::getGreeting)
	    .thenAccept(System.out::println);
	  
	  System.out.println("Goodbye!");
	  Thread.sleep(2000L);
	}
	
	private String getGreeting() {
		System.out.println("Starting async method");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello World!";
	}
}
