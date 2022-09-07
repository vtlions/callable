package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainMain {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(3);
		int i = 0;
		int result = 0;
		Future<Integer>[] f = new Future[50];
		List<Integer> evenNumbers = new ArrayList<>();

		while (evenNumbers.size() < 10) {

			f[i] = es.submit(new NumberGenerator(i));

			try {
				result = f[i].get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

			if (result % 2 == 0) {
				evenNumbers.add(result);
			}
			i++;
		}

		System.out.println(evenNumbers.toString());
		es.shutdown();
	}
}
