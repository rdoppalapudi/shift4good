package com.shift4good.interview.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StringProcessor {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(100);
		StringBuilder sbu = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			try {
				Double[] tmp = service.submit(new Callable<Double[]>() {
					@Override
					public Double[] call() throws Exception {
						// TODO Auto-generated method stub
						Double[] n = new Double[10];
						return n;
					}
				}).get();
				sbu.append(tmp.toString());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(sbu.toString());
		service.shutdown();
		
	}

}
