package com.ef.eftest.common;

public class Tool {
	public static int before_wait_seconds=5;
	public static int after_wait_seconds=5;

	
	public static void wait(int seconds) {
		try {
			int n=seconds;
			while (n-->0) {
				System.out.printf("wait [%d] seconds,left [%d] seconds\n", seconds, n);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
