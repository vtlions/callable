package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class NumberGenerator implements Callable<Integer> {
	int i;
	int result;

	public NumberGenerator(int i) {
		this.i = i;
	}

	@Override
	public Integer call() throws Exception {
		TimeUnit.SECONDS.sleep(3);
		result = (int) (Math.random() * 500);
		System.out.println("Generator(" + i + ") generates = " + result);
		return result;
	}
}
